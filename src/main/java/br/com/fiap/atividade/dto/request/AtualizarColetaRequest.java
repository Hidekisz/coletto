package br.com.fiap.atividade.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
public record AtualizarColetaRequest (
        @NotNull(message="O campo Protocolo é obrigatório")
        String protocolo,
        @NotBlank(message = "CEP do agendamento é obrigatório")
        String cep,
        @NotBlank(message = "Endereco do agendamento é obrigatório")
        String endereco,
        @NotNull(message = "O campo data do agendamento é obrigatório")
        LocalDate dataAgendamento,
        @Pattern(regexp = "true|false", message = "O campo lixoReciclavel deve ser 'true' ou 'false'")
        String lixoReciclavel
) {
    public String getProtocolo() {
        return this.protocolo;
    }
}
