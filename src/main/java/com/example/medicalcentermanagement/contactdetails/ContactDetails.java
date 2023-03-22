package com.example.medicalcentermanagement.contactdetails;

import com.example.medicalcentermanagement.patient.Patient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ContactDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private String email;
    private String address;

    @OneToOne(mappedBy = "contactDetails", cascade = CascadeType.PERSIST)
    private Patient patient;
}
