package org.example.lunaris.dto.request;

import java.time.LocalDate;

public class ProfessorUpdateRequestDTO {
    private String nome;
    private String email;
    private String senha;
    private Integer disciplinaId;

    public ProfessorUpdateRequestDTO() {
    }

    public ProfessorUpdateRequestDTO( String nome, String email, String senha, int disciplinaId) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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

    public Integer getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Integer disciplinaId) {
        this.disciplinaId = disciplinaId;
    }
}
