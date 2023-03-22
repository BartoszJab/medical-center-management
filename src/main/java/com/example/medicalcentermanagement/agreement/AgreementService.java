package com.example.medicalcentermanagement.agreement;

import com.example.medicalcentermanagement.patient.Patient;
import com.example.medicalcentermanagement.patient.PatientRepository;
import com.example.medicalcentermanagement.researchproject.ResearchProject;
import com.example.medicalcentermanagement.researchproject.ResearchProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgreementService {

    private final AgreementRepository agreementRepository;
    private final ResearchProjectRepository researchProjectRepository;
    private final PatientRepository patientRepository;

    public List<AgreementResponse> getAgreements() {
        return agreementRepository.findAll()
                .stream()
                .map(AgreementResponse::toDto).collect(Collectors.toList());
    }

    public AgreementResponse addAgreement(AgreementRequest agreementRequest) {
        Patient patient = patientRepository.findById(agreementRequest.getPatientId()).orElseThrow();
        ResearchProject project = researchProjectRepository.findById(agreementRequest.getProjectId()).orElseThrow();

        Agreement agreement = agreementRepository.findByPatientIdAndProjectId(agreementRequest.getPatientId(),
                agreementRequest.getProjectId());

        if (agreement != null) {
            throw new IllegalStateException("Agreement already exists");
        }

        Agreement newAgreement = new Agreement();
        newAgreement.setPatient(patient);
        newAgreement.setProject(project);
        agreementRepository.save(newAgreement);

        return AgreementResponse.toDto(newAgreement);
    }

    public void removeAgreement(Long patientId, Long projectId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        ResearchProject researchProject = researchProjectRepository.findById(projectId).orElseThrow();

        Agreement agreement = agreementRepository.findByPatientIdAndProjectId(patientId, projectId);

        if (agreement == null) {
            throw new EntityNotFoundException();
        }

        Set<Patient> projectPatients = researchProject.getPatients();
        projectPatients.remove(patient);
        agreementRepository.delete(agreement);
    }
}
