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

import org.springframework.stereotype.Service;

@Service
public class PublishService {
    public static final String JNDI_FACTORY = "org.apache.activemq.jndi."
            + "ActiveMQInitialContextFactory";
    public static final String JMS_FACTORY = "ConnectionFactory";
    public static final String AUTH_TOPIC = "dynamicTopics/authDestination";
    public static final String ACTIVITY_TOPIC = "dynamicTopics/"
            + "activityDestination";
    public static final String DEFAULT_URL = "tcp://localhost:61616";
    public static final int AUTH_MESSAGE_PRIORITY = 7;
    private static final long MESSAGE_EXPIRATION_PERIOD = 60000L * 30L;

    private TopicSession pubSession;
    private TopicPublisher authPublisher;
    private TopicPublisher activityPublisher;
    private TopicConnection connection;

    @PostConstruct
    public void init() throws NamingException, JMSException {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
        env.put(Context.PROVIDER_URL, DEFAULT_URL);

        InitialContext jndi = new InitialContext(env);
        TopicConnectionFactory conFactory = (TopicConnectionFactory) jndi
                .lookup(JMS_FACTORY);

        connection = conFactory.createTopicConnection();
        pubSession = connection.createTopicSession(false,
                Session.AUTO_ACKNOWLEDGE);

        Topic authTopic = (Topic) jndi.lookup(AUTH_TOPIC);
        authPublisher = pubSession.createPublisher(authTopic);

        Topic actTopic = (Topic) jndi.lookup(ACTIVITY_TOPIC);
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
            message.setJMSPriority(AUTH_MESSAGE_PRIORITY);
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
        message.setJMSExpiration(MESSAGE_EXPIRATION_PERIOD);
        message.setText(text);
        return message;
    }
}
