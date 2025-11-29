package com.example.levelup_backend.gamer.controller;

import com.example.levelup_backend.gamer.dto.*;
import com.example.levelup_backend.gamer.model.User;
import com.example.levelup_backend.gamer.repository.UserRepository;
import com.example.levelup_backend.gamer.security.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest req) {

        User u = new User();
        u.setName(req.getName());
        u.setEmail(req.getEmail());
        u.setPassword(encoder.encode(req.getPassword()));
        u.setRole(RoleEnum.ROLE_CLIENT);

        return ResponseEntity.ok(repo.save(u));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest req) {

        User u = repo.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));

        if (!encoder.matches(req.getPassword(), u.getPassword()))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        String token = jwtUtil.generateToken(u.getEmail(), u.getRole().name());

        return ResponseEntity.ok(new AuthResponse(token, u));
    }
}
