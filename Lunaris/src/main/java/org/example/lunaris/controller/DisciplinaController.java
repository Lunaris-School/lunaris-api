package org.example.lunaris.controller;

import jakarta.validation.Valid;
import org.example.lunaris.contract.DisciplinaContract;
import org.example.lunaris.dto.request.DisciplinaCreateRequestDTO;
import org.example.lunaris.dto.request.DisciplinaUpdateRequestDTO;
import org.example.lunaris.dto.response.DisciplinaResponseDTO;
import org.example.lunaris.service.DisciplinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disciplina")
public class DisciplinaController implements DisciplinaContract {
    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @Override
    @PostMapping
    public ResponseEntity<DisciplinaResponseDTO> cadastrar(@Valid @RequestBody DisciplinaCreateRequestDTO disciplinaRequest){
        DisciplinaResponseDTO disciplinaResponse = disciplinaService.cadastrarNovaDisciplina(disciplinaRequest);
        return new ResponseEntity<>(disciplinaResponse, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaResponseDTO> atualizar(@PathVariable int id, @Valid @RequestBody DisciplinaUpdateRequestDTO disciplinaUpdateRequest){
        DisciplinaResponseDTO disciplinaResponse = disciplinaService.atualizar(id, disciplinaUpdateRequest);
        return new ResponseEntity<>(disciplinaResponse, HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<DisciplinaResponseDTO>> listarDisciplinas(){
        List<DisciplinaResponseDTO> disciplinaResponse = disciplinaService.listarDisciplinas();
        return new ResponseEntity<>(disciplinaResponse, HttpStatus.OK);
    }

}
