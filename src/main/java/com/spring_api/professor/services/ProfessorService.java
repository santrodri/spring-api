package com.spring_api.professor.services;

import com.spring_api.professor.model.ProfessorModel;
import com.spring_api.professor.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_api.professor.dto.ProfessorDTO;
import com.spring_api.professor.dto.ProfessorDTOSemId;
import com.spring_api.professor.dto.ProfessorMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository, ProfessorMapper professorMapper ){
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
    }

    public ProfessorDTO criaProfessor(ProfessorDTOSemId professorDTOSemId){
        ProfessorModel professorSalvo = professorRepository.save(professorMapper.toEntity(professorDTOSemId));
        return professorMapper.toDTO(professorSalvo);
    }

    public List<ProfessorDTO> recuperaProfessores(){
        List<ProfessorModel> professores = professorRepository.findAll();
        return professores.stream().map(professorMapper::toDTO).collect(Collectors.toList());
    }
}
