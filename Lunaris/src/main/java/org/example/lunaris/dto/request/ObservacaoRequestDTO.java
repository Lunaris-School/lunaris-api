package org.example.lunaris.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObservacaoRequestDTO {

    private Long idAluno;
    private Long idProfessor;
    private String observacao;
}
