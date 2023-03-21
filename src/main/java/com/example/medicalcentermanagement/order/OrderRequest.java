package com.example.medicalcentermanagement.order;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderRequest {

    private LocalDateTime researchDate;
    private Long patientId;
    private Long projectId;
}
