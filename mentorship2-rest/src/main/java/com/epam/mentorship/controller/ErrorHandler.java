package com.epam.mentorship.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.epam.mentorship.api.model.dto.ApiResponse;

@ControllerAdvice
public class ErrorHandler {
	private final static Logger LOG = Logger.getLogger(ErrorHandler.class);

	@ExceptionHandler(Throwable.class)
	public ApiResponse<Void> handle(Throwable e) {
		LOG.error("Unhandled exception was captured in rest API", e);
		List<ObjectError> errors = new ArrayList<>();
		errors.add(new ObjectError("cause", e.getCause().toString()));
		errors.add(new ObjectError("message", e.getMessage()));
		return new ApiResponse<>(errors);
	}
}
