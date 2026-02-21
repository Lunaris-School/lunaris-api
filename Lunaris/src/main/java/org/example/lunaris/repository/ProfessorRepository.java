package org.example.lunaris.repository;

import org.example.lunaris.model.Aluno;
import org.example.lunaris.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    @Query("""
        SELECT p
        FROM Professor p
        WHERE p.escola.idEscola = :escolaId
    """)
    List<Professor> buscarPorEscola(@Param("escolaId") Integer escolaId);

    @Query("""
        SELECT a
        FROM Aluno a
        JOIN a.turma t
        WHERE t.professor.idProfessor = :idProfessor
    """)
    List<Aluno> buscarAlunosDoProfessor(@Param("idProfessor") Integer idProfessor);
}
