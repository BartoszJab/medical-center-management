package com.example.medicalcentermanagement.exception;

public class ContactDetailsPatientNotFoundException extends RuntimeException {

    public ContactDetailsPatientNotFoundException(Long patientId) {
        super("Contact details for Patient " + patientId + " not found");
    }
}
