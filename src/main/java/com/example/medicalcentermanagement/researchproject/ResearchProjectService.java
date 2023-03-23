package com.example.medicalcentermanagement.researchproject;

import com.example.medicalcentermanagement.agreement.Agreement;
import com.example.medicalcentermanagement.agreement.AgreementRepository;
import com.example.medicalcentermanagement.exception.AgreementNotFoundException;
import com.example.medicalcentermanagement.exception.PatientNotFoundException;
import com.example.medicalcentermanagement.exception.ProjectNotFoundException;
import com.example.medicalcentermanagement.patient.Patient;
import com.example.medicalcentermanagement.patient.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResearchProjectService {

    private final ResearchProjectRepository projectRepository;
    private final AgreementRepository agreementRepository;
    private final PatientRepository patientRepository;

    public List<ResearchProject> getProjects() {
        return projectRepository.findAll();
    }

    public ResearchProject createProject(ResearchProject researchProject) {
        return projectRepository.save(researchProject);
    }

    public ResearchProject updateProject(Long id, ResearchProject newResearchProject) {
        return projectRepository.findById(id)
                .map(project -> {
                    project.setTitle(newResearchProject.getTitle());
                    project.setDescription(newResearchProject.getDescription());

                    return projectRepository.save(project);
                }).orElseThrow(() -> new ProjectNotFoundException(id));
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public ResearchProject createPatientProjectAssignment(PatientProjectRequest request) {
        Long patientId = request.getPatientId();
        Long projectId = request.getProjectId();

        Agreement agreement = agreementRepository.findByPatientIdAndProjectId(patientId, projectId);

        if (agreement == null) {
            throw new AgreementNotFoundException(patientId, projectId);
        }

        Patient patient =
                patientRepository.findById(patientId).orElseThrow(() -> new PatientNotFoundException(patientId));

        ResearchProject project =
                projectRepository.findById(projectId).orElseThrow(() -> new ProjectNotFoundException(projectId));

        project.getPatients().add(patient);
        return projectRepository.save(project);
    }

    public void removePatientProjectAssignment(Long patientId, Long projectId) {
        Patient patient =
                patientRepository.findById(patientId).orElseThrow(() -> new PatientNotFoundException(patientId));

        ResearchProject project =
                projectRepository.findById(projectId).orElseThrow(() -> new ProjectNotFoundException(projectId));

        project.getPatients().remove(patient);
        projectRepository.save(project);
    }
}
