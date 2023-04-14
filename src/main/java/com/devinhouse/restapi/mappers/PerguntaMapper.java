package com.devinhouse.restapi.mappers;

import com.devinhouse.restapi.dtos.perguntaDtos.PerguntaCompletoDto;
import com.devinhouse.restapi.dtos.perguntaDtos.PerguntaRequest;
import com.devinhouse.restapi.models.Pergunta;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PerguntaMapper {
    PerguntaCompletoDto map(Pergunta source);
    Pergunta map(PerguntaRequest source);
    List<PerguntaCompletoDto> map(List<Pergunta> source);
}
