package com.example.medicalcentermanagement.exception.notfound;

public class AgreementNotFoundException extends RuntimeException {

    public AgreementNotFoundException(Long patientId, Long projectId) {
        super("Agreement of patient " + patientId + " for project " + projectId + " not found");
    }
}
