package org.example.lunaris.repository;

import org.example.lunaris.model.Aluno;
import org.example.lunaris.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    @Query("""
        SELECT a
        FROM Aluno a
        JOIN a.turma t
        JOIN t.turmaProfessors tp
        JOIN tp.professor p
        WHERE p.idProfessor = :idProfessor
    """)
    List<Aluno> buscarAlunosDoProfessor(@Param("idProfessor") Integer idProfessor);

    Optional<Professor> findByEmail(String email);
}
