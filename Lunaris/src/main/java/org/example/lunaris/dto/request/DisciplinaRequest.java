package org.example.lunaris.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


public class DisciplinaRequest {
    @NotNull
     String nome;
    @NotNull
     String urlFoto;

    public DisciplinaRequest() {
    }

    public DisciplinaRequest(String nome, String urlFoto) {
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
