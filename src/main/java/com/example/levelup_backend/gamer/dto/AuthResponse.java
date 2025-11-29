package com.example.levelup_backend.gamer.dto;

import com.example.levelup_backend.gamer.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private User user;
}
