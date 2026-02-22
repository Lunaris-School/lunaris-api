package org.example.lunaris.dto.response;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ProfessorResponseDTO {

    private Integer idProfessor;
    private String nome;
    private String email;
    private Long cpf;
    private LocalDate dataContratacao;
    private String disciplina;

    public ProfessorResponseDTO() {
    }
    public ProfessorResponseDTO(Integer idProfessor, String nome, String email, Long cpf, LocalDate dataContratacao, String disciplina) {
        this.idProfessor = idProfessor;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataContratacao = dataContratacao;
        this.disciplina = disciplina;
    }

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
