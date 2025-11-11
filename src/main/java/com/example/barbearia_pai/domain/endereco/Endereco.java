package com.example.barbearia_pai.domain.endereco;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco() {
    }

    public Endereco(String logradouro, String bairro, String cep, String numero, String complemento, String cidade, String estado) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
    }
}