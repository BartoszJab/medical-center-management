package com.example.medicalcentermanagement.agreement;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AgreementResponse {

    private Long id;
    private Long patientId;
    private Long projectId;

    public static AgreementResponse toDto(Agreement agreement) {
        return AgreementResponse.builder()
                .id(agreement.getId())
                .projectId(agreement.getProject().getId())
                .patientId(agreement.getPatient().getId())
                .build();
    }
}
