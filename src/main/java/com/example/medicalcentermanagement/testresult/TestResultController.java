package com.example.medicalcentermanagement.testresult;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/results")
@RequiredArgsConstructor
public class TestResultController {

    private final TestResultService service;

    @PostMapping
    public ResponseEntity<TestResult> addTestResult(@RequestBody TestResultRequest testResultRequest) {
        return new ResponseEntity<>(service.addTestResult(testResultRequest), HttpStatus.CREATED);
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
