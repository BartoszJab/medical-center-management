package com.example.medicalcentermanagement.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @GetMapping
    public List<Order> getOrders() {
        return service.getOrders();
    }

    @PostMapping
    public Order createOrder(@RequestBody OrderRequest request) {
        return service.createOrder(request);
    }
}
