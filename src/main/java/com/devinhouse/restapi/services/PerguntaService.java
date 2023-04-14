package com.devinhouse.restapi.services;

import com.devinhouse.restapi.dtos.perguntaDtos.PerguntaResponse;
import com.devinhouse.restapi.mappers.PerguntaMapper;
import com.devinhouse.restapi.repositories.PerguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerguntaService {
    @Autowired
    private PerguntaRepository repository;

    @Autowired
    private PerguntaMapper mapper;

    public List<PerguntaResponse> getPerguntas() {
        return mapper.map(repository.findAll());
    }



}
