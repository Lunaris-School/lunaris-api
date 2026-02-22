package org.example.lunaris.dto.response;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class NotasResponseDTO {

    private Integer id;
    private Integer valorNota;
    private String tipoAvaliacao;
    private LocalDate dataLancamento;

    public NotasResponseDTO() {
    }
    public NotasResponseDTO(Integer id, Integer valorNota, String tipoAvaliacao, LocalDate dataLancamento) {
        this.id = id;
        this.valorNota = valorNota;
        this.tipoAvaliacao = tipoAvaliacao;
        this.dataLancamento = dataLancamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
