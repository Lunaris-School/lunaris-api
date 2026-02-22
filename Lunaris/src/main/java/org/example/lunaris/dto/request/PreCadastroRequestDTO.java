package org.example.lunaris.dto.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;


public class PreCadastroRequestDTO {
    @NotNull
    BigInteger alunoCpf;

    public PreCadastroRequestDTO() {
    }
    public PreCadastroRequestDTO(BigInteger alunoCpf) {
        this.alunoCpf = alunoCpf;
    }

    public BigInteger getAlunoCpf() {
        return alunoCpf;
    }

    public void setAlunoCpf(BigInteger alunoCpf) {
        this.alunoCpf = alunoCpf;
    }
}
