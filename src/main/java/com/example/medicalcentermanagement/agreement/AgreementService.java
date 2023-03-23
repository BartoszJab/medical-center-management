package com.example.medicalcentermanagement.agreement;

import com.example.medicalcentermanagement.exception.alreadyexists.AgreementAlreadyExistsException;
import com.example.medicalcentermanagement.exception.notfound.AgreementNotFoundException;
import com.example.medicalcentermanagement.exception.notfound.PatientNotFoundException;
import com.example.medicalcentermanagement.exception.notfound.ProjectNotFoundException;
import com.example.medicalcentermanagement.patient.Patient;
import com.example.medicalcentermanagement.patient.PatientRepository;
import com.example.medicalcentermanagement.researchproject.ResearchProject;
import com.example.medicalcentermanagement.researchproject.ResearchProjectRepository;
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
        Long patientId = agreementRequest.getPatientId();
        Long projectId = agreementRequest.getProjectId();

        Patient patient =
                patientRepository.findById(patientId).orElseThrow(() -> new PatientNotFoundException(patientId));

        ResearchProject project =
                researchProjectRepository.findById(projectId).orElseThrow(() -> new ProjectNotFoundException(projectId));

        Agreement agreement = agreementRepository.findByPatientIdAndProjectId(patientId, projectId);

        if (agreement != null) {
            throw new AgreementAlreadyExistsException(patientId, projectId);
        }

        Agreement newAgreement = new Agreement();
        newAgreement.setPatient(patient);
        newAgreement.setProject(project);
        agreementRepository.save(newAgreement);

        return AgreementResponse.toDto(newAgreement);
    }

    public void removeAgreement(Long patientId, Long projectId) {
        Patient patient =
                patientRepository.findById(patientId).orElseThrow(() -> new PatientNotFoundException(patientId));

        ResearchProject researchProject =
                researchProjectRepository.findById(projectId).orElseThrow(() -> new ProjectNotFoundException(projectId));

        Agreement agreement = agreementRepository.findByPatientIdAndProjectId(patientId, projectId);

        if (agreement == null) {
            throw new AgreementNotFoundException(patientId, projectId);
        }

        Set<Patient> projectPatients = researchProject.getPatients();
        projectPatients.remove(patient);
        agreementRepository.delete(agreement);
    }
}
