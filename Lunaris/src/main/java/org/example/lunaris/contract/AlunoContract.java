package org.example.lunaris.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.lunaris.dto.request.AlunoRequestDTO;
import org.example.lunaris.dto.response.AlunoResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Aluno Controller", description = "Gerenciamento de alunos")
public interface AlunoContract {

    @Operation(summary = "Buscar aluno por CPF",
            description = "Retorna um aluno específico com base no CPF informado")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Aluno encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AlunoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })
    ResponseEntity<AlunoResponseDTO> buscarAluno(Long cpf);

    @Operation(summary = "Listar todos os alunos",
            description = "Retorna uma lista com todos os alunos cadastrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de alunos retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AlunoResponseDTO.class))),
            @ApiResponse(responseCode = "204", description = "Nenhum aluno encontrado")
    })
    ResponseEntity<List<AlunoResponseDTO>> listarAlunos();

    @Operation(summary = "Criar novo aluno",
            description = "Cria um novo aluno no sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Aluno criado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AlunoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    ResponseEntity<AlunoResponseDTO> inserirAluno(AlunoRequestDTO dto);

    @Operation(summary = "Atualizar aluno",
            description = "Atualiza os dados de um aluno existente pelo CPF")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Aluno atualizado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AlunoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })
    ResponseEntity<AlunoResponseDTO> atualizarAluno(Long cpf, AlunoRequestDTO dto);
}
