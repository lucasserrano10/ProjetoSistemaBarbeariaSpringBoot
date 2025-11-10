package com.example.barbearia_pai.domain.barbeiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarbeiroService {

    @Autowired
    BarbeiroRepository barbeiroRepository;

    public Barbeiro cadastrar(Barbeiro barbeiro){
        // Validações futuras
        return barbeiroRepository.save(barbeiro);
    }
}
