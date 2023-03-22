package com.example.medicalcentermanagement.testresult;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long> {

    @Query(value = "SELECT t FROM TestResult t WHERE t.order.patient.id = :patientId")
    List<TestResult> getTestResultsForUser(Long patientId);
}
