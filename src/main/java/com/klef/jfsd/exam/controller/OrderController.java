package com.klef.jfsd.exam.controller;

import com.klef.jfsd.exam.model.Order;
import com.klef.jfsd.exam.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<String> addOrder(@RequestBody Order order) {
        if (order.getOrderId() == null || order.getOrderId().isEmpty()) {
        	
            return ResponseEntity.badRequest().body("Order ID cannot be null or empty");
            
        }
        try {
        	System.out.println("product added");
            Order savedOrder = orderService.addOrder(order);
            return ResponseEntity.ok("Order added successfully with ID: " + savedOrder.getOrderId());
        } catch (Exception e) {
            e.printStackTrace(); // Log the full exception
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    

    }
}
