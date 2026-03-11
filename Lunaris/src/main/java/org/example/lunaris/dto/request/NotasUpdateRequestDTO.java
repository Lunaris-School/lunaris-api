package org.example.lunaris.dto.request;

import jakarta.validation.constraints.NotNull;

public class NotasUpdateRequestDTO {
    @NotNull
    private Integer boletimId;

    private Double valorNota;

    private Double valorNota2;

    private String tipoAvaliacao;

    public NotasUpdateRequestDTO() {
    }
    public NotasUpdateRequestDTO(Integer boletimId, Double valorNota, Double valorNota2, String tipoAvaliacao) {
        this.boletimId = boletimId;
        this.valorNota = valorNota;
        this.valorNota2 = valorNota2;
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public Integer getBoletimId() {
        return boletimId;
    }

    public void setBoletimId(Integer boletimId) {
        this.boletimId = boletimId;
    }

    public Double getValorNota() {
        return valorNota;
    }

    public void setValorNota(Double valorNota) {
        this.valorNota = valorNota;
    }

    public Double getValorNota2() {
        return valorNota2;
    }

    public void setValorNota2(Double valorNota2) {
        this.valorNota2 = valorNota2;
    }

    public String getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(String tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

}
