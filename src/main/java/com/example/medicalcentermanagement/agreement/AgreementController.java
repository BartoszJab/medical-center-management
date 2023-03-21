package com.example.medicalcentermanagement.agreement;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agreements")
@RequiredArgsConstructor
public class AgreementController {

    private final AgreementService service;

    @GetMapping
    public List<Agreement> getAgreements() {
        return service.getAgreements();
    }

    @PostMapping
    public Agreement addAgreement(@RequestBody AgreementRequest agreementRequest) {
        return service.addAgreement(agreementRequest);
    }

    @DeleteMapping("/patients/{patientId}/projects/{projectId}")
    public void removeAgreement(@PathVariable Long patientId, @PathVariable Long projectId) {
        service.removeAgreement(patientId, projectId);
    }
}
