package com.epam.mentorship.controller;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    private static final Logger LOG = Logger.getLogger(ErrorHandler.class);

    @ExceptionHandler(Throwable.class)
    public String handle(final Throwable e, final Model model) {
        LOG.error("Unhandled exception was captured in rest API", e);
        model.addAttribute("cause", e.getCause().toString());
        model.addAttribute("cause", e.getClass().getSimpleName());
        model.addAttribute("message", e.getMessage());
        return "error";
    }
}
