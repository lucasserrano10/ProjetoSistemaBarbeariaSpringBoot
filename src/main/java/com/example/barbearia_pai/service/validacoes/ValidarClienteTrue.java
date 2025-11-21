package com.example.barbearia_pai.service.validacoes;

import com.example.barbearia_pai.domain.atendimento.Atendimento;
import com.example.barbearia_pai.domain.cliente.ClienteRepository;
import com.example.barbearia_pai.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarClienteTrue implements ValidacaoAgendarAtendimento{

    @Autowired
    ClienteRepository clienteRepository;


    @Override
    public void validar(Atendimento atendimento) throws ValidacaoException {
        var clienteId = atendimento.getCliente().getId();
        var clienteExiste = clienteRepository.existsById(clienteId);

        if(!clienteExiste){
            throw new ValidacaoException("Cliente Selecionado para Atendimento não existe");
        }
    }


}
