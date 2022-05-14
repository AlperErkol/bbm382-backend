package com.example.bbm382backend.model;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PasswordC {
    private String oldPassword;
    private String newPassword;
    private String newPasswordConfirm;
    private BigInteger userId;
}
