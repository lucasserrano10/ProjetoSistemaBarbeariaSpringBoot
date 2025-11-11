package com.example.barbearia_pai.dto.cliente;

import com.example.barbearia_pai.domain.cliente.Cliente;

public record DadosDetalhamentoCliente(
        Long id,
        String nome,
        String email,
        String telefone
) {
    public DadosDetalhamentoCliente(Cliente cliente){
        this(cliente.getId(),cliente.getNome(),cliente.getEmail(),cliente.getTelefone());
    }

}
