package org.example.lunaris.repository;

import org.example.lunaris.model.PreCadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface PreCadastroRepository extends JpaRepository<PreCadastro, Integer> {
    Optional<PreCadastro> findByAlunoCpf(BigInteger alunoCpf);
}
