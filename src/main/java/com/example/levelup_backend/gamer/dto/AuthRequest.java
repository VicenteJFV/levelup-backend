package com.example.levelup_backend.gamer.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
