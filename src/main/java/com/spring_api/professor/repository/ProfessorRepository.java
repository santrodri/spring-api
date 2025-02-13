package com.spring_api.professor.repository;

import com.spring_api.professor.model.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<ProfessorModel, Long> {}
