package org.example.lunaris.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter
public class TurmaRequestDTO {

    @NotBlank
    private String nome;

    private Integer anoLetivo = Year.now().getValue();

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
