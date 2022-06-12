package com.ishmam.DhrubokPracticeProject1.Output;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {
    private HttpStatus status;
    private String message;
    private boolean isExecutes;
    private T data;

    private List<ErrorField> errorFields = new ArrayList<>();

    public Response() {
    }

    // In case of success
    public Response(HttpStatus status, String message, boolean isExecutes, T data) {
        this.status = status;
        this.message = message;
        this.isExecutes = isExecutes;
        this.data = data;
    }

    // In case of Error - 1
    public Response(
            HttpStatus status,
            String message,
            boolean isExecutes,
            List<ErrorField> errorFields) {
        this.status = status;
        this.message = message;
        this.isExecutes = isExecutes;
        this.errorFields = errorFields;
    }

    // In case of Error - 2
    public Response(
            HttpStatus status,
            String message,
            boolean isExecutes) {
        this.status = status;
        this.message = message;
        this.isExecutes = isExecutes;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isExecutes() {
        return isExecutes;
    }

    public void setExecutes(boolean executes) {
        isExecutes = executes;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<ErrorField> getErrorFields() {
        return errorFields;
    }

    public void setErrorFields(List<ErrorField> errorFields) {
        this.errorFields = errorFields;
    }
}
