package com.ishmam.DhrubokPracticeProject1.ExceptionManagement.Handlers;

import com.ishmam.DhrubokPracticeProject1.ExceptionManagement.CustomError;
import com.ishmam.DhrubokPracticeProject1.Output.ErrorField;
import com.ishmam.DhrubokPracticeProject1.Output.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerErrors extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<ErrorField> errorFields = new ArrayList<>();

        ex.getBindingResult()
                .getAllErrors()
                .stream()
                .forEach(error -> errorFields.add(
                        new ErrorField(
                                ((FieldError)error).getField(),
                                error.getDefaultMessage()))
                );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new Response<Object>(
                        HttpStatus.BAD_REQUEST,
                        "Please provide all necessary informations.",
                        false,
                        errorFields)
        );
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
          new Response<Object>(HttpStatus.BAD_REQUEST,
                  "Provide correct request method!",
                  false)
        );
    }

    @ExceptionHandler(CustomError.class)
    public ResponseEntity<Object> handleCustomError(CustomError customError){
        return ResponseEntity.status(customError.getStatus()).body(
          new Response<Object>(
                  customError.getStatus(),
                  customError.getMessage(),
                  false,
                  customError.getErrorFieldList())
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException runtimeException){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new Response<Object>(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        runtimeException.getMessage(),
                        false)
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handle(Exception ex,
                                         HttpServletRequest request, HttpServletResponse response) {
        if (ex instanceof NullPointerException) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new Response<>(
                            HttpStatus.BAD_REQUEST,
                            ex.getMessage(),
                            false
                    ));
        }
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Response<>(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        ex.getMessage(),
                        false
                ));
    }
}
