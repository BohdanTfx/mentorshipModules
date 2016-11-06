package com.epam.mentorship.jms.consumer.app;

import java.util.Hashtable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.epam.mentorship.jms.consumer.app.handler.ActivityHandler;
import com.epam.mentorship.jms.consumer.app.handler.AuthenticationHandler;

@Service
public class ConsumerServiceInitializer {
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
    @Value("${jms.subscriber.default.auth}")
    private String defaultAuthSubscriber;

    @Autowired
    private ActivityHandler activityHandler;
    @Autowired
    private AuthenticationHandler authHandler;

    private TopicConnection connection;
    private TopicSession subSession;
    private TopicSubscriber activitySubscriber;
    private TopicSubscriber authSubscriber;

    @PostConstruct
    public void init() throws NamingException, JMSException {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
        env.put(Context.PROVIDER_URL, defaultUrl);

        InitialContext jndi = new InitialContext(env);

        TopicConnectionFactory conFactory = (TopicConnectionFactory) jndi
                .lookup(jmsFactory);
        connection = conFactory.createTopicConnection();
        connection.setClientID(defaultAuthSubscriber);
        subSession = connection.createTopicSession(false,
                Session.CLIENT_ACKNOWLEDGE);

        Topic authTopic = (Topic) jndi.lookup(this.authTopic);
        Topic activityTopic = (Topic) jndi.lookup(this.activityTopic);

        authSubscriber = subSession.createDurableSubscriber(authTopic,
                defaultAuthSubscriber, "success = TRUE", true);
        activitySubscriber = subSession.createSubscriber(activityTopic);

        authSubscriber.setMessageListener(authHandler);
        activitySubscriber.setMessageListener(activityHandler);

        connection.start();
    }

    @PreDestroy
    public void close() throws JMSException {
        authSubscriber.close();
        activitySubscriber.close();
        subSession.unsubscribe(defaultAuthSubscriber);
        connection.close();
    }
}
