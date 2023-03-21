package com.example.medicalcentermanagement.testresult;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/results")
@RequiredArgsConstructor
public class TestResultController {

    private final TestResultService service;

    @PostMapping
    public TestResult addTestResult(@RequestBody TestResultRequest testResultRequest) {
        return service.addTestResult(testResultRequest);
    }

    @PutMapping("/{id}")
    public TestResult updateTestResult(@PathVariable Long id, @RequestBody TestResult newResult) {
        return service.updateTestResult(id, newResult);
    }

    @DeleteMapping("/{id}")
    public void deleteTestResult(@PathVariable Long id) {
        service.deleteTestResult(id);
    }
}
