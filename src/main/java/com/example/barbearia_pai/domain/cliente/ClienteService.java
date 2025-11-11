package com.example.barbearia_pai.domain.cliente;

import com.example.barbearia_pai.domain.barbeiro.BarbeiroRepository;
import com.example.barbearia_pai.domain.barbeiro.BarbeiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente cadastrar(Cliente cliente) {
        // Validações

        return clienteRepository.save(cliente);
    }
}
