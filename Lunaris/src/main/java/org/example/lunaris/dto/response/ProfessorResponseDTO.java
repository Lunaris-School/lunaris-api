package org.example.lunaris.dto.response;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ProfessorResponseDTO {

    private Long cpf;
    private String nome;
    private String email;
    private String disciplina;
    private String role;
    private LocalDate dataContratacao;


    public ProfessorResponseDTO() {
    }
    public ProfessorResponseDTO( Long cpf,  String nome, String email, String disciplina, LocalDate dataContratacao) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.disciplina = disciplina;
        this.dataContratacao = dataContratacao;
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
