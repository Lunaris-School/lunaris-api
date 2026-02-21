package org.example.lunaris.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "aluno")
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
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

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "genero_id")
    private Integer generoId;

    public Aluno() {}
    public Aluno(Long cpf, String nome, Long matricula, String email, String senha, Integer roleId, Integer generoId) {
        this.cpf = cpf;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.senha = senha;
        this.roleId = roleId;
        this.generoId = generoId;
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Integer generoId) {
        this.generoId = generoId;
    }
}
