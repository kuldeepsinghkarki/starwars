package com.sw.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * SWResourceNotFoundException custom exception for SW resource not found
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SWResourceNotFoundException extends RuntimeException {
    private String message;

    public SWResourceNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
