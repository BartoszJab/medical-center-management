package com.example.medicalcentermanagement.exception;

public class AgreementAlreadyExistsException extends RuntimeException {

    public AgreementAlreadyExistsException(Long patientId, Long projectId) {
        super("Patient " + patientId + " Project " + projectId + ". Agreement already exists");
    }
}
