package com.example.barbearia_pai.domain.atendimento;

import com.example.barbearia_pai.exceptions.ValidacaoException;
import com.example.barbearia_pai.service.validacoes.ValidacaoAgendarAtendimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoService {

    @Autowired
    AtendimentoRepository atendimentoRepository;

    @Autowired
    private List<ValidacaoAgendarAtendimento> validarAgendamento;

    public Atendimento cadastrar(Atendimento atendimento) {
        // validar
        validarAgendamento.forEach( v -> {
            try {
                v.validar(atendimento);
            }catch (ValidacaoException e){
                throw new RuntimeException(e);
            }
        });

        return atendimentoRepository.save(atendimento);
    }
}
