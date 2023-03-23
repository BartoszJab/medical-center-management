package com.example.medicalcentermanagement.exception;

public class TestResultNotFoundException extends RuntimeException {

    public TestResultNotFoundException(Long id) {
        super("TestResult " + id + " not found");
    }
}
