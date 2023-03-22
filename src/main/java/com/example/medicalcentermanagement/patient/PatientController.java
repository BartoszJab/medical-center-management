package com.example.medicalcentermanagement.patient;

import com.example.medicalcentermanagement.testresult.TestResult;
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

    @GetMapping("/{patientId}")
    public Patient getPatient(@PathVariable Long patientId) {
        return service.getPatient(patientId);
    }

    @GetMapping("/{patientId}/results")
    public List<TestResult> getAllTestResultsForPatient(@PathVariable Long patientId) {
        return service.getAllTestResultsForPatient(patientId);
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
