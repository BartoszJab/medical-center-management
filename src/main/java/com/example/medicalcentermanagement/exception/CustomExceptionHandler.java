package com.example.medicalcentermanagement.exception;

import com.example.medicalcentermanagement.exception.alreadyexists.AgreementAlreadyExistsException;
import com.example.medicalcentermanagement.exception.alreadyexists.ContactDetailsAlreadyExistsException;
import com.example.medicalcentermanagement.exception.alreadyexists.OrderAlreadyExistsException;
import com.example.medicalcentermanagement.exception.notfound.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {
            ProjectNotFoundException.class, OrderNotFoundException.class, ContactDetailsPatientNotFoundException.class,
            PatientNotFoundException.class, TestResultNotFoundException.class, OrderAlreadyExistsException.class,
            ContactDetailsAlreadyExistsException.class, AgreementAlreadyExistsException.class,
            AgreementNotFoundException.class, ContactDetailsNotFoundException.class
    })
    public ResponseEntity<Object> customNotFoundHandler(RuntimeException e) {

        Map<String, Object> exceptionResponse = new HashMap<>() {{
            put("message", e.getMessage());
            put("timestamp", LocalDateTime.now());
        }};

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
