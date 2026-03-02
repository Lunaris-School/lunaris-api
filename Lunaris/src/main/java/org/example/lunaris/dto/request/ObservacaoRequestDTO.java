package org.example.lunaris.dto.request;

import lombok.*;

@Getter
@Setter
public class ObservacaoRequestDTO {

    private Long alunoCpf;
    private Long professorCpf;
    private String observacao;

    public ObservacaoRequestDTO() {
    }
    public ObservacaoRequestDTO(Long alunoCpf, Long professorCpf, String observacao) {
        this.alunoCpf = alunoCpf;
        this.professorCpf = professorCpf;
        this.observacao = observacao;
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
