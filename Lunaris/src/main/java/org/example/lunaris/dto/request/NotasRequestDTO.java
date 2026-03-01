package org.example.lunaris.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class NotasRequestDTO {

    @NotNull
    private Integer boletimId;

    @NotNull
    private Double valorNota;

    @NotNull
    private Double valorNota2;

    @NotNull
    private Integer disciplinaId;

    @NotNull
    private String tipoAvaliacao;

    @NotNull
    private LocalDate dataLancamento;

    public NotasRequestDTO() {
    }
    public NotasRequestDTO(Integer boletimId, Double valorNota, Double valorNota2, Integer disciplinaId, String tipoAvaliacao, LocalDate dataLancamento) {
        this.boletimId = boletimId;
        this.valorNota = valorNota;
        this.valorNota2 = valorNota2;
        this.disciplinaId = disciplinaId;
        this.tipoAvaliacao = tipoAvaliacao;
        this.dataLancamento = dataLancamento;
    }

    public @NotNull Integer getBoletimId() {
        return boletimId;
    }

    public void setBoletimId(@NotNull Integer boletimId) {
        this.boletimId = boletimId;
    }

    public @NotNull Double getValorNota2() {
        return valorNota2;
    }

    public void setValorNota2(@NotNull Double valorNota2) {
        this.valorNota2 = valorNota2;
    }

    public Double getValorNota() {
        return valorNota;
    }

    public void setValorNota(Double valorNota) {
        this.valorNota = valorNota;
    }

    public Integer getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Integer disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public String getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(String tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
