package org.example.lunaris.controller;

import org.example.lunaris.dto.request.AdminUpdateRequest;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.example.lunaris.contract.AdministradorContract;
import org.example.lunaris.dto.request.AdminCreateRequest;
import org.example.lunaris.dto.response.AdminResponse;
import org.example.lunaris.model.Administrador;
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
    public ResponseEntity<AdminResponse> cadastrar(@Valid @RequestBody AdminCreateRequest adminRequest){
        AdminResponse adminResponse = administradorService.cadastrar(adminRequest);
        return new ResponseEntity<>(adminResponse, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<AdminResponse> atualizar(@PathVariable int id, @Valid @RequestBody AdminUpdateRequest adminUpdateRequest){
        AdminResponse adminResponse = administradorService.atualizar(id, adminUpdateRequest);
        return new ResponseEntity<>(adminResponse, HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<AdminResponse>> listarAdmins(){
        List<AdminResponse> adminResponse = administradorService.listarAdmins();
        return new ResponseEntity<>(adminResponse, HttpStatus.FOUND);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Administrador> getById(@PathVariable int id){
        Administrador admin = administradorService.getById(id);
        return new ResponseEntity<>(admin, HttpStatus.FOUND);
    }
}
