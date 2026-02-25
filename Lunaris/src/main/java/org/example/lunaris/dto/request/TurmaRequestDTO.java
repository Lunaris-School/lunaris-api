package org.example.lunaris.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurmaRequestDTO {

    @NotBlank
    @Size(min = 2, max = 2)
    private String nome;

    @NotNull
    @Max(2026)
    private Integer anoLetivo;

    @NotNull
    private Long professorCpf;

    @NotNull
    private Integer disciplinaId;

    public TurmaRequestDTO() {
    }
    public TurmaRequestDTO(String nome, Integer anoLetivo, Long professorCpf, Integer disciplinaId) {
        this.nome = nome;
        this.anoLetivo = anoLetivo;
        this.professorCpf = professorCpf;
        this.disciplinaId = disciplinaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(Integer anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public @NotNull Long getProfessorCpf() {
        return professorCpf;
    }

    public void setProfessorCpf(@NotNull Long professorCpf) {
        this.professorCpf = professorCpf;
    }

    public Integer getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Integer disciplinaId) {
        this.disciplinaId = disciplinaId;
    }
}
