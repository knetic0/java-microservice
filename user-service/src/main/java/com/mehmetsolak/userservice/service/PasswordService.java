package com.mehmetsolak.userservice.service;

public interface PasswordService {
    String encryptPassword(String password);
    boolean checkPassword(String password, String encryptedPassword);
}
