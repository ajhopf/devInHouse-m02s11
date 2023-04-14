package com.devinhouse.restapi.services;

import com.devinhouse.restapi.dtos.respostaDtos.RespostaGetRequest;
import com.devinhouse.restapi.dtos.respostaDtos.RespostaRequest;
import com.devinhouse.restapi.dtos.respostaDtos.RespostaCompletoDto;
import com.devinhouse.restapi.mappers.RespostaMapper;
import com.devinhouse.restapi.models.Resposta;
import com.devinhouse.restapi.repositories.RespostaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespostaService {
    @Autowired
    RespostaRepository repository;
    @Autowired
    RespostaMapper mapper;

    public List<RespostaCompletoDto> getAllRespostas(
            RespostaGetRequest requestParams
    ) {
        if (requestParams.getId_pergunta() == null) {
            return mapper.map(repository.findAll());
        } else {
            return mapper.map(repository.findByPerguntaId(requestParams.getId_pergunta()));
        }

    }

    public RespostaCompletoDto getRespostaById(Long id) {
        Resposta resposta = repository.getReferenceById(id);

        return mapper.map(resposta);
    }

    public RespostaCompletoDto criarResposta(RespostaRequest request) {
        Resposta resposta = repository.save(mapper.map(request));

        return mapper.map(resposta);
    }

    public RespostaCompletoDto atualizarResposta(RespostaCompletoDto request) {
        Resposta resposta = repository.findById(request.getId())
                .orElseThrow(EntityNotFoundException::new);

        if (request.getTexto() != null && request.getTexto().length() > 0) {
            resposta.setTexto(request.getTexto());
        }
        if(request.getId_pergunta() != null) {
            resposta.setId_pergunta(request.getId_pergunta());
        }

        repository.save(resposta);

        return mapper.map(resposta);
    }
}
