package com.example.medicalcentermanagement.agreement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgreementRepository extends JpaRepository<Agreement, Long> {

    Agreement findByPatientIdAndProjectId(Long patientId, Long projectId);
}
