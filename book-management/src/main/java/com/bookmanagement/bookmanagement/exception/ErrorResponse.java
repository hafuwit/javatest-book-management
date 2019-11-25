package com.bookmanagement.bookmanagement.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ErrorResponse implements Serializable {

    private static final long serialVersionUID = 7381245925831587761L;

    private LocalDateTime timestamp;
    private String status;
    private String message;
    private String details;

    public ErrorResponse(final String status, final String message, final String details) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
