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
    private Integer professorId;

    @NotNull
    private Integer disciplinaId;

    public TurmaRequestDTO() {
    }
    public TurmaRequestDTO(String nome, Integer anoLetivo, Integer professorId, Integer disciplinaId) {
        this.nome = nome;
        this.anoLetivo = anoLetivo;
        this.professorId = professorId;
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

    public Integer getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
    }

    public Integer getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Integer disciplinaId) {
        this.disciplinaId = disciplinaId;
    }
}
