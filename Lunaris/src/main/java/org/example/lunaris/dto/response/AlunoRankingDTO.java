package org.example.lunaris.dto.response;

public class AlunoRankingDTO {
    String nomeAluno;
    Double media;
    String disciplina;
    String nomeProfessor;

    public AlunoRankingDTO() {
    }

    public AlunoRankingDTO(String nomeAluno, Double media, String disciplina, String nomeProfessor) {
        this.nomeAluno = nomeAluno;
        this.media = media;
        this.disciplina = disciplina;
        this.nomeProfessor = nomeProfessor;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }
}
