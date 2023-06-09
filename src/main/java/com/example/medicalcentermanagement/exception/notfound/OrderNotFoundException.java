package com.example.medicalcentermanagement.exception.notfound;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Long id) {
        super("Order " + id + " not found");
    }
}
