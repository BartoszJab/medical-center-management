package com.example.medicalcentermanagement.testresult;

import com.example.medicalcentermanagement.order.Order;
import com.example.medicalcentermanagement.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestResultService {

    private final TestResultRepository resultRepository;
    private final OrderRepository orderRepository;

    public TestResult addTestResult(TestResultRequest testResultRequest) {
        Order order = orderRepository.findById(testResultRequest.getOrderId()).orElseThrow();

        TestResult testResult = new TestResult();
        testResult.setTestType(testResultRequest.getTestType());
        testResult.setResultDescription(testResult.getResultDescription());
        testResult.setOrder(order);

        return resultRepository.save(testResult);
    }

    public TestResult updateTestResult(Long id, TestResult newResult) {
        return resultRepository.findById(id)
                .map(result -> {
                    result.setTestType(newResult.getTestType());
                    result.setResultDescription(newResult.getResultDescription());

                    return resultRepository.save(result);
                }).orElseThrow();
    }

    public void deleteTestResult(Long id) {
        resultRepository.deleteById(id);
    }
}
