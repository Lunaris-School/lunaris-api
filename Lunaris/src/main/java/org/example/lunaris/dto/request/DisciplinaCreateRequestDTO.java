package org.example.lunaris.dto.request;

import jakarta.validation.constraints.NotNull;


public class DisciplinaCreateRequestDTO {
    @NotNull
     String nome;
    @NotNull
     String urlFoto;

    public DisciplinaCreateRequestDTO() {
    }

    public DisciplinaCreateRequestDTO(String nome, String urlFoto) {
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
