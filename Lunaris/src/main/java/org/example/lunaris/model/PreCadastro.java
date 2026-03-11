package org.example.lunaris.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pre_cadastro")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class PreCadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "aluno_cpf")
    private Long alunoCpf;
    private String nome;
    @Column(name = "turma_id")
    private Integer turmaId;
    @Column(name = "data_autorizacao")
    private LocalDateTime dataAutorizacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAlunoCpf() {
        return alunoCpf;
    }

    public void setAlunoCpf(Long alunoCpf) {
        this.alunoCpf = alunoCpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Integer getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Integer turmaId) {
        this.turmaId = turmaId;
    }

    public LocalDateTime getDataAutorizacao() {
        return dataAutorizacao;
    }

    public void setDataAutorizacao(LocalDateTime dataAutorizacao) {
        this.dataAutorizacao = dataAutorizacao;
    }
}