package com.epam.mentorship.jms.consumer.app.handler;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.mentorship.model.mongo.LogEntry;
import com.epam.mentorship.service.LogEntryService;

@Service
public class AuthenticationHandler implements MessageListener {
    @Autowired
    private LogEntryService logEntryService;

    @Override
    public void onMessage(final Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();

            LogEntry log = new LogEntry("Authentication log", text, "auth");
            logEntryService.logEntry(log);
            textMessage.acknowledge();
        } catch (JMSException jmse) {
            throw new RuntimeException(jmse);
        }
    }

}
