package org.example.lunaris.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class NotasResponseDTO {

    private Integer id;
    private Integer valorNota;
    private String tipoAvaliacao;
    private LocalDate dataLancamento;
}
