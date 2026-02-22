package org.example.lunaris.repository;


import org.example.lunaris.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TurmaRepository extends JpaRepository<Turma, Integer> {


    Turma findByNome(String nome);
}
