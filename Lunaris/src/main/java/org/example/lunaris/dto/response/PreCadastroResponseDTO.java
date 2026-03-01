package org.example.lunaris.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class PreCadastroResponseDTO {
    Integer id;
    Long alunoCpf;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime dataAutorizacao;

    public PreCadastroResponseDTO() {
    }
    public PreCadastroResponseDTO(Integer id, Long alunoCpf, LocalDateTime dataAutorizacao) {
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

    public Long getAlunoCpf() {
        return alunoCpf;
    }

    public void setAlunoCpf(Long alunoCpf) {
        this.alunoCpf = alunoCpf;
    }

    public LocalDateTime getDataAutorizacao() {
        return dataAutorizacao;
    }

    public void setDataAutorizacao(LocalDateTime dataAutorizacao) {
        this.dataAutorizacao = dataAutorizacao;
    }
}
