package org.example.lunaris.dto.response;

public class QuantidadeStatusResponseDTO {
    Integer quantidadeAprovados;
    Integer quantidadeReprovados;
    Integer quantidadeEmRisco;

    public QuantidadeStatusResponseDTO() {
    }

    public QuantidadeStatusResponseDTO(Integer quantidadeAprovados, Integer quantidadeReprovados, Integer quantidadeEmRisco) {
        this.quantidadeAprovados = quantidadeAprovados;
        this.quantidadeReprovados = quantidadeReprovados;
        this.quantidadeEmRisco = quantidadeEmRisco;
    }

    public Integer getQuantidadeAprovados() {
        return quantidadeAprovados;
    }

    public void setQuantidadeAprovados(Integer quantidadeAprovados) {
        this.quantidadeAprovados = quantidadeAprovados;
    }

    public Integer getQuantidadeReprovados() {
        return quantidadeReprovados;
    }

    public void setQuantidadeReprovados(Integer quantidadeReprovados) {
        this.quantidadeReprovados = quantidadeReprovados;
    }

    public Integer getQuantidadeEmRisco() {
        return quantidadeEmRisco;
    }

    public void setQuantidadeEmRisco(Integer quantidadeEmRisco) {
        this.quantidadeEmRisco = quantidadeEmRisco;
    }
}
