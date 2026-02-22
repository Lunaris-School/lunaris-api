package org.example.lunaris.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoletimRequestDTO {

    @NotNull
    private Integer alunoId;

    @NotNull
    private Integer disciplinaId;

    public BoletimRequestDTO() {
    }
    public BoletimRequestDTO(Integer alunoId, Integer disciplinaId) {
        this.alunoId = alunoId;
        this.disciplinaId = disciplinaId;
    }

    public Integer getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Integer alunoId) {
        this.alunoId = alunoId;
    }

    public Integer getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Integer disciplinaId) {
        this.disciplinaId = disciplinaId;
    }
}
