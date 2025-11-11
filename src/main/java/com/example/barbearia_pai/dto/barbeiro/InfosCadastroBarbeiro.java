package com.example.barbearia_pai.dto.barbeiro;

import com.example.barbearia_pai.dto.endereco.DadosEndereco;
import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InfosCadastroBarbeiro(
        @NotNull
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        String especialidade,
        @NotNull
        @Valid
        @Embedded
        DadosEndereco endereco
) {

}
