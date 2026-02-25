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

    @GetMapping("/listarTurmaPorProfessor/{id}")
    @Override
    public ResponseEntity<List<TurmaResponseDTO>> buscarPorTurma(@PathVariable Long cpfProfessor) {

        List<TurmaResponseDTO> lista = turmaService.buscarPorTurma(cpfProfessor);

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
