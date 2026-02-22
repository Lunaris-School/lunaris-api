package org.example.lunaris.controller;

import jakarta.validation.Valid;
import org.example.lunaris.contract.NotasContract;
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
public class NotasController implements NotasContract {

    private final NotasService notasService;

    public NotasController(NotasService notasService) {
        this.notasService = notasService;
    }

    @Override
    @PostMapping
    public ResponseEntity<NotasResponseDTO> lancarNota(
            @RequestBody @Valid NotasRequestDTO dto) {

        return ResponseEntity.ok(notasService.lancarNota(dto));
    }
}

