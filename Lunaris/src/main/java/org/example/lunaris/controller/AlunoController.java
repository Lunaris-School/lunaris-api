package org.example.lunaris.controller;


import org.example.lunaris.contract.AlunoContract;
import org.example.lunaris.dto.request.AlunoRequestDTO;
import org.example.lunaris.dto.response.AlunoResponseDTO;
import org.example.lunaris.dto.response.AlunoTurmaResponseDTO;
import org.example.lunaris.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController implements AlunoContract {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @Override
    @GetMapping("/buscar/{cpf}")
    public ResponseEntity<AlunoResponseDTO> buscarAluno(@PathVariable Long cpf){
        return ResponseEntity.ok(alunoService.buscarAluno(cpf));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> listarAlunos(){
        return ResponseEntity.ok(alunoService.listarAlunos());
    }

    @Override
    @GetMapping("/listarPorTurma")
    public ResponseEntity<List<AlunoTurmaResponseDTO>> listarAlunosTurma(@RequestParam Integer ano){
        return ResponseEntity.ok(alunoService.listarAlunosPorTurma(ano));
    }

    @Override
    @PostMapping("/inserir")
    public ResponseEntity<AlunoResponseDTO> inserirAluno(@RequestBody AlunoRequestDTO dto){
        return ResponseEntity.ok(alunoService.criarAluno(dto));
    }
    @Override
    @PutMapping("/atualizar/{cpf}")
    public ResponseEntity<AlunoResponseDTO> atualizarAluno(@PathVariable Long cpf,
                                                           @RequestBody AlunoRequestDTO dto){
        return ResponseEntity.ok(alunoService.atualizarAluno(cpf, dto));
    }
}
