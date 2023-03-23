package com.example.medicalcentermanagement.exception.alreadyexists;

public class ContactDetailsAlreadyExistsException extends RuntimeException {

    public ContactDetailsAlreadyExistsException(Long patientId) {
        super("Contact details for Patient " + patientId + " already exist");
    }
}
