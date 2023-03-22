package com.example.medicalcentermanagement.agreement;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Agreement> addAgreement(@RequestBody AgreementRequest agreementRequest) {
        return new ResponseEntity<>(service.addAgreement(agreementRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/patients/{patientId}/projects/{projectId}")
    public void removeAgreement(@PathVariable Long patientId, @PathVariable Long projectId) {
        service.removeAgreement(patientId, projectId);
    }
}
