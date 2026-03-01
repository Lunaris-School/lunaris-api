package org.example.lunaris.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.lunaris.dto.request.ObservacaoRequestDTO;
import org.example.lunaris.dto.response.ObservacaoResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Observacao Controller", description = "Gerenciamento de observações")
public interface ObservacaoContract {
    @Operation(summary = "Listar observações",
            description = "Retorna todas as observações cadastradas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ObservacaoResponseDTO.class))),
            @ApiResponse(responseCode = "204", description = "Nenhuma observação encontrada")
    })
    ResponseEntity<List<ObservacaoResponseDTO>> listar();

    @Operation(summary = "Criar nova observação",
            description = "Cria uma nova observação no sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Observação criada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ObservacaoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    ResponseEntity<ObservacaoResponseDTO> inserir(ObservacaoRequestDTO dto);

    @Operation(summary = "Atualizar observação",
            description = "Atualiza os dados de uma observação existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Observação atualizada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ObservacaoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Observação não encontrada")
    })
    ResponseEntity<ObservacaoResponseDTO> atualizar(Integer id, ObservacaoRequestDTO dto);

    @Operation(summary = "Buscar observações por aluno",
            description = "Retorna todas as observações vinculadas a um aluno específico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ObservacaoResponseDTO.class))),
            @ApiResponse(responseCode = "204", description = "Nenhuma observação encontrada")
    })
    ResponseEntity<List<ObservacaoResponseDTO>> buscarPorAluno(Long idAluno);

    @Operation(summary = "Buscar observações por professor",
            description = "Retorna todas as observações vinculadas a um professor específico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ObservacaoResponseDTO.class))),
            @ApiResponse(responseCode = "204", description = "Nenhuma observação encontrada")
    })
    ResponseEntity<List<ObservacaoResponseDTO>> buscarPorProfessor(Long idProfessor);
}
