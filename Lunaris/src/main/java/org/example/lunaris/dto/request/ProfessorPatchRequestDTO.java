package org.example.lunaris.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProfessorPatchRequestDTO {

    private String nome;
    private String email;
    private String senha;
    private LocalDate dataContratacao;
    private int disciplinaId;

    public ProfessorPatchRequestDTO() {
    }

    public ProfessorPatchRequestDTO( String nome, String email, String senha, LocalDate dataContratacao, int disciplinaId) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataContratacao = dataContratacao;
        this.disciplinaId = disciplinaId;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public Integer getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Integer disciplinaId) {
        this.disciplinaId = disciplinaId;
    }
}