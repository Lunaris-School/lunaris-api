package org.example.lunaris.repository;

import org.example.lunaris.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {
    Disciplina findByNome(String nome);
}
