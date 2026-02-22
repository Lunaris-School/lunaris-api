package org.example.lunaris.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.lunaris.dto.request.ProfessorPatchRequestDTO;
import org.example.lunaris.dto.request.ProfessorRequestDTO;
import org.example.lunaris.dto.response.ProfessorResponseDTO;
import org.example.lunaris.model.Aluno;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Professor Controller", description = "Gerenciamento de professores")
public interface ProfessorContract {
        @Operation(summary = "Retorna um professor por ID",
                description = "Busca um professor específico pelo seu ID")
        @ApiResponses({
                @ApiResponse(responseCode = "200", description = "Professor encontrado",
                        content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = ProfessorResponseDTO.class))),
                @ApiResponse(responseCode = "404", description = "Professor não encontrado")
        })
    ResponseEntity<ProfessorResponseDTO> getProfessorById(Integer id);

    @Operation(summary = "Criar um novo professor",
            description = "Cria um novo professor no sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Professor criado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProfessorResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    ResponseEntity<ProfessorResponseDTO> salvarProfessor(ProfessorRequestDTO requestDTO);

    @Operation(summary = "Atualiza um professor existente",
            description = "Atualiza todos os dados de um professor")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Professor atualizado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProfessorResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Professor não encontrado")
    })
    ResponseEntity<ProfessorResponseDTO> atualizarProfessor(Integer id, ProfessorRequestDTO requestDTO);

    @Operation(summary = "Atualiza parcialmente um professor",
            description = "Atualiza parcialmente os dados de um professor")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Professor atualizado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProfessorResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Professor não encontrado")
    })
    ResponseEntity<ProfessorResponseDTO> atualizarProfessorParcial(Integer id, ProfessorPatchRequestDTO requestDTO);

    @Operation(summary = "Deleta um professor",
            description = "Remove um professor do sistema pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Professor deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Professor não encontrado")
    })
    ResponseEntity<Void> deletarProfessor(Integer id);

    @Operation(summary = "Retorna todos os alunos de um professor",
            description = "Lista todos os alunos das turmas em que o professor leciona")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de alunos retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Aluno.class))),
            @ApiResponse(responseCode = "204", description = "Professor não possui alunos")
    })
    ResponseEntity<List<Aluno>> buscarAlunosDoProfessor(Integer id);
}
