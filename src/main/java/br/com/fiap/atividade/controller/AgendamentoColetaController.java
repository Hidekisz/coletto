package br.com.fiap.atividade.controller;

import br.com.fiap.atividade.common.AgendamentoNotFoundException;
import br.com.fiap.atividade.dto.request.AgendarColetaRequest;
import br.com.fiap.atividade.dto.request.AtualizarColetaRequest;
import br.com.fiap.atividade.dto.response.AgendamentoColetaResponse;
import br.com.fiap.atividade.dto.response.AgendarColetaResponse;
import br.com.fiap.atividade.dto.response.AtualizarAgendamentoResponse;
import br.com.fiap.atividade.dto.response.CancelarAgendamentoResponse;
import br.com.fiap.atividade.entity.AgendamentoColetaEntity;
import br.com.fiap.atividade.service.ColetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/agendamento-coleta")
public class AgendamentoColetaController {

    @Autowired
    private ColetaService coletaService;

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AgendarColetaResponse> agendarColeta(@Valid @RequestBody AgendarColetaRequest request) {
        AgendarColetaResponse response = coletaService.agendarColeta(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<AgendamentoColetaEntity>> getAllAgendamento() {

        List<AgendamentoColetaEntity> response = coletaService.getAllAgendamento();
        return ResponseEntity.ok(response);
    }


    @GetMapping("/get/{protocoloAgendamento}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AgendamentoColetaResponse> getAgendamento(@PathVariable String protocoloAgendamento) {

            AgendamentoColetaResponse response = coletaService.getAgendamentoId(protocoloAgendamento);
            return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AtualizarAgendamentoResponse> atualizarAgendamento(@Valid @RequestBody AtualizarColetaRequest request) {

            AtualizarAgendamentoResponse response = coletaService.atualizarAgendamento(request);
            return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{protocoloAgendamento}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<CancelarAgendamentoResponse> cancelarAgendamento(@PathVariable String protocoloAgendamento) {
            CancelarAgendamentoResponse response = coletaService.cancelarAgendamento(protocoloAgendamento);
            return ResponseEntity.ok(response);
    }
}

