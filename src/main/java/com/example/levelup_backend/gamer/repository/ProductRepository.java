package com.example.levelup_backend.gamer.repository;

import com.example.levelup_backend.gamer.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
