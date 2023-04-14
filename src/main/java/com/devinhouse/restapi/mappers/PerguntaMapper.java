package com.devinhouse.restapi.mappers;

import com.devinhouse.restapi.dtos.perguntaDtos.PerguntaRequest;
import com.devinhouse.restapi.dtos.perguntaDtos.PerguntaResponse;
import com.devinhouse.restapi.models.Pergunta;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PerguntaMapper {
    Pergunta map(PerguntaResponse source);
    PerguntaResponse map(Pergunta source);
    Pergunta map(PerguntaRequest source);
    List<PerguntaResponse> map(List<Pergunta> source);
}
