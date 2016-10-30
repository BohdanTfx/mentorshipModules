package com.epam.mentorship.api.client;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.mentorship.api.client.annotation.ApiClient;
import com.epam.mentorship.api.tracker.PublishService;
import com.epam.mentorship.api.util.MessageBuilder;

@ApiClient
public class AuthenticationApiClient {
    @Autowired
    private PublishService authTracker;

    public boolean authenticateUser(final String userName,
            final String password, final HttpSession session) {
        boolean result = false;
        if ("admin".equals(userName) && "123qwe".equals(password)) {
            session.setAttribute("user", userName);
            session.setAttribute("password", password);
            result = true;
        }
        authTracker
                .trackAuth(
                        MessageBuilder.createMessageBuilder().user(userName)
                                .data(password).result(result).generate(),
                        result);
        return result;
    }

    public boolean logout(final HttpSession session) {
        String user = (String) session.getAttribute("user");
        boolean result = false;
        if (user != null) {
            session.setAttribute("user", null);
            session.setAttribute("password", null);
            result = true;
        }
        authTracker.trackAuth(MessageBuilder.createMessageBuilder().user(user)
                .result(result).generate(), result);
        return result;
    }
}
