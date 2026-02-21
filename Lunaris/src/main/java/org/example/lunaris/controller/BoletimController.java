package org.example.lunaris.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lunaris.dto.request.BoletimRequestDTO;
import org.example.lunaris.dto.response.BoletimResponseDTO;
import org.example.lunaris.service.BoletimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/boletim")
@RequiredArgsConstructor
@Tag(name = "Boletim Controller", description = "Gerenciamento de boletins")
public class BoletimController {

    private final BoletimService boletimService;

    @PostMapping
    @Operation(summary = "Criar boletim")
    public ResponseEntity<BoletimResponseDTO> criar(
            @RequestBody @Valid BoletimRequestDTO dto) {

        return ResponseEntity.ok(boletimService.criarBoletim(dto));
    }

    @GetMapping("/aluno/{id}")
    @Operation(summary = "Buscar boletins por aluno")
    public ResponseEntity<List<BoletimResponseDTO>> buscarPorAluno(@PathVariable Integer id) {

        List<BoletimResponseDTO> lista = boletimService.buscarPorAluno(id);

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }
}

