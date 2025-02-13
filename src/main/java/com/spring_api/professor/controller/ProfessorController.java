package com.spring_api.professor.controller;

import com.spring_api.professor.dto.ProfessorDTO;
import com.spring_api.professor.dto.ProfessorDTOSemId;
import com.spring_api.professor.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/professor/")
public class ProfessorController {
    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }

    @PostMapping
    public ResponseEntity<ProfessorDTO> criaProfessor(@RequestBody ProfessorDTOSemId professorDTOSemId){
        ProfessorDTO professorSalvo = professorService.criaProfessor(professorDTOSemId);
        URI uri = URI.create("/professor/" + professorSalvo.getId());
        return ResponseEntity.created(uri).body(professorSalvo);
    }

    @GetMapping
    public List<ProfessorDTO> recuperaProfessores(){
        return professorService.recuperaProfessores();
    }
}
