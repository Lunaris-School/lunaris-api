package org.example.lunaris.repository;

import org.example.lunaris.model.Aluno;
import org.example.lunaris.model.Boletim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoletimRepository extends JpaRepository<Boletim, Integer> {

    List<Boletim> findByAluno(Aluno aluno);

}
