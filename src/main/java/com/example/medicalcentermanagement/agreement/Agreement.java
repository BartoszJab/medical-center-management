package com.example.medicalcentermanagement.agreement;

import com.example.medicalcentermanagement.patient.Patient;
import com.example.medicalcentermanagement.researchproject.ResearchProject;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private ResearchProject project;
}
