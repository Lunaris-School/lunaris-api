package org.example.lunaris.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoletimRequestDTO {

    @NotNull
    private Integer alunoId;

    @NotNull
    private Integer disciplinaId;

}
