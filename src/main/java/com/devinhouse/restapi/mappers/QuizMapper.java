package com.devinhouse.restapi.mappers;

import com.devinhouse.restapi.dtos.quizDtos.QuizCompletoDto;
import com.devinhouse.restapi.dtos.quizDtos.QuizRequest;
import com.devinhouse.restapi.models.Quiz;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuizMapper {
    Quiz map(QuizRequest source);
    QuizCompletoDto map(Quiz source);
    List<QuizCompletoDto> map(List<Quiz> source);
}
