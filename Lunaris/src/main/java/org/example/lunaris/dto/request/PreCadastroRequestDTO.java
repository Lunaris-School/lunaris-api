package org.example.lunaris.dto.request;

import jakarta.validation.constraints.NotNull;

public class PreCadastroRequestDTO {
    @NotNull
    Long alunoCpf;

    @NotNull
    String nome;

    public PreCadastroRequestDTO() {
    }
    public PreCadastroRequestDTO(Long alunoCpf, String nome) {
        this.alunoCpf = alunoCpf;
        this.nome = nome;
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
}
