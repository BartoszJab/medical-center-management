package com.example.medicalcentermanagement.exception.notfound;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(Long id) {
        super("Project " + id + " not found");
    }
}
