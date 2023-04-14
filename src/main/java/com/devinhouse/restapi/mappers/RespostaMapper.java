package com.devinhouse.restapi.mappers;

import com.devinhouse.restapi.dtos.respostaDtos.RespostaCompletoDto;
import com.devinhouse.restapi.dtos.respostaDtos.RespostaRequest;
import com.devinhouse.restapi.models.Resposta;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RespostaMapper {
    Resposta map(RespostaRequest source);
    RespostaCompletoDto map(Resposta source);
    List<RespostaCompletoDto> map(List<Resposta> source);
}
