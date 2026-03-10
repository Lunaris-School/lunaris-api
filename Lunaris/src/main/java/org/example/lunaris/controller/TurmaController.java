package org.example.lunaris.controller;


import jakarta.validation.Valid;
import org.example.lunaris.contract.TurmaContract;
import org.example.lunaris.dto.request.TurmaRequestDTO;
import org.example.lunaris.dto.response.MediaTurmaDisciplinaDTO;
import org.example.lunaris.dto.response.TurmaResponseDTO;
import org.example.lunaris.dto.response.TurmaStatusResponseDTO;
import org.example.lunaris.service.TurmaService;
import org.springframework.http.HttpStatus;
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
    @GetMapping("/listarTodas")
    public ResponseEntity<List<TurmaResponseDTO>> buscarTurmas() {
        List<TurmaResponseDTO> lista = turmaService.listarTurmas();

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @Override
    @GetMapping("/listarMedias")
    public ResponseEntity<List<MediaTurmaDisciplinaDTO>> listarMediasPorDisciplinaPorTurma(){
        List<MediaTurmaDisciplinaDTO> lista = turmaService.listarMediaTurmaDisciplina();

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @Override
    @GetMapping("/listarQuantidadeStatus/{cpf}")
    public ResponseEntity<List<TurmaStatusResponseDTO>> listarQuantidadeAlunoPorStatus(@PathVariable Long cpf){
        List<TurmaStatusResponseDTO> lista = turmaService.listarQuantidadeAlunoPorStatus(cpf);

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<TurmaResponseDTO> salvarTurma(@RequestBody @Valid TurmaRequestDTO requestDTO) {
        return ResponseEntity.ok(turmaService.salvarTurma(requestDTO));
    }
    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<Boolean> atualizarDisciplinas(@PathVariable Integer id, @RequestBody List<Integer> disciplinasId){
        return ResponseEntity.ok(turmaService.adicionarDisciplinas(id, disciplinasId));
    }

    @Override
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarTurma(@PathVariable Integer id) {

        turmaService.deletarTurma(id);
        return ResponseEntity.noContent().build();
    }
}
