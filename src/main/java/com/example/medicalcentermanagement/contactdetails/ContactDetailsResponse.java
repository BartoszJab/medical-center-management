package com.example.medicalcentermanagement.contactdetails;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContactDetailsResponse {

    private Long id;
    private String phoneNumber;
    private String email;
    private String address;

    public static ContactDetailsResponse toDto(ContactDetails contactDetails) {
        return ContactDetailsResponse.builder()
                .id(contactDetails.getId())
                .address(contactDetails.getAddress())
                .email(contactDetails.getEmail())
                .phoneNumber(contactDetails.getPhoneNumber())
                .build();
    }
}
