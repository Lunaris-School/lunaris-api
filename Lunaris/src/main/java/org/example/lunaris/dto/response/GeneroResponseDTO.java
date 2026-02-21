package org.example.lunaris.dto.response;

import lombok.*;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class GeneroResponseDTO {
    private Integer id;
    private String nome;

    public GeneroResponseDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public GeneroResponseDTO() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
