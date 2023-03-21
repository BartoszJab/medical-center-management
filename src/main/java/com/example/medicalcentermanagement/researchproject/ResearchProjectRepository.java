package com.example.medicalcentermanagement.researchproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchProjectRepository extends JpaRepository<ResearchProject, Long> {
}
