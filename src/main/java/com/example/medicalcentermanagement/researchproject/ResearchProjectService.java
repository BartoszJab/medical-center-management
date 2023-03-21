package com.example.medicalcentermanagement.researchproject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResearchProjectService {

    private final ResearchProjectRepository repository;

    public List<ResearchProject> getProjects() {
        return repository.findAll();
    }

    public ResearchProject createProject(ResearchProject researchProject) {
        return repository.save(researchProject);
    }

    public ResearchProject updateProject(Long id, ResearchProject newResearchProject) {
        return repository.findById(id)
                .map(project -> {
                    project.setTitle(newResearchProject.getTitle());
                    project.setDescription(newResearchProject.getDescription());

                    return repository.save(project);
                }).orElseThrow();
    }

    public void deleteProject(Long id) {
        repository.deleteById(id);
    }
}
