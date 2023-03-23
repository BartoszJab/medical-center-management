package com.example.medicalcentermanagement.exception;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(Long id) {
        super("Patient " + id + " not found");
    }
}
