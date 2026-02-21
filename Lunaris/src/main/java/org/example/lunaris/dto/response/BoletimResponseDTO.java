package org.example.lunaris.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class BoletimResponseDTO {

    private Integer id;
    private Integer alunoId;
    private String alunoNome;
    private Integer disciplinaId;
    private String disciplinaNome;
    private Integer mediaFinal;
    private List<NotasResponseDTO> notas;
}
