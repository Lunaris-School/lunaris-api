package org.example.lunaris.repository;


import org.example.lunaris.model.Observacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ObservacaoRepository extends JpaRepository<Observacao, Integer> {
    List<Observacao> findByAlunoCpf(Long alunoCpf);

    List<Observacao> findByProfessorCpf(Long professorCpf);
}
