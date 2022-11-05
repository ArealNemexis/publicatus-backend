package dev.arealnemexis.publicatusnotes.exception;

import org.springframework.http.HttpStatus;

public class GenericException extends Exception {
    private String message;
    private HttpStatus status;

    public GenericException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
