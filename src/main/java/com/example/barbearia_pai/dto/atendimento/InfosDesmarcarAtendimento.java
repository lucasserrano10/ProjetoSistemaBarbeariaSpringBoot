package com.example.barbearia_pai.dto.atendimento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InfosDesmarcarAtendimento(
        @NotBlank
        Long id,
        @NotNull
        String motivo
) {
}
