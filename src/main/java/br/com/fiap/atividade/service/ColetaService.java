package br.com.fiap.atividade.service;

import br.com.fiap.atividade.common.AgendamentoNotFoundException;
import br.com.fiap.atividade.dto.request.AgendarColetaRequest;
import br.com.fiap.atividade.dto.request.AtualizarColetaRequest;
import br.com.fiap.atividade.dto.response.AgendamentoColetaResponse;
import br.com.fiap.atividade.dto.response.AgendarColetaResponse;
import br.com.fiap.atividade.dto.response.AtualizarAgendamentoResponse;
import br.com.fiap.atividade.dto.response.CancelarAgendamentoResponse;
import br.com.fiap.atividade.entity.AgendamentoColetaEntity;
import br.com.fiap.atividade.repository.AgendamentoColetaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColetaService {

    @Autowired
    private AgendamentoColetaRepository agendamentoColetaRepository;

    public AgendamentoColetaResponse getAgendamentoId(String protocoloAgendamento) {
        Optional<AgendamentoColetaEntity> optionalAgendamento = agendamentoColetaRepository.findById(protocoloAgendamento);
        if (optionalAgendamento.isPresent()) {
            return new AgendamentoColetaResponse(optionalAgendamento.get());
        } else {
            throw new AgendamentoNotFoundException(protocoloAgendamento);
        }
    }

    public AgendarColetaResponse agendarColeta(AgendarColetaRequest request) {
        AgendamentoColetaEntity agendamentoColetaEntity = new AgendamentoColetaEntity();
        BeanUtils.copyProperties(request,agendamentoColetaEntity);
        return new AgendarColetaResponse(agendamentoColetaRepository.save(agendamentoColetaEntity));
    }

    public AtualizarAgendamentoResponse atualizarAgendamento(AtualizarColetaRequest request) {
        Optional<AgendamentoColetaEntity> optionalAgendamento = agendamentoColetaRepository.findById(request.getProtocolo());
        if (optionalAgendamento.isPresent()) {
            AgendamentoColetaEntity agendamento = optionalAgendamento.get();
            try {
                BeanUtils.copyProperties(request, agendamento);
            } catch (Exception e) {
                e.printStackTrace();
            }
            AgendamentoColetaEntity agendamentoAtualizado = agendamentoColetaRepository.save(agendamento);
            return new AtualizarAgendamentoResponse(agendamentoAtualizado);
        } else {
            throw new AgendamentoNotFoundException(request.getProtocolo());
        }
    }

    public CancelarAgendamentoResponse cancelarAgendamento(String protocoloAgendamento) {
        Optional<AgendamentoColetaEntity> optionalAgendamento = agendamentoColetaRepository.findById(protocoloAgendamento);
        CancelarAgendamentoResponse cancelarResponse = new CancelarAgendamentoResponse();
        cancelarResponse.setProtocolo(protocoloAgendamento);
        cancelarResponse.setMessage("O cancelamento do agendamento de protocolo: " + protocoloAgendamento + " foi feito com sucesso!");
        if(optionalAgendamento.isPresent()){
            agendamentoColetaRepository.delete(optionalAgendamento.get());
        }else{
            throw new AgendamentoNotFoundException(protocoloAgendamento);
        }
        return cancelarResponse;
    }

    public List<AgendamentoColetaEntity> getAllAgendamento() {
        List<AgendamentoColetaEntity> optionalAgendamento = agendamentoColetaRepository.findAll();
        return optionalAgendamento;



    }
}
