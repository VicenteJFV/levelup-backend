package com.example.levelup_backend.gamer.controller;

import com.example.levelup_backend.gamer.service.MercadoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private MercadoPagoService mercadoPagoService;

    @PostMapping("/create-preference")
    public ResponseEntity<?> createPreference(@RequestBody Map<String, Object> payload) {
        try {
            String title = (String) payload.get("title");
            BigDecimal price = new BigDecimal(payload.get("price").toString());
            Integer quantity = (Integer) payload.get("quantity");
            String orderId = (String) payload.get("orderId");

            String preferenceId = mercadoPagoService.createPreference(title, price, quantity, orderId);

            Map<String, String> response = new HashMap<>();
            response.put("preferenceId", preferenceId);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error:  " + e.getMessage());
        }
    }
}