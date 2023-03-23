package com.example.medicalcentermanagement.exception;

public class ContactDetailsNotFoundException extends RuntimeException {

    public ContactDetailsNotFoundException(Long id) {
        super("Contact details " + id + " not found");
    }
}
