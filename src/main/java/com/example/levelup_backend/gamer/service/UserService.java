package com.example.levelup_backend.gamer.service;

import com.example.levelup_backend.gamer.model.User;
import com.example.levelup_backend.gamer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;

    public User save(User u) {
        return repo.save(u);
    }
}
