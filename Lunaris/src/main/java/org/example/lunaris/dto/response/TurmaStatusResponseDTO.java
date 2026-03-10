package org.example.lunaris.dto.response;

import java.util.List;

public class TurmaStatusResponseDTO {
    String turma;
    List<QuantidadeStatusResponseDTO> statusResponseDTOS;

    public TurmaStatusResponseDTO() {
    }
    public TurmaStatusResponseDTO(String turma, List<QuantidadeStatusResponseDTO> statusResponseDTOS) {
        this.turma = turma;
        this.statusResponseDTOS = statusResponseDTOS;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public List<QuantidadeStatusResponseDTO> getStatusResponseDTOS() {
        return statusResponseDTOS;
    }

    public void setStatusResponseDTOS(List<QuantidadeStatusResponseDTO> statusResponseDTOS) {
        this.statusResponseDTOS = statusResponseDTOS;
    }
}
