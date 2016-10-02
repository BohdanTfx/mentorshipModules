package com.epam.mentorship.model.dto;

import java.util.List;

import org.springframework.validation.ObjectError;

public class ApiResponse<T> {
	private T body;
	private List<ObjectError> errors;

	public ApiResponse(T body, List<ObjectError> errors) {
		this.body = body;
		this.errors = errors;
	}

	public List<ObjectError> getErrors() {
		return errors;
	}

	public void setErrors(List<ObjectError> errors) {
		this.errors = errors;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}
}
