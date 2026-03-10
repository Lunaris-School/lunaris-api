package org.example.lunaris.repository;

import org.example.lunaris.model.TurmaDisciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaDisciplinaRepository extends JpaRepository<TurmaDisciplina, Integer> {
}
