package com.example.barbearia_pai.service.validacoes;

import com.example.barbearia_pai.domain.atendimento.Atendimento;
import com.example.barbearia_pai.exceptions.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidarHorarioAgendamento implements ValidacaoAgendarAtendimento{


    @Override
    public void validar(Atendimento atendimento) throws ValidacaoException {
        var dataAtendimento = atendimento.getDataHora();
        var domingo = atendimento.getDataHora().getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesAberturaFuncionamento = dataAtendimento.getHour() < 7;
        var depoisFechamentoFuncionamento = dataAtendimento.getHour() > 20;
        if(domingo || antesAberturaFuncionamento || depoisFechamentoFuncionamento){
            throw new ValidacaoException("Atendimento Fora do Horário de Funcionamento");
        }
    }


}
