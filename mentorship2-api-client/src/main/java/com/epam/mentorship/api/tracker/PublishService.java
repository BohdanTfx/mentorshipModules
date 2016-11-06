package com.epam.mentorship.api.tracker;

import java.util.Hashtable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PublishService {
    @Value("${jms.jndi.factory}")
    private String jndiFactory;
    @Value("${jms.factory}")
    private String jmsFactory;
    @Value("${jms.topics.auth}")
    private String authTopic;
    @Value("${jms.topics.activity}")
    private String activityTopic;
    @Value("${jms.url.default}")
    private String defaultUrl;
    @Value("${jms.message.priority.auth}")
    private int authMessagePriority;
    @Value("${jms.message.expiration.period}")
    private long messageExpirationPeriod;

    private TopicSession pubSession;
    private TopicPublisher authPublisher;
    private TopicPublisher activityPublisher;
    private TopicConnection connection;

    @PostConstruct
    public void init() throws NamingException, JMSException {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
        env.put(Context.PROVIDER_URL, defaultUrl);

        InitialContext jndi = new InitialContext(env);
        TopicConnectionFactory conFactory = (TopicConnectionFactory) jndi
                .lookup(jmsFactory);

        connection = conFactory.createTopicConnection();
        pubSession = connection.createTopicSession(false,
                Session.AUTO_ACKNOWLEDGE);

        Topic authTopic = (Topic) jndi.lookup(this.authTopic);
        authPublisher = pubSession.createPublisher(authTopic);

        Topic actTopic = (Topic) jndi.lookup(activityTopic);
        activityPublisher = pubSession.createPublisher(actTopic);

        connection.start();
    }

    @PreDestroy
    public void close() throws JMSException {
        connection.close();
    }

    public void trackAuth(final String text,
            final Boolean successfulOperation) {
        try {
            TextMessage message = track(text);
            message.setBooleanProperty("success", successfulOperation);
            message.setJMSPriority(authMessagePriority);
            authPublisher.publish(message);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    public void trackActivity(final String text) {
        try {
            TextMessage message = track(text);
            activityPublisher.publish(message);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    private TextMessage track(final String text) throws JMSException {
        TextMessage message = pubSession.createTextMessage();
        message.setJMSExpiration(messageExpirationPeriod);
        message.setText(text);
        return message;
    }
}
