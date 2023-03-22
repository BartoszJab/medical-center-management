package com.example.medicalcentermanagement.researchproject;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ResearchProjectController {

    private final ResearchProjectService service;

    @GetMapping
    public List<ResearchProject> getProjects() {
        return service.getProjects();
    }

    @PostMapping
    public ResponseEntity<ResearchProject> createProject(@RequestBody ResearchProject researchProject) {
        return new ResponseEntity<>(service.createProject(researchProject), HttpStatus.CREATED);
    }

    @PostMapping("/patients")
    public String assignPatientToProject(@RequestBody PatientProjectRequest request) {
        ResearchProject project = service.createPatientProjectAssignment(request);
        return "Assigned patient " + request.getPatientId() + " to project " + request.getProjectId();
    }

    @PutMapping("/{id}")
    public ResearchProject updateProject(@PathVariable Long id, @RequestBody ResearchProject newResearchProject) {
        return service.updateProject(id, newResearchProject);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        service.deleteProject(id);
    }

    @DeleteMapping("/{projectId}/patients/{patientId}")
    public void removePatientProjectAssignment(@PathVariable Long patientId, @PathVariable Long projectId) {
        service.removePatientProjectAssignment(patientId, projectId);
    }
}
