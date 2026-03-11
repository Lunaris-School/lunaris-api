package org.example.lunaris.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class PreCadastroResponseDTO {
    Integer id;
    Long alunoCpf;
    Integer turmaId;

    String nome;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime dataAutorizacao;

    public PreCadastroResponseDTO() {
    }
    public PreCadastroResponseDTO(Integer id, Long alunoCpf, String nome, Integer turmaId, LocalDateTime dataAutorizacao) {
        this.id = id;
        this.alunoCpf = alunoCpf;
        this.nome = nome;
        this.turmaId = turmaId;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataAutorizacao() {
        return dataAutorizacao;
    }

    public void setDataAutorizacao(LocalDateTime dataAutorizacao) {
        this.dataAutorizacao = dataAutorizacao;
    }

    public Integer getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Integer turmaId) {
        this.turmaId = turmaId;
    }
}