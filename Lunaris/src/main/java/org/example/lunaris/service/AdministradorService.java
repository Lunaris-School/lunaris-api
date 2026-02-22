package org.example.lunaris.service;

import org.example.lunaris.Enum.RoleEnum;
import org.example.lunaris.dto.request.AdminUpdateRequestDTO;
import org.example.lunaris.exception.DuplicateException;
import org.example.lunaris.exception.NotFoundException;
import org.example.lunaris.dto.request.AdminCreateRequestDTO;
import org.example.lunaris.dto.response.AdminResponseDTO;
import org.example.lunaris.model.Administrador;
import org.example.lunaris.model.Role;
import org.example.lunaris.repository.AdministradorRepository;
import org.example.lunaris.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {
    private final AdministradorRepository administradorRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public AdministradorService(AdministradorRepository administradorRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.administradorRepository = administradorRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AdminResponseDTO cadastrar(AdminCreateRequestDTO adminResquest){

        Administrador administradorExistente = administradorRepository.findByEmail(adminResquest.getEmail());

        if (administradorExistente != null){
            throw new DuplicateException("Administrador já foi cadastrado");
        }
        Administrador admin = new Administrador();

        admin.setNome(adminResquest.getNome());
        admin.setEmail(adminResquest.getEmail());
        admin.setSenha(passwordEncoder.encode(adminResquest.getSenha()));

        Role adminRole = roleRepository.findByNome(RoleEnum.ADMIN.name());
        admin.setRole(adminRole);

        Administrador adminSalvo = administradorRepository.save(admin);
        return new AdminResponseDTO(adminSalvo.getId(),adminSalvo.getNome());

    }
    public AdminResponseDTO atualizar(int id, AdminUpdateRequestDTO adminUpdateRequest){
        Optional<Administrador> adminOptional = administradorRepository.findById(id);

        if (adminOptional.isEmpty()){
            throw new NotFoundException("Admin não encontrado");
        }
        Administrador admin = new Administrador();

        if (adminUpdateRequest.getSenha() != null){
            adminUpdateRequest.setSenha(passwordEncoder.encode(adminUpdateRequest.getSenha()));
        }
        BeanUtils.copyProperties(adminUpdateRequest,admin);

        Administrador adminSalvo = administradorRepository.save(admin);

        return new AdminResponseDTO(adminSalvo.getId(),adminSalvo.getNome());
    }
    public List<AdminResponseDTO> listarAdmins(){
        return administradorRepository.findAll().stream().map(administrador ->
                new AdminResponseDTO(administrador.getId(),administrador.getNome())).toList();
    }

    public Administrador getById(Integer id){
        Optional<Administrador> administrador = administradorRepository.findById(id);

        if (administrador.isEmpty()){
            throw new NotFoundException("Admin Não foi encontrado");
        }
        return administrador.get();
    }

}
