package com.example.medicalcentermanagement.exception;

public class OrderAlreadyExistsException extends RuntimeException {

    public OrderAlreadyExistsException(Long patientId, Long projectId) {
        super("Patient " + patientId + " Project " + projectId + " already exists");
    }
}
