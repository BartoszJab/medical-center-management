package com.example.medicalcentermanagement.testresult;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestResultRequest {

    private String testType;
    private String resultDescription;
    private Long orderId;
}
