package org.example.lunaris.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.lunaris.dto.request.TurmaRequestDTO;
import org.example.lunaris.dto.response.TurmaResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "Turma Controller", description = "Gerenciamento das turmas")
public interface TurmaContract {
    @Operation(summary = "Retorna as turmas de um professor",
            description = "Lista todas as turmas vinculadas a um professor")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de turmas retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TurmaResponseDTO.class))),
            @ApiResponse(responseCode = "204", description = "Nenhuma turma encontrada")
    })
    @GetMapping("/listarTurmaPorProfessor/{id}")
    ResponseEntity<List<TurmaResponseDTO>> buscarPorTurma(@PathVariable Long cpfProfessor);

    @Operation(summary = "Criar uma nova turma",
            description = "Cria uma nova turma no sistema")
    ResponseEntity<TurmaResponseDTO> salvarTurma(TurmaRequestDTO requestDTO);

    @Operation(summary = "Deleta uma turma",
            description = "Remove uma turma do sistema pelo ID")
    ResponseEntity<Void> deletarTurma(Integer id);
}
