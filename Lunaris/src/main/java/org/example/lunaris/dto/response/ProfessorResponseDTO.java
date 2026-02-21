package org.example.lunaris.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ProfessorResponseDTO {

    private Integer idProfessor;
    private String nome;
    private String email;
    private Long cpf;
    private Date dataContratacao;
    private String disciplina;
    private String escola;
}
