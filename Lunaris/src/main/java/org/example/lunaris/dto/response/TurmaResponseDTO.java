package org.example.lunaris.dto.response;

import lombok.Getter;

@Getter
public class TurmaResponseDTO {

    private Integer id;
    private String nome;
    private Integer anoLetivo;
    private Long professorCpf;
    private String professorNome;

    public TurmaResponseDTO() {
    }
    public TurmaResponseDTO(Integer id, String nome, Integer anoLetivo, Long professorCpf, String professorNome) {
        this.id = id;
        this.nome = nome;
        this.anoLetivo = anoLetivo;
        this.professorCpf = professorCpf;
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

    public Integer getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(Integer anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public Long getProfessorCpf() {
        return professorCpf;
    }

    public void setProfessorCpf(Long professorCpf) {
        this.professorCpf = professorCpf;
    }

    public String getProfessorNome() {
        return professorNome;
    }

    public void setProfessorNome(String professorNome) {
        this.professorNome = professorNome;
    }
}
