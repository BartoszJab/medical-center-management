package com.example.medicalcentermanagement.order;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class OrderResponse {

    private Long id;
    private LocalDateTime researchDate;
    private Long patientId;
    private Long projectId;

    public static OrderResponse toDto(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .researchDate(order.getResearchDate())
                .patientId(order.getPatient().getId())
                .projectId(order.getProject().getId())
                .build();
    }
}
