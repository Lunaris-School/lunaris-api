package org.example.lunaris.dto.response;

public class AlunoTurmaResponseDTO {
    Long quantidadeAlunos;

    String turma;
    String anoLetivo;

    public AlunoTurmaResponseDTO() {
    }
    public AlunoTurmaResponseDTO(Long quantidadeAlunos, String turma, String anoLetivo) {
        this.quantidadeAlunos = quantidadeAlunos;
        this.turma = turma;
        this.anoLetivo = anoLetivo;
    }

    public Long getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public void setQuantidadeAlunos(Long quantidadeAlunos) {
        this.quantidadeAlunos = quantidadeAlunos;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(String anoLetivo) {
        this.anoLetivo = anoLetivo;
    }
}
