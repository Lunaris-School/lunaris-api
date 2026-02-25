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
    @GetMapping("/{cpf}")
    public ResponseEntity<ProfessorResponseDTO> getProfessorById(@PathVariable Long cpf) {
            return ResponseEntity.ok(professorService.getProfessorById(cpf));
    }
    @Override
    @PostMapping
    public ResponseEntity<ProfessorResponseDTO> salvarProfessor(@RequestBody @Valid ProfessorRequestDTO requestDTO) {
            return ResponseEntity.ok(professorService.salvarProfessor(requestDTO));
    }
    @Override
    @PutMapping("/atualizar/{cpf}")
    public ResponseEntity<ProfessorResponseDTO> atualizarProfessor(@PathVariable Long cpf, @RequestBody @Valid ProfessorPatchRequestDTO requestDTO) {
            return ResponseEntity.ok(professorService.atualizarProfessor(cpf, requestDTO));
    }
    @Override
    @PatchMapping("/atualizar-parcial/{cpf}")
    public ResponseEntity<ProfessorResponseDTO> atualizarProfessorParcial(@PathVariable Long cpf, @RequestBody ProfessorPatchRequestDTO requestDTO) {
            return ResponseEntity.ok(professorService.atualizarParcialProfessor(cpf, requestDTO));
    }
    @Override
    @DeleteMapping("/deletar/{cpf}")
    public ResponseEntity<Void> deletarProfessor(@PathVariable Long cpf) {
            professorService.deletarProfessor(cpf);
            return ResponseEntity.noContent().build();
    }
    @Override
    @GetMapping("/{cpf}/alunos")
    public ResponseEntity<List<Aluno>> buscarAlunosDoProfessor(@PathVariable Long cpf) {
            List<Aluno> alunos = professorService.buscarAlunosDoProfessor(cpf);
            if (alunos.isEmpty()) {
                    return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(alunos);
    }
}
