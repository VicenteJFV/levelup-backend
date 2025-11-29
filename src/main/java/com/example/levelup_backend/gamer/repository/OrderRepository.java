package com.example.levelup_backend.gamer.repository;

import com.example.levelup_backend.gamer.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
