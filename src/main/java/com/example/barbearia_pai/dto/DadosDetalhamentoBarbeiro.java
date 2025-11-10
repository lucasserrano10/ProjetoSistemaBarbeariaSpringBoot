package com.example.barbearia_pai.dto;

import com.example.barbearia_pai.domain.barbeiro.Barbeiro;

public record DadosDetalhamentoBarbeiro(
        Long id,
        String nome,
        String email,
        String telefone,
        String especialidade
) {
    public DadosDetalhamentoBarbeiro(Barbeiro barbeiro) {
        this(
                barbeiro.getId(),
                barbeiro.getNome(),
                barbeiro.getEmail(),
                barbeiro.getTelefone(),
                barbeiro.getEspecialidade()
        );
    }
}
