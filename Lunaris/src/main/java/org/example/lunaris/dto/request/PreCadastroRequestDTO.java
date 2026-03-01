package org.example.lunaris.dto.request;

import jakarta.validation.constraints.NotNull;



public class PreCadastroRequestDTO {
    @NotNull
    Long alunoCpf;

    public PreCadastroRequestDTO() {
    }
    public PreCadastroRequestDTO(Long alunoCpf) {
        this.alunoCpf = alunoCpf;
    }

    public Long getAlunoCpf() {
        return alunoCpf;
    }

    public void setAlunoCpf(Long alunoCpf) {
        this.alunoCpf = alunoCpf;
    }
}
