package org.example.lunaris.controller;

import jakarta.validation.Valid;
import org.example.lunaris.contract.PreCadastroCrontract;
import org.example.lunaris.dto.request.PreCadastroRequestDTO;
import org.example.lunaris.dto.response.PreCadastroResponseDTO;
import org.example.lunaris.service.PreCadastroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pre-cadastro")
public class PreCadastroController implements PreCadastroCrontract {
    private final PreCadastroService preCadastroService;

    public PreCadastroController(PreCadastroService preCadastroService) {
        this.preCadastroService = preCadastroService;
    }
    @Override
    @PostMapping
    public ResponseEntity<PreCadastroResponseDTO> cadastrar(@Valid @RequestBody PreCadastroRequestDTO preCadastroRequest){
        PreCadastroResponseDTO preCadastroResponse = preCadastroService.adicionar(preCadastroRequest);
        return new ResponseEntity<>(preCadastroResponse, HttpStatus.CREATED);
    }

}
