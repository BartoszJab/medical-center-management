package com.example.medicalcentermanagement.agreement;

import com.example.medicalcentermanagement.patient.Patient;
import com.example.medicalcentermanagement.patient.PatientRepository;
import com.example.medicalcentermanagement.researchproject.ResearchProject;
import com.example.medicalcentermanagement.researchproject.ResearchProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgreementService {

    private final AgreementRepository agreementRepository;
    private final ResearchProjectRepository researchProjectRepository;
    private final PatientRepository patientRepository;

    public List<Agreement> getAgreements() {
        return agreementRepository.findAll();
    }

    public Agreement addAgreement(AgreementRequest agreementRequest) {
        Patient patient = patientRepository.findById(agreementRequest.getPatientId()).orElseThrow();
        ResearchProject project = researchProjectRepository.findById(agreementRequest.getProjectId()).orElseThrow();

        Agreement agreement = new Agreement();
        agreement.setPatient(patient);
        agreement.setProject(project);

        return agreementRepository.save(agreement);
    }

    public void removeAgreement(Long patientId, Long projectId) {
        patientRepository.findById(patientId).orElseThrow();
        researchProjectRepository.findById(projectId).orElseThrow();

        Agreement agreement = agreementRepository.findByPatientIdAndProjectId(patientId, projectId);

        if (agreement == null) {
            throw new EntityNotFoundException();
        }

        agreementRepository.delete(agreement);
    }
}
