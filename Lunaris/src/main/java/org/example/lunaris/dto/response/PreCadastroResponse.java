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
}
