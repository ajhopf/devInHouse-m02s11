package com.devinhouse.restapi.services;

import com.devinhouse.restapi.dtos.respostaDtos.RespostaRequest;
import com.devinhouse.restapi.dtos.respostaDtos.RespostaResponse;
import com.devinhouse.restapi.mappers.RespostaMapper;
import com.devinhouse.restapi.models.Resposta;
import com.devinhouse.restapi.repositories.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespostaService {
    @Autowired
    RespostaRepository repository;
    @Autowired
    RespostaMapper mapper;

    public List<RespostaResponse> getAllRespostas() {

        return mapper.map(repository.findAll());
    }

    public RespostaResponse getRespostaById(Long id) {
        Resposta resposta = repository.getReferenceById(id);

        return mapper.map(resposta);
    }

    public RespostaResponse criarResposta(RespostaRequest request) {
        Resposta resposta = repository.save(mapper.map(request));

        return mapper.map(resposta);
    }

}