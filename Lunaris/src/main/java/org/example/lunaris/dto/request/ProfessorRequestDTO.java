package org.example.lunaris.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

@Getter
@Setter
public class ProfessorRequestDTO {

    @CPF
    @NotNull
    private Long cpf;
    @NotBlank
    @Size(min = 3, max = 50)
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String senha;
    @NotNull
    @Positive
    private int disciplina_id;
    @NotNull
    @Positive
    private int role_id;
    @NotNull
    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date data_contratacao;

}
