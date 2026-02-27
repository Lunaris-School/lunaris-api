package org.example.lunaris.repository;

import org.example.lunaris.model.Aluno;
import org.example.lunaris.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query("""
          SELECT p FROM Professor p WHERE p.cpf = :cpf
           """)
    Professor buscaPorCpf(@Param("cpf") Long cpf);
    @Query("""
        SELECT a
        FROM Aluno a
        JOIN a.turma t
        JOIN t.turmaProfessors tp
        JOIN tp.professor p
        WHERE p.cpf = :cpf
    """)
    List<Aluno> buscarAlunosDoProfessor(@Param("cpf") Long cpf);

    Optional<Professor> findByEmail(String email);
}
