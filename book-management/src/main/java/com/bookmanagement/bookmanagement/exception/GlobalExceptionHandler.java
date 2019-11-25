package com.bookmanagement.bookmanagement.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    final String INTERNAL_SERVER_ERROR_MSG = "Something wrong, please contact administrator.";
    final String VALIDATION_ERROR_MSG = "Invalid request.";
    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {

        logger.warn(ex.getMessage());
        final ErrorResponse errorDetails = new ErrorResponse(HttpStatus.NOT_FOUND.toString(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationInputException.class)
    public ResponseEntity<?> validationException(ResourceNotFoundException ex, WebRequest request) {

        logger.warn(ex.getMessage());
        final ErrorResponse errorDetails = new ErrorResponse(HttpStatus.BAD_REQUEST.toString(), VALIDATION_ERROR_MSG, request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> globalExceptionHandler(Throwable ex, WebRequest request) {
        logger.error(ex.getMessage());
        final ErrorResponse errorDetail = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), INTERNAL_SERVER_ERROR_MSG, request.getDescription(false));
        return new ResponseEntity(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
