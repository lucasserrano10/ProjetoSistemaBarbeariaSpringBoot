package com.example.barbearia_pai.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void salvarBarbeiro(String nome, String login,  String senha, UserRole admin) {
        var user = new User(login, passwordEncoder.encode(senha), nome, admin);
        userRepository.save(user);
    }
}
