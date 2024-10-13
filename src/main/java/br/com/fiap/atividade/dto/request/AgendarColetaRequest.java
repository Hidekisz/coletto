package br.com.fiap.atividade.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AgendarColetaRequest {

        @NotBlank(message = "CEP do agendamento é obrigatório")
        private String cep;

        @NotBlank(message = "Endereco do agendamento é obrigatório")
        private String endereco;

        @NotNull(message = "O campo data do agendamento é obrigatório")
        private LocalDate dataAgendamento;

        @Pattern(regexp = "true|false", message = "O campo lixoReciclavel deve ser 'true' ou 'false'")
        private String lixoReciclavel;

}
