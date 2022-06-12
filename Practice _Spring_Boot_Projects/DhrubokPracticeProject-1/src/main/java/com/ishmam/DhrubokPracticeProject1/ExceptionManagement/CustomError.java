package com.ishmam.DhrubokPracticeProject1.ExceptionManagement;

import com.ishmam.DhrubokPracticeProject1.Output.ErrorField;
import org.springframework.http.HttpStatus;

import java.util.List;

public class CustomError extends RuntimeException {

    private HttpStatus status;
    private String message;
    private List<ErrorField> errorFieldList;

    public CustomError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }


    public CustomError(HttpStatus status, String message, List<ErrorField> errorFieldList) {
        this.status = status;
        this.message = message;
        this.errorFieldList = errorFieldList;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ErrorField> getErrorFieldList() {
        return errorFieldList;
    }

    public void setErrorFieldList(List<ErrorField> errorFieldList) {
        this.errorFieldList = errorFieldList;
    }
}
