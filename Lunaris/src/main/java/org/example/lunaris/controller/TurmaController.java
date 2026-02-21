package org.example.lunaris.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lunaris.dto.request.TurmaRequestDTO;
import org.example.lunaris.dto.response.TurmaResponseDTO;
import org.example.lunaris.service.TurmaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Turma Controller", description = "Gerenciamento das turmas")
@RequestMapping("/v1/turma")
@RequiredArgsConstructor
public class TurmaController {

    private final TurmaService turmaService;


    @GetMapping("/listarTurmaPorProfessor/{id}")
    @Operation(summary = "Retorna as turmas de um professor",
            description = "Lista todas as turmas vinculadas a um professor")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de turmas retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TurmaResponseDTO.class))),
            @ApiResponse(responseCode = "204", description = "Nenhuma turma encontrada")
    })
    public ResponseEntity<List<TurmaResponseDTO>> buscarPorTurma(@PathVariable Integer id) {

        List<TurmaResponseDTO> lista = turmaService.buscarPorTurma(id);

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @Operation(summary = "Criar uma nova turma",
            description = "Cria uma nova turma no sistema")
    public ResponseEntity<TurmaResponseDTO> salvarTurma(
            @RequestBody @Valid TurmaRequestDTO requestDTO) {

        return ResponseEntity.ok(turmaService.salvarTurma(requestDTO));
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta uma turma",
            description = "Remove uma turma do sistema pelo ID")
    public ResponseEntity<Void> deletarTurma(@PathVariable Integer id) {

        turmaService.deletarTurma(id);
        return ResponseEntity.noContent().build();
    }
}
