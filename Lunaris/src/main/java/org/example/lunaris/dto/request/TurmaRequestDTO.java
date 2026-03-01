package org.example.lunaris.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurmaRequestDTO {

    @NotBlank
    @Size(min = 2, max = 2)
    private String nome;

    @NotNull
    @Max(2026)
    private Integer anoLetivo;


    public TurmaRequestDTO() {
    }
    public TurmaRequestDTO(String nome, Integer anoLetivo) {
        this.nome = nome;
        this.anoLetivo = anoLetivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(Integer anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

}
