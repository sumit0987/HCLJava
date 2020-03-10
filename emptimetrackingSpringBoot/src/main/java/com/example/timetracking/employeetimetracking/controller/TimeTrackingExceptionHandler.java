package com.example.timetracking.employeetimetracking.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.timetracking.employeetimetracking.Utility.ErrorResponse;
import com.example.timetracking.employeetimetracking.Utility.InvlalidParametersException;
import com.example.timetracking.employeetimetracking.Utility.RecordNotFoundException;

@RestControllerAdvice
public class TimeTrackingExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponse> recordNotFoundException(RecordNotFoundException ex, WebRequest request) 
    {
       
        ErrorResponse error = new ErrorResponse("Request not valid", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
	

    protected ResponseEntity<ErrorResponse> invalidArguments(InvlalidParametersException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse error = new ErrorResponse("parameters not valid", ex.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

}
