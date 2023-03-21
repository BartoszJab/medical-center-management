package com.example.medicalcentermanagement.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByPatientIdAndProjectId(Long patientId, Long projectId);
}
