package com.example.barbearia_pai.domain.atendimento;

import com.example.barbearia_pai.domain.ServicoTipo;
import com.example.barbearia_pai.domain.barbeiro.Barbeiro;
import com.example.barbearia_pai.domain.cliente.Cliente;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O horário do atendimento é obrigatório")
    @Future(message = "O horário deve ser uma data e hora futura")
    private LocalDateTime dataHora;

    // A duração será sempre 60 minutos (1h), controlada por uma regra de negócio separada
    private Integer duracaoMinutos = 60;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O tipo de serviço é obrigatório")
    private ServicoTipo servico;

    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @NotNull(message = "O cliente é obrigatório")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "barbeiro_id", nullable = false)
    @NotNull(message = "O barbeiro é obrigatório")
    private Barbeiro barbeiro;
}