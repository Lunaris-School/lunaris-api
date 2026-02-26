package org.example.lunaris.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class AlunoRequestDTO {

    @NotNull
    private Long cpf;

    @Size(max = 50)
    private String nome;

    private Long matricula;

    @Size(max = 250)
    private String email;

    @Size(max = 500)
    private String senha;

    private Integer generoId;

    public AlunoRequestDTO() {
    }
    public AlunoRequestDTO(Long cpf, String nome, Long matricula, String email, String senha, Integer generoId) {
        this.cpf = cpf;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.senha = senha;
        this.generoId = generoId;
    }

    public @NotNull @CPF Long getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull @CPF Long cpf) {
        this.cpf = cpf;
    }

    public @Size(max = 50) String getNome() {
        return nome;
    }

    public void setNome(@Size(max = 50) String nome) {
        this.nome = nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public @Size(max = 250) String getEmail() {
        return email;
    }

    public void setEmail(@Size(max = 250) String email) {
        this.email = email;
    }

    public @Size(max = 500) String getSenha() {
        return senha;
    }

    public void setSenha(@Size(max = 500) String senha) {
        this.senha = senha;
    }

    public Integer getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Integer generoId) {
        this.generoId = generoId;
    }
}
