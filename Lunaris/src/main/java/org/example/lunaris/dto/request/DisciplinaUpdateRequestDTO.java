package org.example.lunaris.dto.request;


public class DisciplinaUpdateRequestDTO {

    String nome;

    String urlFoto;

    public DisciplinaUpdateRequestDTO() {
    }

    public DisciplinaUpdateRequestDTO(String nome, String urlFoto) {
        this.nome = nome;
        this.urlFoto = urlFoto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
