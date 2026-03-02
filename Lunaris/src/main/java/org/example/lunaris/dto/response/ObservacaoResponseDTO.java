package org.example.lunaris.dto.response;

import lombok.*;

@Getter
@Setter
public class ObservacaoResponseDTO {

    private Integer id;
    private Long alunoCpf;
    private Long professorCpf;
    private String observacao;

    public ObservacaoResponseDTO() {
    }
    public ObservacaoResponseDTO(Integer id, Long aluno, Long professorCpf, String observacao) {
        this.id = id;
        this.alunoCpf = aluno;
        this.professorCpf = professorCpf;
        this.observacao = observacao;
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

    public Long getProfessorCpf() {
        return professorCpf;
    }

    public void setProfessorCpf(Long professorCpf) {
        this.professorCpf = professorCpf;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
