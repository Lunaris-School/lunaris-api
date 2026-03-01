package org.example.lunaris.controller;

import jakarta.validation.Valid;
import org.example.lunaris.contract.BoletimContract;
import org.example.lunaris.dto.request.BoletimRequestDTO;
import org.example.lunaris.dto.response.BoletimResponseDTO;
import org.example.lunaris.service.BoletimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/boletim")
public class BoletimController implements BoletimContract {

    private final BoletimService boletimService;

    public BoletimController(BoletimService boletimService) {
        this.boletimService = boletimService;
    }

    @Override
    @PostMapping
    public ResponseEntity<BoletimResponseDTO> criar(
            @RequestBody @Valid BoletimRequestDTO dto) {

        return ResponseEntity.ok(boletimService.criarBoletim(dto));
    }

    @Override
    @GetMapping("/aluno/{cpf}")
    public ResponseEntity<List<BoletimResponseDTO>> buscarPorAluno(@PathVariable Long cpf) {

        List<BoletimResponseDTO> lista = boletimService.buscarPorAluno(cpf);

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }
}

