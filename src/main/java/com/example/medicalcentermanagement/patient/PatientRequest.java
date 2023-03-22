package com.example.medicalcentermanagement.patient;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PatientRequest {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
}
