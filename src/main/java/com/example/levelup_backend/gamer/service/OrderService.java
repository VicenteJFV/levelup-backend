package com.example.levelup_backend.gamer.service;

import com.example.levelup_backend.gamer.model.Order;
import com.example.levelup_backend.gamer.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repo;

    public List<Order> all() {
        return repo.findAll();
    }

    public Order save(Order o) {
        return repo.save(o);
    }
}
