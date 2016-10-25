package com.epam.mentorship.api.model.dto;

import java.util.List;

import org.springframework.validation.ObjectError;

public class ApiResponse<T> {
    private T body;
    private List<ObjectError> errors;

    public ApiResponse(final List<ObjectError> errors) {
        this.errors = errors;
    }

    public ApiResponse(final T body) {
        this.body = body;
    }

    public ApiResponse(final T body, final List<ObjectError> errors) {
        this.body = body;
        this.errors = errors;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(final List<ObjectError> errors) {
        this.errors = errors;
    }

    public T getBody() {
        return body;
    }

    public void setBody(final T body) {
        this.body = body;
    }
}
