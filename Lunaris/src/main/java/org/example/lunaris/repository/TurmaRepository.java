package org.example.lunaris.repository;


import org.example.lunaris.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TurmaRepository extends JpaRepository<Turma, Integer> {

    @Query("""
          SELECT COUNT(a), t.nome, t.anoLetivo
          FROM Aluno a
          JOIN a.turma t
          WHERE t.anoLetivo = :ano
          GROUP BY t.nome, t.anoLetivo
            """)
    List<Object[]> countAlunosByTurma(@Param("ano") Integer ano);

    @Query("""
          SELECT t.nome, d.nome, AVG((n.valorNota + n.valorNota2) / 2.0)
          FROM Turma t
          JOIN Boletim b on b.turma.id = t.id
          JOIN Notas n on n.boletim.id = b.id
          JOIN Disciplina d on d.id = n.disciplina.id
          GROUP BY t.nome, d.nome
            """)
    List<Object[]> getMediaByDisciplina();

    @Query("""
          SELECT t.nome,
          SUM(CASE WHEN (n.valorNota + n.valorNota2) / 2.0 > 7 THEN 1 ELSE 0 END) AS aprovados,
          SUM(CASE WHEN (n.valorNota + n.valorNota2) / 2.0 = 7 THEN 1 ELSE 0 END) AS em_risco,
          SUM(CASE WHEN (n.valorNota + n.valorNota2) / 2.0 < 7 THEN 1 ELSE 0 END) AS recuperação
          FROM Turma t
          JOIN TurmaProfessor tp on tp.turma.id = t.id
          JOIN Boletim b on b.turma.id = t.id
          JOIN Notas n on n.boletim.id = b.id
          JOIN Disciplina d on d.id = n.disciplina.id
          WHERE tp.professor.cpf = :professorCpf
          GROUP BY t.nome
            """)
    List<Object[]> getQuantidadeStatusByDisciplina(@Param("professorCpf") Long professorCpf);
    Turma findByNome(String nome);
}
