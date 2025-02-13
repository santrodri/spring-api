package com.spring_api.professor.dto;

import com.spring_api.professor.model.ProfessorModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {

    @Mapping(source = "dataNascimento", target = "dataNascimento", qualifiedByName = "localDateToString")
    ProfessorDTO toDTO(ProfessorModel professorModel);

    @Mapping(source = "dataNascimento", target = "dataNascimento", qualifiedByName = "stringToLocalDate")
    ProfessorModel toEntity(ProfessorDTO professorDTO);

    @Mapping(source = "dataNascimento", target = "dataNascimento", qualifiedByName = "stringToLocalDate")
    ProfessorModel toEntity(ProfessorDTOSemId professorDTOSemId);

    @Named("localDateToString")
    default String localDateToString(LocalDate date) {
        return date != null ? date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : null;
    }

    @Named("stringToLocalDate")
    default LocalDate stringToLocalDate(String date) {
        return (date != null && !date.isEmpty()) ? LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")) : null;
    }
}
