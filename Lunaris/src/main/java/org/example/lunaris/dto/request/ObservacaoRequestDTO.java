package org.example.lunaris.dto.request;

import lombok.*;

@Getter
@Setter
public class ObservacaoRequestDTO {

    private Long idAluno;
    private Long idProfessor;
    private String observacao;

    public ObservacaoRequestDTO() {
    }
    public ObservacaoRequestDTO(Long idAluno, Long idProfessor, String observacao) {
        this.idAluno = idAluno;
        this.idProfessor = idProfessor;
        this.observacao = observacao;
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
