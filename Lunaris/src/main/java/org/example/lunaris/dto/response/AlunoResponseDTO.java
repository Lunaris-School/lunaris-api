package org.example.lunaris.dto.response;

import lombok.*;

@Getter
@Setter
public class AlunoResponseDTO {

    private Long cpf;
    private String nome;
    private Long matricula;
    private String email;
    private Integer generoId;
    private Integer turmaId;

    public AlunoResponseDTO() {}

    public AlunoResponseDTO(Long cpf, String nome, Long matricula, String email, Integer generoId, Integer turmaId) {
        this.cpf = cpf;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.generoId = generoId;
        this.turmaId = turmaId;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Integer generoId) {
        this.generoId = generoId;
    }

    public Integer getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Integer turmaId) {
        this.turmaId = turmaId;
    }
}
