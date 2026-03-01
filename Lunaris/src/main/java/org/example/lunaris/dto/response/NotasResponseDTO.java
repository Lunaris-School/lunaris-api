package org.example.lunaris.dto.response;

import lombok.Getter;
import org.example.lunaris.Enum.AprovacaoEnum;

import java.time.LocalDate;

@Getter
public class NotasResponseDTO {

    private Integer id;
    private Double valorNota;
    private Double valorNota2;
    private Integer disciplinaId;
    private String disciplinaNome;
    private String tipoAvaliacao;
    private String status;
    private LocalDate dataLancamento;

    public NotasResponseDTO() {
    }
    public NotasResponseDTO(Integer id, Double valorNota, Double valorNota2, String tipoAvaliacao, Integer disciplinaId, String disciplinaNome, LocalDate dataLancamento) {
        this.id = id;
        this.valorNota = valorNota;
        this.valorNota2 = valorNota2;
        this.disciplinaId = disciplinaId;
        this.disciplinaNome = disciplinaNome;
        this.tipoAvaliacao = tipoAvaliacao;
        this.status = mediaNotas(valorNota, valorNota2);
        this.dataLancamento = dataLancamento;
    }

    public String mediaNotas(double valorNota, double valorNota2){
        double valor = (valorNota + valorNota2) / 2;

        if (valor > 7){
            return AprovacaoEnum.APROVADO.name();
        }
        else return AprovacaoEnum.REPROVADO.name();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Integer disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public String getDisciplinaNome() {
        return disciplinaNome;
    }

    public void setDisciplinaNome(String disciplinaNome) {
        this.disciplinaNome = disciplinaNome;
    }

    public String getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(String tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}

