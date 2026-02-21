package org.example.lunaris.dto.response;

import lombok.*;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class AlunoResponseDTO {

    private Long cpf;
    private String nome;
    private Long matricula;
    private String email;
    private Integer roleId;
    private Integer generoId;

    public AlunoResponseDTO() {}

    public AlunoResponseDTO(Long cpf, String nome, Long matricula, String email, Integer roleId, Integer generoId) {
        this.cpf = cpf;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.roleId = roleId;
        this.generoId = generoId;
    }
}
