package br.com.fiap.atividade.dto.response;

import br.com.fiap.atividade.common.Response;
import br.com.fiap.atividade.entity.AgendamentoColetaEntity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CancelarAgendamentoResponse {
    String message;
    String protocolo;

}
