package com.example.levelup_backend.gamer.service;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.resources.preference.Preference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MercadoPagoService {

    @Value("${mercadopago.access.token}")
    private String accessToken;

    public String createPreference(String title, BigDecimal price, Integer quantity, String orderId) {
        try {
            // Configurar MercadoPago con el access token
            MercadoPagoConfig.setAccessToken(accessToken);

            // Crear item del producto
            PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                    .id(orderId)
                    .title(title)
                    .quantity(quantity)
                    .unitPrice(price)
                    .currencyId("CLP")
                    .build();

            List<PreferenceItemRequest> items = new ArrayList<>();
            items.add(itemRequest);

            // Crear preferencia (SIN backUrls por ahora)
            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(items)
                    .externalReference(orderId)
                    .build();

            PreferenceClient client = new PreferenceClient();
            Preference preference = client.create(preferenceRequest);

            // Retornamos la URL real de pago
            return preference.getInitPoint();

        } catch (Exception e) {
            throw new RuntimeException(
                "Error al crear preferencia de MercadoPago: " + e.getMessage()
            );
        }
    }
}
