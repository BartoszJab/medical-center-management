package com.example.medicalcentermanagement.patient;

import com.example.medicalcentermanagement.contactdetails.ContactDetails;
import com.example.medicalcentermanagement.contactdetails.ContactDetailsRepository;
import com.example.medicalcentermanagement.contactdetails.ContactDetailsResponse;
import com.example.medicalcentermanagement.testresult.TestResult;
import com.example.medicalcentermanagement.testresult.TestResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final TestResultRepository testResultRepository;
    private final ContactDetailsRepository contactDetailsRepository;

    public List<PatientResponse> getPatients() {
        return patientRepository.findAll()
                .stream()
                .map(PatientResponse::toDto).collect(Collectors.toList());
    }

    public PatientResponse createPatient(PatientRequest patientRequest) {
        Patient patient = new Patient();
        patient.setFirstName(patient.getFirstName());
        patient.setLastName(patientRequest.getLastName());
        patient.setDateOfBirth(patientRequest.getDateOfBirth());
        patient.setGender(patient.getGender());
        patientRepository.save(patient);

        return PatientResponse.toDto(patient);
    }

    public PatientResponse updatePatient(Long id, PatientRequest newPatient) {
        return patientRepository.findById(id)
                .map(patient -> {
                    patient.setFirstName(newPatient.getFirstName());
                    patient.setLastName(newPatient.getLastName());
                    patient.setDateOfBirth(newPatient.getDateOfBirth());
                    patientRepository.save(patient);

                    return PatientResponse.toDto(patient);
                }).orElseThrow();
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public PatientResponse getPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        return PatientResponse.toDto(patient);
    }

    public List<TestResult> getAllTestResultsForPatient(Long patientId) {
        return testResultRepository.getTestResultsForUser(patientId);
    }

    public ContactDetailsResponse getContactDetails(Long patientId) {
        ContactDetails contactDetails = contactDetailsRepository.findByPatientId(patientId).orElseThrow();
        return ContactDetailsResponse.toDto(contactDetails);
    }
}
