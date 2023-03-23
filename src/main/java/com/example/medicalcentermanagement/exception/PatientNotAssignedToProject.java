package com.example.medicalcentermanagement.exception;

public class PatientNotAssignedToProject extends RuntimeException {

    public PatientNotAssignedToProject(Long patientId, Long projectId) {
        super("Can't create order because Patient " + patientId + " is not assigned to Project " + projectId);
    }
}
