package com.mehmetsolak.apigateway.service;

public interface JwtService {
    boolean isTokenValid(String jwt);
}
