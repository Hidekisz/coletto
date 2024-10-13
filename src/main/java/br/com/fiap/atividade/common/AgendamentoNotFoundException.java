package br.com.fiap.atividade.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AgendamentoNotFoundException extends RuntimeException {

    public AgendamentoNotFoundException(String id) {
        super("Agendamento de coleta não encontrado com o protocolo: " + id);
    }
}

