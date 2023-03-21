package com.example.medicalcentermanagement.patient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repository;

    public List<Patient> getPatients() {
        return repository.findAll();
    }

    public Patient createPatient(Patient patient) {
        return repository.save(patient);
    }

    public Patient updatePatient(Long id, Patient newPatient) {
        return repository.findById(id)
                .map(patient -> {
                    patient.setFirstName(newPatient.getFirstName());
                    patient.setLastName(newPatient.getLastName());
                    patient.setDateOfBirth(newPatient.getDateOfBirth());
                    patient.setPhoneNumber(newPatient.getPhoneNumber());
                    patient.setEmail(newPatient.getEmail());
                    patient.setAddress(newPatient.getAddress());

                    return repository.save(patient);
                }).orElseThrow();
    }

    public void deletePatient(Long id) {
        repository.deleteById(id);
    }
}
