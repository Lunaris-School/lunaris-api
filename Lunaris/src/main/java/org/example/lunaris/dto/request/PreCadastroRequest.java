package org.example.lunaris.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;


public class PreCadastroRequest {
    @NotNull
    BigInteger alunoCpf;

    public PreCadastroRequest() {
    }
    public PreCadastroRequest(BigInteger alunoCpf) {
        this.alunoCpf = alunoCpf;
    }

    public BigInteger getAlunoCpf() {
        return alunoCpf;
    }

    public void setAlunoCpf(BigInteger alunoCpf) {
        this.alunoCpf = alunoCpf;
    }
}
