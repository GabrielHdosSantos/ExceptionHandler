package com.handler.estudos.handler;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CarHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> carHandler(ConstraintViolationException exception){

        Map<String, String> handler = new HashMap<>();

        exception.getConstraintViolations().forEach(ex -> {
            handler.put(ex.getPropertyPath().toString(), ex.getMessage());
        });


        return handler;
    }


}
