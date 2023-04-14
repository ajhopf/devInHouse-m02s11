package com.devinhouse.restapi.mappers;

import com.devinhouse.restapi.dtos.respostaDtos.RespostaRequest;
import com.devinhouse.restapi.dtos.respostaDtos.RespostaResponse;
import com.devinhouse.restapi.models.Resposta;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RespostaMapper {
    Resposta map(RespostaRequest source);
    RespostaResponse map(Resposta source);
    List<RespostaResponse> map(List<Resposta> source);
}
