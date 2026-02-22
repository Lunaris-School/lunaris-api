package org.example.lunaris.controller;

import jakarta.validation.Valid;
import org.example.lunaris.contract.ProfessorContract;
import org.example.lunaris.dto.request.ProfessorPatchRequestDTO;
import org.example.lunaris.dto.request.ProfessorRequestDTO;
import org.example.lunaris.dto.response.ProfessorResponseDTO;
import org.example.lunaris.model.Aluno;
import org.example.lunaris.service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController implements ProfessorContract {
        private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> getProfessorById(@PathVariable Integer id) {
            return ResponseEntity.ok(professorService.getProfessorById(id));
    }
    @Override
    @PostMapping

    public ResponseEntity<ProfessorResponseDTO> salvarProfessor(@RequestBody @Valid ProfessorRequestDTO requestDTO) {
            return ResponseEntity.ok(professorService.salvarProfessor(requestDTO));
    }
    @Override
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ProfessorResponseDTO> atualizarProfessor(@PathVariable Integer id, @RequestBody @Valid ProfessorRequestDTO requestDTO) {
            return ResponseEntity.ok(professorService.atualizarProfessor(id, requestDTO));
    }
    @Override

    @PatchMapping("/atualizar-parcial/{id}")
    public ResponseEntity<ProfessorResponseDTO> atualizarProfessorParcial(@PathVariable Integer id, @RequestBody ProfessorPatchRequestDTO requestDTO) {
            return ResponseEntity.ok(professorService.atualizarParcialProfessor(id, requestDTO));
    }
    @Override
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarProfessor(@PathVariable Integer id) {
            professorService.deletarProfessor(id);
            return ResponseEntity.noContent().build();
    }
    @Override
    @GetMapping("/{id}/alunos")
    public ResponseEntity<List<Aluno>> buscarAlunosDoProfessor(@PathVariable Integer id) {
            List<Aluno> alunos = professorService.buscarAlunosDoProfessor(id);
            if (alunos.isEmpty()) {
                    return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(alunos);
    }
}
