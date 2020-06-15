package com.example.sole_shifter.service;

import com.example.sole_shifter.model.User;
import com.example.sole_shifter.repository.UserRepository;
import com.example.sole_shifter.security.details.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(Authentication authentication) {
        return userRepository.getOne(((UserDetailsImpl) authentication.getPrincipal()).getUser().getId());
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
