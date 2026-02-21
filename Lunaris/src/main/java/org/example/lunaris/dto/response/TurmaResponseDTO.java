package org.example.lunaris.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TurmaResponseDTO {

    private Integer id;
    private String nome;
    private Integer anoLetivo;
    private Integer professorId;
    private String professorNome;
}
