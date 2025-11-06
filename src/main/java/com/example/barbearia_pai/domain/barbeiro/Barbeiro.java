package com.example.barbearia_pai.domain.barbeiro;

import com.example.barbearia_pai.domain.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Barbeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "O e-mail é obrigatório")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "O telefone é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "O telefone deve conter 11 dígitos (DDD + número)")
    private String telefone;

    private String especialidade;

    @Valid
    @Embedded
    private Endereco endereco;
}