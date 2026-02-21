package org.example.lunaris.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lunaris.dto.request.ProfessorPatchRequestDTO;
import org.example.lunaris.dto.request.ProfessorRequestDTO;
import org.example.lunaris.dto.response.ProfessorResponseDTO;
import org.example.lunaris.model.Aluno;
import org.example.lunaris.service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Professor Controller", description = "Gerenciamento de professores")
@RequestMapping("/v1/professor")
@RequiredArgsConstructor
public class ProfessorController {

        private final ProfessorService professorService;

        @GetMapping("/listarPorEscola/{id}")
        @Operation(summary = "Retorna uma lista de professores por escola",
                description = "Lista todos os professores vinculados a uma escola específica")
        @ApiResponses({
                @ApiResponse(responseCode = "200", description = "Lista de professores retornada com sucesso",
                        content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = ProfessorResponseDTO.class))),
                @ApiResponse(responseCode = "204", description = "Nenhum professor encontrado nessa escola")
        })
        public ResponseEntity<List<ProfessorResponseDTO>> buscarPorEscola(@PathVariable Integer id) {

                List<ProfessorResponseDTO> lista = professorService.buscarPorEscola(id);

                if (lista.isEmpty()) {
                        return ResponseEntity.noContent().build();
                }

                return ResponseEntity.ok(lista);
        }

        @GetMapping("/{id}")
        @Operation(summary = "Retorna um professor por ID",
                description = "Busca um professor específico pelo seu ID")
        @ApiResponses({
                @ApiResponse(responseCode = "200", description = "Professor encontrado",
                        content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = ProfessorResponseDTO.class))),
                @ApiResponse(responseCode = "404", description = "Professor não encontrado")
        })
        public ResponseEntity<ProfessorResponseDTO> getProfessorById(@PathVariable Integer id) {
                return ResponseEntity.ok(professorService.getProfessorById(id));
        }

        @PostMapping
        @Operation(summary = "Criar um novo professor",
                description = "Cria um novo professor no sistema")
        @ApiResponses({
                @ApiResponse(responseCode = "200", description = "Professor criado com sucesso",
                        content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = ProfessorResponseDTO.class))),
                @ApiResponse(responseCode = "400", description = "Dados inválidos")
        })
        public ResponseEntity<ProfessorResponseDTO> salvarProfessor(
                @RequestBody @Valid ProfessorRequestDTO requestDTO) {

                return ResponseEntity.ok(professorService.salvarProfessor(requestDTO));
        }

        @PutMapping("/atualizar/{id}")
        @Operation(summary = "Atualiza um professor existente",
                description = "Atualiza todos os dados de um professor")
        @ApiResponses({
                @ApiResponse(responseCode = "200", description = "Professor atualizado com sucesso",
                        content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = ProfessorResponseDTO.class))),
                @ApiResponse(responseCode = "404", description = "Professor não encontrado")
        })
        public ResponseEntity<ProfessorResponseDTO> atualizarProfessor(
                @PathVariable Integer id,
                @RequestBody @Valid ProfessorRequestDTO requestDTO) {

                return ResponseEntity.ok(professorService.atualizarProfessor(id, requestDTO));
        }

        @PatchMapping("/atualizar-parcial/{id}")
        @Operation(summary = "Atualiza parcialmente um professor",
                description = "Atualiza parcialmente os dados de um professor")
        @ApiResponses({
                @ApiResponse(responseCode = "200", description = "Professor atualizado com sucesso",
                        content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = ProfessorResponseDTO.class))),
                @ApiResponse(responseCode = "404", description = "Professor não encontrado")
        })
        public ResponseEntity<ProfessorResponseDTO> atualizarProfessorParcial(
                @PathVariable Integer id,
                @RequestBody ProfessorPatchRequestDTO requestDTO) {

                return ResponseEntity.ok(professorService.atualizarParcialProfessor(id, requestDTO));
        }

        @DeleteMapping("/deletar/{id}")
        @Operation(summary = "Deleta um professor",
                description = "Remove um professor do sistema pelo ID")
        @ApiResponses({
                @ApiResponse(responseCode = "204", description = "Professor deletado com sucesso"),
                @ApiResponse(responseCode = "404", description = "Professor não encontrado")
        })
        public ResponseEntity<Void> deletarProfessor(@PathVariable Integer id) {

                professorService.deletarProfessor(id);
                return ResponseEntity.noContent().build();
        }

        @GetMapping("/{id}/alunos")
        @Operation(summary = "Retorna todos os alunos de um professor",
                description = "Lista todos os alunos das turmas em que o professor leciona")
        @ApiResponses({
                @ApiResponse(responseCode = "200", description = "Lista de alunos retornada com sucesso",
                        content = @Content(mediaType = "application/json",
                                schema = @Schema(implementation = Aluno.class))),
                @ApiResponse(responseCode = "204", description = "Professor não possui alunos")
        })
        public ResponseEntity<List<Aluno>> buscarAlunosDoProfessor(@PathVariable Integer id) {

                List<Aluno> alunos = professorService.buscarAlunosDoProfessor(id);

                if (alunos.isEmpty()) {
                        return ResponseEntity.noContent().build();
                }

                return ResponseEntity.ok(alunos);
        }
}
