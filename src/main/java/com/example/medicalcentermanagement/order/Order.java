package com.example.medicalcentermanagement.order;

import com.example.medicalcentermanagement.patient.Patient;
import com.example.medicalcentermanagement.researchproject.ResearchProject;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "laboratory_test_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime researchDate;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private ResearchProject project;
}
