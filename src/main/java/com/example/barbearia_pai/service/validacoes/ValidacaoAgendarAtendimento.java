package com.example.barbearia_pai.service.validacoes;

import com.example.barbearia_pai.domain.atendimento.Atendimento;
import com.example.barbearia_pai.exceptions.ValidacaoException;


public interface ValidacaoAgendarAtendimento {
    void validar(Atendimento atendimento) throws ValidacaoException;
}
