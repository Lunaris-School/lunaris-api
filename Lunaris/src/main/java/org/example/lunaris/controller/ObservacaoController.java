package org.example.lunaris.controller;


import org.example.lunaris.contract.ObservacaoContract;
import org.example.lunaris.dto.request.ObservacaoRequestDTO;
import org.example.lunaris.dto.response.ObservacaoResponseDTO;
import org.example.lunaris.service.ObservacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/observacao")
public class ObservacaoController implements ObservacaoContract {
    private final ObservacaoService service;

    public ObservacaoController(ObservacaoService service) {
        this.service = service;
    }

    @Override
    @GetMapping("/listar")
    public ResponseEntity<List<ObservacaoResponseDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @Override
    @PostMapping("/inserir")
    public ResponseEntity<ObservacaoResponseDTO> inserir(@RequestBody ObservacaoRequestDTO dto){
        return ResponseEntity.ok(service.criar(dto));
    }
    @Override
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ObservacaoResponseDTO> atualizar(@PathVariable Integer id,
                                                           @RequestBody ObservacaoRequestDTO dto){
        return ResponseEntity.ok(service.atualizar(id, dto));
    }
    @Override
    @GetMapping("/buscar/aluno/{idAluno}")
    public ResponseEntity<List<ObservacaoResponseDTO>> buscarPorAluno(
            @PathVariable Long idAluno) {

        return ResponseEntity.ok(service.buscarPorIdAluno(idAluno));
    }

    @Override
    @GetMapping("/buscar/professor/{idProfessor}")
    public ResponseEntity<List<ObservacaoResponseDTO>> buscarPorProfessor(
            @PathVariable Long idProfessor) {

        return ResponseEntity.ok(service.buscarPorIdProfessor(idProfessor));
    }
}
