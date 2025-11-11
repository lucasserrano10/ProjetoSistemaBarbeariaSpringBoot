package com.example.barbearia_pai.dto.cliente;

import com.example.barbearia_pai.dto.endereco.DadosEndereco;
import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InfosCadastroCliente(
        @NotNull String nome,
        @Email @NotNull String email,
        @NotBlank String telefone,
        @Valid @Embedded DadosEndereco endereco
) {
}
