package org.example.lunaris.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    private Long cpf;

    @Column(length = 50)
    private String nome;

    private Long matricula;

    @Column(length = 250)
    private String email;

    @Column(length = 500)
    private String senha;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "genero_id")
    private Integer generoId;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    @OneToMany(mappedBy = "aluno")
    @JsonIgnore
    private List<Observacao> observacoes;

    public Aluno() {}
    public Aluno(Long cpf, String nome, Long matricula, String email, String senha, Role role, Integer generoId, Turma turma) {
        this.cpf = cpf;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.senha = senha;
        this.role = role;
        this.generoId = generoId;
        this.turma = turma;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Role getRole() {
        return role;
    }

    public void setRole( Role role) {
        this.role = role;
    }

    public Integer getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Integer generoId) {
        this.generoId = generoId;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<Observacao> getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(List<Observacao> observacoes) {
        this.observacoes = observacoes;
    }
}
