package org.example.lunaris.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.lunaris.dto.request.DisciplinaRequest;
import org.example.lunaris.dto.response.DisciplinaResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DisciplinaContract {
    @Operation(
            summary = "Cadastra uma nova disciplina",
            description = "Cria uma nova disciplina no sistema"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Disciplina cadastrada com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = DisciplinaResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Administrador já cadastrado",
                    content = @Content
            )
    })
    ResponseEntity<DisciplinaResponse> cadastrar(DisciplinaRequest disciplinaRequest);

    @Operation(
            summary = "Atualizar disciplina",
            description = "Atualiza os dados de uma disciplina existente pelo ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Disciplina atualizada com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = DisciplinaResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Disciplina não encontrado",
                    content = @Content
            )
    })
    ResponseEntity<DisciplinaResponse> atualizar(int id, DisciplinaRequest disciplinaRequest);

    @Operation(
            summary = "Listar disciplinas",
            description = "Lista todos as disciplinas do banco."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Disciplinas retornadas com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = DisciplinaResponse.class)
                    )
            )
    })
    ResponseEntity<List<DisciplinaResponse>> listarAdmins();
}
