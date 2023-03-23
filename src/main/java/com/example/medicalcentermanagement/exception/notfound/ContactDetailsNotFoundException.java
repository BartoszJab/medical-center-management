package com.example.medicalcentermanagement.exception.notfound;

public class ContactDetailsNotFoundException extends RuntimeException {

    public ContactDetailsNotFoundException(Long id) {
        super("Contact details " + id + " not found");
    }
}
