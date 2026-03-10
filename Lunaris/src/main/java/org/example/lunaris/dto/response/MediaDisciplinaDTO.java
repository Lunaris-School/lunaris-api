package org.example.lunaris.dto.response;

public class MediaDisciplinaDTO {
    String disciplina;
    Double media;

    public MediaDisciplinaDTO() {
    }
    public MediaDisciplinaDTO(String disciplina, Double media) {
        this.disciplina = disciplina;
        this.media = media;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }
}
