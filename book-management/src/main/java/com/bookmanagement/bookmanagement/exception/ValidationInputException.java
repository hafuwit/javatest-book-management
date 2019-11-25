package com.bookmanagement.bookmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ValidationInputException extends RuntimeException {

    public ValidationInputException(String message) {
        super(message);
    }
}
