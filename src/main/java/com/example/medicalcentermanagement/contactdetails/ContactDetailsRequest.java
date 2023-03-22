package com.example.medicalcentermanagement.contactdetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDetailsRequest {

    private String phoneNumber;
    private String email;
    private String address;
    private Long patientId;
}
