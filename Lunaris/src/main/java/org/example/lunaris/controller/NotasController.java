package org.example.lunaris.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lunaris.dto.request.NotasRequestDTO;
import org.example.lunaris.dto.response.NotasResponseDTO;
import org.example.lunaris.service.NotasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/notas")
@RequiredArgsConstructor
@Tag(name = "Notas Controller", description = "Gerenciamento de notas")
public class NotasController {

    private final NotasService notasService;

    @PostMapping
    @Operation(summary = "Lançar nota no boletim")
    public ResponseEntity<NotasResponseDTO> lançarNota(
            @RequestBody @Valid NotasRequestDTO dto) {

        return ResponseEntity.ok(notasService.lançarNota(dto));
    }
}

