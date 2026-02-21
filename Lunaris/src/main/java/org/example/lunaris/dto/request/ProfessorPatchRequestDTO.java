package org.example.lunaris.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProfessorPatchRequestDTO {

    private String nome;
    private String email;
    private String senha;
    private LocalDate dataContratacao;
    private Integer disciplinaId;
    private Integer escolaId;
}
