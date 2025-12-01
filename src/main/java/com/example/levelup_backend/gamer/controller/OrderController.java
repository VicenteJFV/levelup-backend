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

    // GET ALL - Solo ADMIN puede ver todos los pedidos
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<Order> all() {
        return repo.findAll();
    }

    // GET BY ID - Obtener un pedido específico
    @GetMapping("/{id}")
    public ResponseEntity<Order> one(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CREATE - Crear nuevo pedido
    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus("PENDIENTE");
        return ResponseEntity.ok(repo.save(order));
    }

    // UPDATE - Actualizar pedido (solo ADMIN)
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order order) {
        return repo.findById(id)
                .map(existing -> {
                    existing.setCustomerName(order.getCustomerName());
                    existing.setCustomerEmail(order.getCustomerEmail());
                    existing.setTotal(order.getTotal());
                    existing.setStatus(order.getStatus());
                    // No actualizamos createdAt para mantener la fecha original
                    return ResponseEntity.ok(repo.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - Eliminar pedido (solo ADMIN)
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}