package org.example.lunaris.repository;

import org.example.lunaris.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query(value = "SELECT * FROM aluno WHERE cpf = :cpf", nativeQuery = true)
    Aluno buscaPorCpf(@Param("cpf") Long cpf);
}
