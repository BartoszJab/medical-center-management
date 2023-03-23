package com.example.medicalcentermanagement.exception.notfound;

public class TestResultNotFoundException extends RuntimeException {

    public TestResultNotFoundException(Long id) {
        super("TestResult " + id + " not found");
    }
}
