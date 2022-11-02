package dev.arealnemexis.publicatusnotes.model.dtos.response;

import java.io.Serializable;

public class DefaultResponseDto<T> implements Serializable {
    private String message;
    private int status;
    private T result;

    public DefaultResponseDto(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public DefaultResponseDto(String message, int status, T result) {
        this.message = message;
        this.status = status;
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
