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

    @ManyToOne
    @JoinColumn(name = "aluno_cpf")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "professor_cpf")
    private Professor professor;

    @Column(length = 500)
    private String observacao;

    public Observacao() {
    }

    public Observacao(Integer id, Aluno aluno, Professor professor, String observacao) {
        this.id = id;
        this.aluno = aluno;
        this.professor = professor;
        this.observacao = observacao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
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
