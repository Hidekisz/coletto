package br.com.fiap.atividade.dto.response;

import br.com.fiap.atividade.common.Response;
import br.com.fiap.atividade.entity.AgendamentoColetaEntity;
import lombok.*;

import java.time.LocalDate;

@Builder
public record AtualizarAgendamentoResponse(
        String protocolo,
        String cep,
        String endereco,
        LocalDate dataAgendamento,
        String lixoReciclavel
) {

    public AtualizarAgendamentoResponse(AgendamentoColetaEntity agendamento) {
        this(agendamento.getProtocolo()
                , agendamento.getCep()
                , agendamento.getEndereco()
                , agendamento.getDataAgendamento()
                , agendamento.getLixoReciclavel());
    }
}
