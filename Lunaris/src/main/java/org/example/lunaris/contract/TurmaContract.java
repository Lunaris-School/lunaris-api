package org.example.lunaris.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.lunaris.dto.request.TurmaRequestDTO;
import org.example.lunaris.dto.response.MediaTurmaDisciplinaDTO;
import org.example.lunaris.dto.response.TurmaResponseDTO;
import org.example.lunaris.dto.response.TurmaStatusResponseDTO;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<List<TurmaResponseDTO>> buscarPorTurma(@PathVariable Long cpf);

    @Operation(summary = "Retorna todas as turmas",
            description = "Lista todas as turmas cadastradas no banco")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de turmas retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TurmaResponseDTO.class)))
    })
    ResponseEntity<List<TurmaResponseDTO>> buscarTurmas();

    @Operation(summary = "Retorna as médias por disciplina",
            description = "Lista todas as médias por disciplina de cada turma")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de médias retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MediaTurmaDisciplinaDTO.class)))
    })
    ResponseEntity<List<MediaTurmaDisciplinaDTO>> listarMediasPorDisciplinaPorTurma();

    @Operation(summary = "Retorna a quantidade de Alunos por status",
            description = "Lista a quantidade de alunos por status de cada turma")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TurmaStatusResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Professor de turma não encontrado")
    })
    ResponseEntity<List<TurmaStatusResponseDTO>> listarQuantidadeAlunoPorStatus(Long cpf);

    @Operation(summary = "Criar uma nova turma",
            description = "Cria uma nova turma no sistema")
    ResponseEntity<TurmaResponseDTO> salvarTurma(TurmaRequestDTO requestDTO);

    @Operation(summary = "Retorna se a atualização de disciplinas teve sucesso",
            description = "Atualiza as disciplinas de uma turma")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Atualização feita com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Boolean.class))),
            @ApiResponse(responseCode = "404", description = "Turma de turma não encontrado")
    })
    ResponseEntity<Boolean> atualizarDisciplinas(Integer id, List<Integer> disciplinasId);

    @Operation(summary = "Deleta uma turma",
            description = "Remove uma turma do sistema pelo ID")
    ResponseEntity<Void> deletarTurma(Integer id);
}
