package br.com.fiap.atividade.repository;

import br.com.fiap.atividade.dto.request.AgendarColetaRequest;
import br.com.fiap.atividade.entity.AgendamentoColetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgendamentoColetaRepository extends MongoRepository<AgendamentoColetaEntity, String> {
    public Optional<AgendamentoColetaEntity> findById(String protocoloAgendamento);
}
