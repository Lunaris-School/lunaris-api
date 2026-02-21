package org.example.lunaris.controller;


import org.example.lunaris.dto.request.GeneroRequestDTO;
import org.example.lunaris.dto.response.GeneroResponseDTO;
import org.example.lunaris.service.GeneroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genero")
public class GeneroController {

    private final GeneroService service;

    public GeneroController(GeneroService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<GeneroResponseDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping("/inserir")
    public ResponseEntity<GeneroResponseDTO> inserir(@RequestBody GeneroRequestDTO dto){
        return ResponseEntity.ok(service.criar(dto));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<GeneroResponseDTO> atualizar(@PathVariable Integer id,
                                                       @RequestBody GeneroRequestDTO dto){
        return ResponseEntity.ok(service.atualizar(id, dto));
    }
}
