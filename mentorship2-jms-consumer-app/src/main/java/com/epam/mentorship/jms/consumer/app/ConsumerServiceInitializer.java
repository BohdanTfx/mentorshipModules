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
import org.springframework.stereotype.Service;

import com.epam.mentorship.jms.consumer.app.handler.ActivityHandler;
import com.epam.mentorship.jms.consumer.app.handler.AuthenticationHandler;

@Service
public class ConsumerServiceInitializer {
    private static final String DEFAULT_AUTH_SUBSCRIBER = "default_auth_subscriber";
    public static final String JNDI_FACTORY = "org.apache.activemq.jndi."
            + "ActiveMQInitialContextFactory";
    public static final String JMS_FACTORY = "ConnectionFactory";
    public static final String AUTH_TOPIC = "dynamicTopics/authDestination";
    public static final String ACTIVITY_TOPIC = "dynamicTopics/"
            + "activityDestination";
    public static final String DEFAULT_URL = "tcp://localhost:61616";
    public static final int AUTH_MESSAGE_PRIORITY = 7;

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
        env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
        env.put(Context.PROVIDER_URL, DEFAULT_URL);

        InitialContext jndi = new InitialContext(env);

        TopicConnectionFactory conFactory = (TopicConnectionFactory) jndi
                .lookup(JMS_FACTORY);
        connection = conFactory.createTopicConnection();
        connection.setClientID(DEFAULT_AUTH_SUBSCRIBER);
        subSession = connection.createTopicSession(false,
                Session.CLIENT_ACKNOWLEDGE);

        Topic authTopic = (Topic) jndi.lookup(AUTH_TOPIC);
        Topic activityTopic = (Topic) jndi.lookup(ACTIVITY_TOPIC);

        authSubscriber = subSession.createDurableSubscriber(
                authTopic, DEFAULT_AUTH_SUBSCRIBER, "success = TRUE", true);
        activitySubscriber = subSession
                .createSubscriber(activityTopic);

        authSubscriber.setMessageListener(authHandler);
        activitySubscriber.setMessageListener(activityHandler);

        connection.start();
    }

    @PreDestroy
    public void close() throws JMSException {
        authSubscriber.close();
        activitySubscriber.close();
        subSession.unsubscribe(DEFAULT_AUTH_SUBSCRIBER);
        connection.close();
    }
}
