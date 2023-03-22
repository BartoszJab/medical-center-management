package com.example.medicalcentermanagement.patient;

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
    private String phoneNumber;
    private String email;
    private String address;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany(mappedBy = "patients")
    List<ResearchProject> projects;

    @OneToOne
    private User user;
}
