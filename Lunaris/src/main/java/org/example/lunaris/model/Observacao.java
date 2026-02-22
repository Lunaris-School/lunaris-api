package org.example.lunaris.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "observacao")
@Getter
@Setter
public class Observacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long idAluno;

    private Long idProfessor;

    @Column(length = 500)
    private String observacao;

    public Observacao() {
    }
    public Observacao(Integer id, Long idAluno, Long idProfessor, String observacao) {
        this.id = id;
        this.idAluno = idAluno;
        this.idProfessor = idProfessor;
        this.observacao = observacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
