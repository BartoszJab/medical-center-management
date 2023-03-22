package com.example.medicalcentermanagement.patient;

import com.example.medicalcentermanagement.contactdetails.ContactDetails;
import com.example.medicalcentermanagement.researchproject.ResearchProject;
import com.example.medicalcentermanagement.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(cascade = CascadeType.REMOVE)
    private ContactDetails contactDetails;

    @ManyToMany(mappedBy = "patients")
    List<ResearchProject> projects;

    @OneToOne
    private User user;
}
