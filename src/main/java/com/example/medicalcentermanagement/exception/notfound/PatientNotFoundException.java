package com.example.medicalcentermanagement.exception.notfound;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(Long id) {
        super("Patient " + id + " not found");
    }
}
