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
            Integer quantity = Integer.parseInt(payload.get("quantity").toString());
            String orderId = payload.get("orderId").toString();

            // Ahora el service devuelve INIT POINT (URL de pago)
            String initPoint = mercadoPagoService.createPreference(
                    title,
                    price,
                    quantity,
                    orderId
            );

            Map<String, String> response = new HashMap<>();
            response.put("initPoint", initPoint);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest()
                    .body("Error al crear preferencia de pago: " + e.getMessage());
        }
    }
}
