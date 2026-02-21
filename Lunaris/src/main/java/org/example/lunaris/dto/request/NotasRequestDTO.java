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
    private String tipoAvaliacao;

    @NotNull
    private LocalDate dataLancamento;
}
