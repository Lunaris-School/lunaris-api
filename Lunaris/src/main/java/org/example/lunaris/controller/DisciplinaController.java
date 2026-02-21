package org.example.lunaris.controller;

import jakarta.validation.Valid;
import org.example.lunaris.contract.DisciplinaContract;
import org.example.lunaris.dto.request.DisciplinaCreateRequest;
import org.example.lunaris.dto.request.DisciplinaUpdateRequest;
import org.example.lunaris.dto.response.DisciplinaResponse;
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
    public ResponseEntity<DisciplinaResponse> cadastrar(@Valid @RequestBody DisciplinaCreateRequest disciplinaRequest){
        DisciplinaResponse disciplinaResponse = disciplinaService.cadastrarNovaDisciplina(disciplinaRequest);
        return new ResponseEntity<>(disciplinaResponse, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaResponse> atualizar(@PathVariable int id, @Valid @RequestBody DisciplinaUpdateRequest disciplinaUpdateRequest){
        DisciplinaResponse disciplinaResponse = disciplinaService.atualizar(id, disciplinaUpdateRequest);
        return new ResponseEntity<>(disciplinaResponse, HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<DisciplinaResponse>> listarAdmins(){
        List<DisciplinaResponse> disciplinaResponse = disciplinaService.listarDisciplinas();
        return new ResponseEntity<>(disciplinaResponse, HttpStatus.FOUND);
    }

}
