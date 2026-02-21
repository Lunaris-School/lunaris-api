package org.example.lunaris.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObservacaoResponseDTO {

    private Integer id;
    private Long idAluno;
    private Long idProfessor;
    private String observacao;
}
