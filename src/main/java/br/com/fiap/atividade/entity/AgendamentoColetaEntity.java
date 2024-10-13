package br.com.fiap.atividade.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "coletas")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoColetaEntity {

    @Id
    private String protocolo; // Para MongoDB, o ID pode ser um String (ObjectId)

    private String cep;
    private String endereco;
    private LocalDate dataAgendamento;
    private String lixoReciclavel;

}
