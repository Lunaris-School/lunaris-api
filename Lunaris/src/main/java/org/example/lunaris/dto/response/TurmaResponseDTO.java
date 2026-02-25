package org.example.lunaris.dto.response;

import lombok.Getter;

@Getter
public class TurmaResponseDTO {

    private Integer id;
    private String nome;
    private String anoLetivo;
    private Integer professorId;
    private String professorNome;

    public TurmaResponseDTO() {
    }
    public TurmaResponseDTO(Integer id, String nome, String anoLetivo, Integer professorId, String professorNome) {
        this.id = id;
        this.nome = nome;
        this.anoLetivo = anoLetivo;
        this.professorId = professorId;
        this.professorNome = professorNome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(String anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public Integer getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
    }

    public String getProfessorNome() {
        return professorNome;
    }

    public void setProfessorNome(String professorNome) {
        this.professorNome = professorNome;
    }
}
