package org.example.lunaris.controller;


import org.example.lunaris.dto.request.ObservacaoRequestDTO;
import org.example.lunaris.dto.response.ObservacaoResponseDTO;
import org.example.lunaris.service.ObservacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/observacao")
public class ObservacaoController {
    private final ObservacaoService service;

    public ObservacaoController(ObservacaoService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ObservacaoResponseDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping("/inserir")
    public ResponseEntity<ObservacaoResponseDTO> inserir(@RequestBody ObservacaoRequestDTO dto){
        return ResponseEntity.ok(service.criar(dto));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ObservacaoResponseDTO> atualizar(@PathVariable Integer id,
                                                           @RequestBody ObservacaoRequestDTO dto){
        return ResponseEntity.ok(service.atualizar(id, dto));
    }
    @GetMapping("/buscar/aluno/{idAluno}")
    public ResponseEntity<List<ObservacaoResponseDTO>> buscarPorAluno(
            @PathVariable Long idAluno) {

        return ResponseEntity.ok(service.buscarPorIdAluno(idAluno));
    }

    @GetMapping("/buscar/professor/{idProfessor}")
    public ResponseEntity<List<ObservacaoResponseDTO>> buscarPorProfessor(
            @PathVariable Long idProfessor) {

        return ResponseEntity.ok(service.buscarPorIdProfessor(idProfessor));
    }
}
