package org.example.lunaris.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurmaRequestDTO {

    @NotBlank
    @Size(min = 2, max = 2)
    private String nome;

    @NotNull
    @Max(2026)
    private Integer anoLetivo;

    @NotNull
    private Integer professorId;

    @NotNull
    private Integer disciplinaId;
}
