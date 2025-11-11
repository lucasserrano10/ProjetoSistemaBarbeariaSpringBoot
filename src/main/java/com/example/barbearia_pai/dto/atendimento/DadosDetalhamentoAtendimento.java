package com.example.barbearia_pai.dto.atendimento;

import com.example.barbearia_pai.domain.ServicoTipo;
import com.example.barbearia_pai.domain.atendimento.Atendimento;

import java.time.LocalDateTime;

public record DadosDetalhamentoAtendimento(
        Long id,
        LocalDateTime dataHora,
        ServicoTipo servico,
        String observacoes
) {
    public DadosDetalhamentoAtendimento(Atendimento atendimento){
        this(atendimento.getId(),atendimento.getDataHora(), atendimento.getServico(), atendimento.getObservacoes());
    }
}
