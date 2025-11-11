package com.example.barbearia_pai.domain.atendimento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtendimentoService {

    @Autowired
    AtendimentoRepository atendimentoRepository;

    public Atendimento cadastrar(Atendimento atendimento) {
        // Validações futuras
        return atendimentoRepository.save(atendimento);
    }
}
