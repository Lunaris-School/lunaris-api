package org.example.lunaris.controller;


import jakarta.validation.Valid;
import org.example.lunaris.contract.TurmaContract;
import org.example.lunaris.dto.request.TurmaRequestDTO;
import org.example.lunaris.dto.response.TurmaResponseDTO;
import org.example.lunaris.service.TurmaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/turma")
public class TurmaController implements TurmaContract {

    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @Override
    @GetMapping("/listarTurmaPorProfessor/{cpf}")
    public ResponseEntity<List<TurmaResponseDTO>> buscarPorTurma(@PathVariable Long cpf) {

        List<TurmaResponseDTO> lista = turmaService.buscarPorTurma(cpf);

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @Override
    @PostMapping
    public ResponseEntity<TurmaResponseDTO> salvarTurma(
            @RequestBody @Valid TurmaRequestDTO requestDTO) {

        return ResponseEntity.ok(turmaService.salvarTurma(requestDTO));
    }

    @Override
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarTurma(@PathVariable Integer id) {

        turmaService.deletarTurma(id);
        return ResponseEntity.noContent().build();
    }
}
