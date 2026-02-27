package org.example.lunaris.dto.response;

import lombok.Getter;

@Getter
public class TurmaResponseDTO {

    private Integer id;
    private String nome;
    private String anoLetivo;


    public TurmaResponseDTO() {
    }
    public TurmaResponseDTO(Integer id, String nome, String anoLetivo) {
        this.id = id;
        this.nome = nome;
        this.anoLetivo = anoLetivo;
    }

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

    public String getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(String anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

}
