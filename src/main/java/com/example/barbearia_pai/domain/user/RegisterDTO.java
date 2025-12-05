package com.example.barbearia_pai.domain.user;

public record RegisterDTO(
        String login,
        String password,
        String nome,
        UserRole role
) {}
