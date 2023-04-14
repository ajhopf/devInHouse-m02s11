package com.devinhouse.restapi.controllers;

import com.devinhouse.restapi.dtos.perguntaDtos.PerguntaCompletoDto;
import com.devinhouse.restapi.dtos.perguntaDtos.PerguntaGetRequest;
import com.devinhouse.restapi.dtos.perguntaDtos.PerguntaRequest;
import com.devinhouse.restapi.services.PerguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/perguntas")
public class PerguntaController {
    @Autowired
    PerguntaService service;

    @GetMapping
    public ResponseEntity<List<PerguntaCompletoDto>> getPerguntas
            (PerguntaGetRequest requestParams) {
        return ResponseEntity.ok(service.getPerguntas(requestParams));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerguntaCompletoDto> getPerguntaById(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getPerguntaById(id));
    }

    @PostMapping
    public ResponseEntity<PerguntaCompletoDto> criarPergunta(
            @RequestBody PerguntaRequest request,
            UriComponentsBuilder uriBuilder) {
        PerguntaCompletoDto pergunta = service.criarPergunta(request);

        URI uri = uriBuilder.path("/perguntas/{id}")
                .buildAndExpand(pergunta.getId()).toUri();

        return ResponseEntity
                .created(uri)
                .body(pergunta);
    }

    @PutMapping
    public ResponseEntity<PerguntaCompletoDto> atualizarPergunta(
            @RequestBody PerguntaCompletoDto request
    ) {
        PerguntaCompletoDto pegunta = service.atualizarPergunta(request);

        return ResponseEntity.ok(pegunta);
    }
}
