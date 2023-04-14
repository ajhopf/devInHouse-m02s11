package com.devinhouse.restapi.controllers;

import com.devinhouse.restapi.dtos.respostaDtos.RespostaCompletoDto;
import com.devinhouse.restapi.dtos.respostaDtos.RespostaGetRequest;
import com.devinhouse.restapi.dtos.respostaDtos.RespostaRequest;
import com.devinhouse.restapi.services.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/respostas")
public class RespostaController {
    @Autowired
    RespostaService service;

    @GetMapping
    public ResponseEntity<List<RespostaCompletoDto>> getAllRespostas(
            RespostaGetRequest requestParams
    ) {
        return ResponseEntity.ok(service.getAllRespostas(requestParams));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespostaCompletoDto> getRespostaById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRespostaById(id));
    }

    @PostMapping
    public ResponseEntity<RespostaCompletoDto> criarResposta(
            @RequestBody RespostaRequest request,
            UriComponentsBuilder uriBuilder) {
        RespostaCompletoDto resposta = service.criarResposta(request);

        URI uri = uriBuilder.path("/respostas/{id}")
                .buildAndExpand(resposta.getId()).toUri();

        return ResponseEntity
                .created(uri)
                .body(resposta);
    }

    @PutMapping
    public ResponseEntity<RespostaCompletoDto> atualizarResposta(
            @RequestBody RespostaCompletoDto request
    ) {
        RespostaCompletoDto resposta = service.atualizarResposta(request);

        return ResponseEntity.ok(resposta);
    }
}
