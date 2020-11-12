package com.zk.msscbrewery.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

// @ControllerAdvice basically tells Spring that ConstraintViolationException and BindException exception thrown by any
// controller would be caught here and dealt accordingly, thereby reducing the duplicated code
@ControllerAdvice
public class MvcExceptionHandler {

    // If validation rules are disobeyed for attributes in @RequestBody in REST POST or PUT request, then the exception
    // messages would be combined here and send back to client
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e) {
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // If the attributes binding of @RequestBody with Dto object fails, then exception would be caught here and would
    // be sent back to the client
    @ExceptionHandler(BindException.class)
    public ResponseEntity<List> handleBindException(BindException e){
        return new ResponseEntity(e.getAllErrors(), HttpStatus.BAD_REQUEST);
    }
}
