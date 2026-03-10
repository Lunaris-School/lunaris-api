package org.example.lunaris.repository;

import org.example.lunaris.model.Aluno;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("""
          SELECT a FROM Aluno a WHERE a.cpf = :cpf
           """)
    Aluno buscaPorCpf(@Param("cpf") Long cpf);

    Optional<Aluno> findByEmail(String email);

    @Query("""
          SELECT COUNT(a), t.nome, t.anoLetivo
          FROM Aluno a
          JOIN a.turma t
          WHERE t.anoLetivo = :ano
          GROUP BY t.nome, t.anoLetivo
            """)
    List<Object[]> countAlunosByTurma(@Param("ano") Integer ano);

    @Query("""
        SELECT a.nome, (n.valorNota + n.valorNota2) / 2, n.disciplina.nome, p.nome
        FROM Aluno a
        JOIN Boletim b on b.aluno.cpf = a.cpf
        JOIN Notas n on n.boletim.id = b.id
        JOIN Professor p on p.disciplina.id = n.disciplina.id
        WHERE n.disciplina.id = :disciplinaId
        ORDER BY (n.valorNota + n.valorNota2) / 2 DESC
    """)
    List<Object[]> rankingAlunos(@Param("disciplinaId") Integer disciplinaId, Pageable pageable);
}
