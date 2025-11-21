package com.example.barbearia_pai.service.validacoes;

import com.example.barbearia_pai.domain.atendimento.Atendimento;
import com.example.barbearia_pai.domain.barbeiro.BarbeiroRepository;
import com.example.barbearia_pai.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarBarbeiroTrue implements ValidacaoAgendarAtendimento{

    @Autowired
    BarbeiroRepository barbeiroRepository;

    @Override
    public void validar(Atendimento atendimento) throws ValidacaoException {
        var barbeiroId = atendimento.getBarbeiro().getId();
        var barbeiroExiste = barbeiroRepository.existsById(barbeiroId);
        if(!barbeiroExiste){
            throw new ValidacaoException("Barbeiro Selecionado para Atendimento não existe");
        }
    }

}
