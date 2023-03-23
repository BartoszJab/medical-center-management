package com.example.medicalcentermanagement.exception;

public class AgreementNotFoundException extends RuntimeException {

    public AgreementNotFoundException(Long patientId, Long projectId) {
        super("Agreement of patient " + patientId + " for project " + projectId + " not found");
    }
}
