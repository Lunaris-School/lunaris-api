package org.example.lunaris.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public class AlunoPatchRequestDTO {
    @Size(max = 50)
    private String nome;

    @Size(max = 250)
    private String email;

    @Size(max = 500)
    private String senha;

    private Integer generoId;
    private Integer turmaId;

    public AlunoPatchRequestDTO() {
    }
    public AlunoPatchRequestDTO(String nome, String email, String senha, Integer generoId, Integer turmaId) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.generoId = generoId;
        this.turmaId = turmaId;
    }



    public @Size(max = 50) String getNome() {
        return nome;
    }

    public void setNome(@Size(max = 50) String nome) {
        this.nome = nome;
    }

    public @Size(max = 250) String getEmail() {
        return email;
    }

    public void setEmail(@Size(max = 250) String email) {
        this.email = email;
    }

    public @Size(max = 500) String getSenha() {
        return senha;
    }

    public void setSenha(@Size(max = 500) String senha) {
        this.senha = senha;
    }

    public Integer getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Integer generoId) {
        this.generoId = generoId;
    }

    public Integer getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Integer turmaId) {
        this.turmaId = turmaId;
    }
}
