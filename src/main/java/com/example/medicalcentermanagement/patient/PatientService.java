package com.example.medicalcentermanagement.patient;

import com.example.medicalcentermanagement.contactdetails.ContactDetails;
import com.example.medicalcentermanagement.contactdetails.ContactDetailsRepository;
import com.example.medicalcentermanagement.contactdetails.ContactDetailsResponse;
import com.example.medicalcentermanagement.testresult.TestResult;
import com.example.medicalcentermanagement.testresult.TestResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final TestResultRepository testResultRepository;
    private final ContactDetailsRepository contactDetailsRepository;

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient newPatient) {
        return patientRepository.findById(id)
                .map(patient -> {
                    patient.setFirstName(newPatient.getFirstName());
                    patient.setLastName(newPatient.getLastName());
                    patient.setDateOfBirth(newPatient.getDateOfBirth());

                    return patientRepository.save(patient);
                }).orElseThrow();
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public Patient getPatient(Long patientId) {
        return patientRepository.findById(patientId).orElseThrow();
    }

    public List<TestResult> getAllTestResultsForPatient(Long patientId) {
        return testResultRepository.getTestResultsForUser(patientId);
    }

    public ContactDetailsResponse getContactDetails(Long patientId) {
        ContactDetails contactDetails = contactDetailsRepository.findByPatientId(patientId).orElseThrow();
        return ContactDetailsResponse.toDto(contactDetails);
    }
}
