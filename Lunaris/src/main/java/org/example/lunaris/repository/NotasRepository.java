package org.example.lunaris.repository;

import org.example.lunaris.model.Notas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotasRepository extends JpaRepository<Notas, Integer> {

    List<Notas> findByBoletimId(Integer boletimId);

}
