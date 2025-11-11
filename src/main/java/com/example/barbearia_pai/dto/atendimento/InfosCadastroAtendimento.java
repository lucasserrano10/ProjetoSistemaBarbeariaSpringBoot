package com.example.barbearia_pai.dto.atendimento;

import com.example.barbearia_pai.domain.ServicoTipo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record InfosCadastroAtendimento(

        @NotNull(message = "O horário do atendimento é obrigatório")
        @Future(message = "O horário deve ser uma data e hora futura")
        LocalDateTime localDateTime,

        @Enumerated(EnumType.STRING)
        @NotNull(message = "O tipo de serviço é obrigatório")
        ServicoTipo servico,

        String observacoes,

        @NotNull(message = "O ID do barbeiro é obrigatório")
        Long idBarbeiro,

        @NotNull(message = "O ID do cliente é obrigatório")
        Long idCliente
) {
}
