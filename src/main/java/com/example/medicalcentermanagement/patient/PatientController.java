package com.example.medicalcentermanagement.patient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService service;

    @GetMapping
    public List<Patient> getPatients() {
        return service.getPatients();
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return service.createPatient(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient newPatient) {
        return service.updatePatient(id, newPatient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        service.deletePatient(id);
    }
}
