package com.epam.mentorship.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.mentorship.api.client.AuthenticationApiClient;

@Controller
@RequestMapping(
        path = "/auth")
public class AuthController {
    @Autowired
    private AuthenticationApiClient authClient;

    @RequestMapping(
            path = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(
            path = "/login", method = RequestMethod.POST)
    public String login(@RequestParam final String username,
            @RequestParam final String password, final HttpSession session,
            final Model model) {
        boolean authResult = authClient.authenticateUser(username, password,
                session);
        model.addAttribute("authResult", authResult);
        return "login";
    }

    @RequestMapping(
            path = "/logout", method = RequestMethod.GET)
    public String logout(final HttpSession session, final Model model) {
        boolean logoutResult = authClient.logout(session);
        model.addAttribute("logoutResult", logoutResult);
        return "logout";
    }
}
