package com.example.levelup_backend.gamer.controller;

import com.example.levelup_backend.gamer.model.Order;
import com.example.levelup_backend.gamer.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderRepository repo;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<Order> all() {
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus("PENDIENTE");
        return ResponseEntity.ok(repo.save(order));
    }
}
