package org.example.lunaris.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "observacoes")
@Getter
@Setter
public class Observacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="aluno_cpf")
    private Long alunoCpf;

    @Column(name = "professor_cpf")
    private Long professorCpf;

    @Column(length = 500)
    private String observacao;

    public Observacao() {
    }

    public Observacao(Integer id, Long alunoCpf, Long professorCpf, String observacao) {
        this.id = id;
        this.alunoCpf = alunoCpf;
        this.professorCpf = professorCpf;
        this.observacao = observacao;
    }

    public Long getAlunoCpf() {
        return alunoCpf;
    }

    public void setAlunoCpf(Long alunoCpf) {
        this.alunoCpf = alunoCpf;
    }

    public Long getProfessorCpf() {
        return professorCpf;
    }

    public void setProfessorCpf(Long professorCpf) {
        this.professorCpf = professorCpf;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
