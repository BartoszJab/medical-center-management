package com.example.medicalcentermanagement.contactdetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Long> {
}
