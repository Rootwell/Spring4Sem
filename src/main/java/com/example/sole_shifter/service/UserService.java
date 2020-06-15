package com.example.sole_shifter.service;

import com.example.sole_shifter.model.User;
import org.springframework.security.core.Authentication;

import java.util.Optional;

public interface UserService {
    User getUser(Authentication authentication);
    Optional<User> getUserByEmail(String email);
}
