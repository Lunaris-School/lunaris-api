package org.example.lunaris.dto.response;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class PreCadastroResponse {
    Integer id;
    BigInteger alunoCpf;
    LocalDateTime dataAutorizacao;
    public PreCadastroResponse() {
    }
    public PreCadastroResponse(Integer id, BigInteger alunoCpf, LocalDateTime dataAutorizacao) {
        this.id = id;
        this.alunoCpf = alunoCpf;
        this.dataAutorizacao = dataAutorizacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getAlunoCpf() {
        return alunoCpf;
    }

    public void setAlunoCpf(BigInteger alunoCpf) {
        this.alunoCpf = alunoCpf;
    }

    public LocalDateTime getDataAutorizacao() {
        return dataAutorizacao;
    }

    public void setDataAutorizacao(LocalDateTime dataAutorizacao) {
        this.dataAutorizacao = dataAutorizacao;
    }
}
