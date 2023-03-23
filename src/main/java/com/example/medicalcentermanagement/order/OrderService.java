package com.example.medicalcentermanagement.order;

import com.example.medicalcentermanagement.exception.OrderAlreadyExistsException;
import com.example.medicalcentermanagement.exception.PatientNotFoundException;
import com.example.medicalcentermanagement.exception.ProjectNotFoundException;
import com.example.medicalcentermanagement.patient.Patient;
import com.example.medicalcentermanagement.patient.PatientRepository;
import com.example.medicalcentermanagement.researchproject.ResearchProject;
import com.example.medicalcentermanagement.researchproject.ResearchProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ResearchProjectRepository projectRepository;
    private final PatientRepository patientRepository;

    public List<OrderResponse> getOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderResponse::toDto).collect(Collectors.toList());
    }

    public OrderResponse createOrder(OrderRequest orderRequest) {
        Long patientId = orderRequest.getPatientId();
        Long projectId = orderRequest.getProjectId();

        Patient patient =
                patientRepository.findById(patientId).orElseThrow(() -> new PatientNotFoundException(patientId));

        ResearchProject project =
                projectRepository.findById(projectId).orElseThrow(() -> new ProjectNotFoundException(projectId));

        Order order = orderRepository.findByPatientIdAndProjectId(orderRequest.getPatientId(),
                orderRequest.getProjectId());

        if (order != null) {
            throw new OrderAlreadyExistsException(patientId, projectId);
        }

        Order newOrder = new Order();
        newOrder.setResearchDate(orderRequest.getResearchDate());
        newOrder.setPatient(patient);
        newOrder.setProject(project);
        orderRepository.save(newOrder);

        return OrderResponse.toDto(newOrder);
    }
}
