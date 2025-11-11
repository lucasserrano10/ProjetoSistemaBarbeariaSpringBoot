package com.example.barbearia_pai.domain.atendimento;

import com.example.barbearia_pai.domain.ServicoTipo;
import com.example.barbearia_pai.domain.barbeiro.Barbeiro;
import com.example.barbearia_pai.domain.cliente.Cliente;
import com.example.barbearia_pai.dto.atendimento.InfosCadastroAtendimento;
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

    public Atendimento(InfosCadastroAtendimento infos) {
        this.dataHora = infos.localDateTime();
        this.servico = infos.servico();
        this.observacoes = infos.observacoes();
        this.barbeiro = new Barbeiro(infos.idBarbeiro());
        this.cliente = new Cliente(infos.idCliente());
    }

    public Long getId() {
        return id;
    }

    public @NotNull(message = "O horário do atendimento é obrigatório") @Future(message = "O horário deve ser uma data e hora futura") LocalDateTime getDataHora() {
        return dataHora;
    }


    public @NotNull(message = "O tipo de serviço é obrigatório") ServicoTipo getServico() {
        return servico;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public @NotNull(message = "O cliente é obrigatório") Cliente getCliente() {
        return cliente;
    }

    public @NotNull(message = "O barbeiro é obrigatório") Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public Atendimento(){

    }
}