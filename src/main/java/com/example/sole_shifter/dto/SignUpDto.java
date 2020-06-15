package com.example.sole_shifter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUpDto {

    private String email;

    private String nickName;

    private String password;

    private String repeatPassword;
}
