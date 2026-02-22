package org.example.lunaris.dto.request;

import lombok.*;

@Getter
@Setter
public class GeneroRequestDTO {
    private String nome;

    public GeneroRequestDTO() {
    }
    public GeneroRequestDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
