package org.example.lunaris.service;


import jakarta.transaction.Transactional;
import org.example.lunaris.dto.request.GeneroRequestDTO;
import org.example.lunaris.dto.response.GeneroResponseDTO;
import org.example.lunaris.exception.DuplicateException;
import org.example.lunaris.exception.NotFoundException;
import org.example.lunaris.model.Genero;
import org.example.lunaris.repository.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneroService {

    private final GeneroRepository repository;

    public GeneroService(GeneroRepository repository) {
        this.repository = repository;
    }

    private Genero fromDTO(GeneroRequestDTO dto){
        return new Genero(
                null,
                dto.getNome()
        );
    }

    private GeneroResponseDTO toDTO(Genero genero){
        return new GeneroResponseDTO(
                genero.getId(),
                genero.getNome()
        );
    }

    @Transactional
    public GeneroResponseDTO criar(GeneroRequestDTO dto){
        Genero generoExistente = repository.findByNome(dto.getNome());
        if (generoExistente != null){
            throw new DuplicateException("Genero já foi cadastrada");
        }
        Genero genero = fromDTO(dto);
        return toDTO(repository.save(genero));
    }


    @Transactional
    public GeneroResponseDTO atualizar(Integer id, GeneroRequestDTO dto){

        Genero genero = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Genero não encontrado"));

        if(dto.getNome() != null){
            genero.setNome(dto.getNome());
        }

        return toDTO(repository.save(genero));
    }


    public List<GeneroResponseDTO> listar(){
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }
}
