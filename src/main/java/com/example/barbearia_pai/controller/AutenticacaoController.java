package com.example.barbearia_pai.controller;

import com.example.barbearia_pai.domain.user.AuthenticationDTO;
import com.example.barbearia_pai.domain.user.User;
import com.example.barbearia_pai.domain.user.UserRepository;
import com.example.barbearia_pai.domain.user.RegisterDTO;
import com.example.barbearia_pai.dto.token.LoginResponseDTO;
import com.example.barbearia_pai.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(),data.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = passwordEncoder.encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.nome(), data.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }


}
