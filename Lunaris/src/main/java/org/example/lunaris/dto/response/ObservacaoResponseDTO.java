package org.example.lunaris.dto.response;

import lombok.*;

@Getter
@Setter
public class ObservacaoResponseDTO {

    private Integer id;
    private Long idAluno;
    private Long idProfessor;
    private String observacao;

    public ObservacaoResponseDTO() {
    }
    public ObservacaoResponseDTO(Integer id, Long idAluno, Long idProfessor, String observacao) {
        this.id = id;
        this.idAluno = idAluno;
        this.idProfessor = idProfessor;
        this.observacao = observacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
