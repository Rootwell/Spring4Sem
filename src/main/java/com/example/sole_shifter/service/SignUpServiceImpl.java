package com.example.sole_shifter.service;

import com.example.sole_shifter.dto.SignUpDto;
import com.example.sole_shifter.model.User;
import com.example.sole_shifter.model.type.Role;
import com.example.sole_shifter.model.type.State;
import com.example.sole_shifter.repository.UserRepository;
import com.example.sole_shifter.util.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    FileStorageService fileStorageService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean signUp(SignUpDto signUpDto) {
        if (isExist(signUpDto.getEmail(), signUpDto.getNickName())) {
            return false;
        }
        if (signUpDto.getPassword().length() < 8) {
            return false;
        }
        if (!signUpDto.getPassword().equals(signUpDto.getRepeatPassword())) {
            return false;
        }
        if (!(new EmailValidator()).validate(signUpDto.getEmail())) {
            return false;
        }
        User user = User.builder()
                .email(signUpDto.getEmail())
                .nickName(signUpDto.getNickName())
                .avatarPath(fileStorageService.getSOURSE_PATH() + "/document/img/defaultAvatar.png")
                .regdate(new Date())
                .hashedPassword(passwordEncoder.encode(signUpDto.getPassword()))
                .role(Role.ORD_USER)
                .state(State.CONFIRMED)
                .build();
        userRepository.save(user);
        return true;
    }

    private boolean isExist(String email, String nickName) {
        return userRepository.findUserByEmail(email).isPresent()
                || userRepository.findUserByNickName(nickName).isPresent();
    }
}
