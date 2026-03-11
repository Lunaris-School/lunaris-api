package org.example.lunaris.dto.request;

import jakarta.validation.constraints.NotNull;

public class PreCadastroRequestDTO {
    @NotNull
    Long alunoCpf;

    @NotNull
    String nome;
    Integer turmaId;

    public PreCadastroRequestDTO() {
    }
    public PreCadastroRequestDTO(Long alunoCpf, String nome, Integer turmaId) {
        this.alunoCpf = alunoCpf;
        this.nome = nome;
        this.turmaId = turmaId;
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
    public void setTurmaId(Integer turmaId) {this.turmaId = turmaId;}
}
