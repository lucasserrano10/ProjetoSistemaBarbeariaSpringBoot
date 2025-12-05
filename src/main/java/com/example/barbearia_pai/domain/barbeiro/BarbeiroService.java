package com.example.barbearia_pai.domain.barbeiro;

import com.example.barbearia_pai.domain.user.UserRepository;
import com.example.barbearia_pai.domain.user.UserRole;
import com.example.barbearia_pai.domain.user.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarbeiroService {

    @Autowired
    BarbeiroRepository barbeiroRepository;

    @Autowired
    UsuarioService usuarioService;

    public Barbeiro cadastrar(Barbeiro barbeiro){
        usuarioService.salvarBarbeiro(barbeiro.getNome(), barbeiro.getEmail(), barbeiro.getTelefone(), UserRole.ADMIN);
        return barbeiroRepository.save(barbeiro);
    }
}
