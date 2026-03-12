package org.example.lunaris.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.lunaris.dto.request.PreCadastroRequestDTO;
import org.example.lunaris.dto.response.PreCadastroResponseDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;
@Tag(name = "Pré-Cadastro Controller", description = "Gerenciamento de pré-cadastros")
public interface PreCadastroCrontract {
    @Operation(
            summary = "Adicionar um novo pre cadastro",
            description = "Adiciona um novo pre cadastro de um aluno no sistema."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Pre cadastro realizado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PreCadastroResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Pre cadastro já realizado para o aluno",
                    content = @Content
            )
    })
    ResponseEntity<PreCadastroResponseDTO> cadastrar(PreCadastroRequestDTO preCadastroRequest);

    @Operation(
            summary = "Listar pré cadastros",
            description = "Lista todos os alunos pré cadastrados no sistema."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista retornada com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PreCadastroResponseDTO.class)
                    )
            )
    })
    ResponseEntity<List<PreCadastroResponseDTO>> listarTodos();
}
