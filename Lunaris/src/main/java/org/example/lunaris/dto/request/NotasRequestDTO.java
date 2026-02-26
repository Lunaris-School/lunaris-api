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
    private Integer valorNota;

    @NotNull
    private Integer valorNota2;

    @NotNull
    private String tipoAvaliacao;

    @NotNull
    private LocalDate dataLancamento;

    public NotasRequestDTO() {
    }
    public NotasRequestDTO(Integer boletimId, Integer valorNota, String tipoAvaliacao, LocalDate dataLancamento) {
        this.boletimId = boletimId;
        this.valorNota = valorNota;
        this.tipoAvaliacao = tipoAvaliacao;
        this.dataLancamento = dataLancamento;
    }

    public @NotNull Integer getBoletimId() {
        return boletimId;
    }

    public void setBoletim_id(@NotNull Integer boletimId) {
        this.boletimId = boletimId;
    }

    public @NotNull Integer getValorNota2() {
        return valorNota2;
    }

    public void setValorNota2(@NotNull Integer valorNota2) {
        this.valorNota2 = valorNota2;
    }

    public Integer getValorNota() {
        return valorNota;
    }

    public void setValorNota(Integer valorNota) {
        this.valorNota = valorNota;
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
