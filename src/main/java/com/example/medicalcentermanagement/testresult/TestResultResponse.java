package com.example.medicalcentermanagement.testresult;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TestResultResponse {

    private Long id;
    private String testType;
    private String resultDescription;

    public static TestResultResponse toDto(TestResult testResult) {
        return TestResultResponse.builder()
                .id(testResult.getId())
                .testType(testResult.getTestType())
                .resultDescription(testResult.getResultDescription())
                .build();

    }
}
