package com.epam.mentorship.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	private final static Logger LOG = Logger.getLogger(ErrorHandler.class);

	@ExceptionHandler(Throwable.class)
	public String handle(Throwable e) {
		LOG.error("Unhandled exception was captured", e);
		return "error";
	}
}
