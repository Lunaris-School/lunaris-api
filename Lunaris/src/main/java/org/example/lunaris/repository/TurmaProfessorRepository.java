package org.example.lunaris.repository;

import org.example.lunaris.model.TurmaProfessor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TurmaProfessorRepository extends JpaRepository<TurmaProfessor, Integer> {

    List<TurmaProfessor> findByProfessorId(Integer professorId);
}
