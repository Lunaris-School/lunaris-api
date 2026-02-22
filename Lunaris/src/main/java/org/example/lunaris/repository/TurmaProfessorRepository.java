package org.example.lunaris.repository;

import jakarta.transaction.Transactional;
import org.example.lunaris.model.Professor;
import org.example.lunaris.model.TurmaProfessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TurmaProfessorRepository extends JpaRepository<TurmaProfessor, Integer> {

    List<TurmaProfessor> findByProfessor(Professor professor);

    @Modifying
    @Transactional
    @Query("""
        DELETE FROM TurmaProfessor tp
        WHERE tp.professor.idProfessor = :idProfessor
        """)

    void deleteByProfessor(@Param("idProfessor") Integer idProfessor);

    @Modifying
    @Transactional
    @Query("""
        DELETE FROM TurmaProfessor tp
        WHERE tp.turma.id = :idTurma
        """)

    void deleteByTurma(@Param("idTurma") Integer idTurma);

}
