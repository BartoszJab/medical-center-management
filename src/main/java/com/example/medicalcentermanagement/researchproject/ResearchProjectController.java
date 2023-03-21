package com.example.medicalcentermanagement.researchproject;

import lombok.RequiredArgsConstructor;
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
    public ResearchProject createProject(@RequestBody ResearchProject researchProject) {
        return service.createProject(researchProject);
    }

    @PutMapping("/{id}")
    public ResearchProject updateProject(@PathVariable Long id, @RequestBody ResearchProject newResearchProject) {
        return service.updateProject(id, newResearchProject);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        service.deleteProject(id);
    }
}
