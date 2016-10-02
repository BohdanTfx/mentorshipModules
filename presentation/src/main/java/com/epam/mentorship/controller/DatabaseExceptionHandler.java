package com.epam.mentorship.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.epam.mentorship.exception.DatabaseException;

@ControllerAdvice
public class DatabaseExceptionHandler {

	@ExceptionHandler(DatabaseException.class)
	public String handle(DatabaseException e) {
		return "databaseError";
	}
}
