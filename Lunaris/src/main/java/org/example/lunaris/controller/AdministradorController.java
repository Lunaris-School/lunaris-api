package org.example.lunaris.controller;

import org.example.lunaris.dto.request.AdminUpdateRequestDTO;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.example.lunaris.contract.AdministradorContract;
import org.example.lunaris.dto.request.AdminCreateRequestDTO;
import org.example.lunaris.dto.response.AdminResponseDTO;
import org.example.lunaris.service.AdministradorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdministradorController implements AdministradorContract {
    private final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @Override
    @PostMapping
    public ResponseEntity<AdminResponseDTO> cadastrar(@Valid @RequestBody AdminCreateRequestDTO adminRequest){
        AdminResponseDTO adminResponse = administradorService.cadastrar(adminRequest);
        return new ResponseEntity<>(adminResponse, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<AdminResponseDTO> atualizar(@PathVariable int id, @Valid @RequestBody AdminUpdateRequestDTO adminUpdateRequest){
        AdminResponseDTO adminResponse = administradorService.atualizar(id, adminUpdateRequest);
        return new ResponseEntity<>(adminResponse, HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<AdminResponseDTO>> listarAdmins(){
        List<AdminResponseDTO> adminResponse = administradorService.listarAdmins();
        return new ResponseEntity<>(adminResponse, HttpStatus.FOUND);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAdmin(@PathVariable int id){
        administradorService.deletarAdmin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<AdminResponseDTO> getById(@PathVariable int id){
        AdminResponseDTO admin = administradorService.getById(id);
        return new ResponseEntity<>(admin, HttpStatus.FOUND);
    }
}
