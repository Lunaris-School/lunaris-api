package org.example.lunaris.service;


import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.lunaris.dto.request.ObservacaoRequestDTO;
import org.example.lunaris.dto.response.ObservacaoResponseDTO;
import org.example.lunaris.model.Observacao;
import org.example.lunaris.repository.ObservacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObservacaoService {
    private final ObservacaoRepository repository;

    public ObservacaoService(ObservacaoRepository repository) {
        this.repository = repository;
    }

    private Observacao fromDTO(ObservacaoRequestDTO dto){
        return new Observacao(
                null,
                dto.getIdAluno(),
                dto.getIdProfessor(),
                dto.getObservacao()
        );
    }

    private ObservacaoResponseDTO toDTO(Observacao obs){
        return new ObservacaoResponseDTO(
                obs.getId(),
                obs.getIdAluno(),
                obs.getIdProfessor(),
                obs.getObservacao()
        );
    }

    @Transactional
    public ObservacaoResponseDTO criar(ObservacaoRequestDTO dto){
        Observacao observacao = fromDTO(dto);
        return toDTO(repository.save(observacao));
    }

    @Transactional
    public ObservacaoResponseDTO atualizar(Integer id, ObservacaoRequestDTO dto){

        Observacao obs = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Observação não encontrada"));

        if(dto.getIdAluno() != null){
            obs.setIdAluno(dto.getIdAluno());
        }

        if(dto.getIdProfessor() != null){
            obs.setIdProfessor(dto.getIdProfessor());
        }

        if(dto.getObservacao() != null){
            obs.setObservacao(dto.getObservacao());
        }

        return toDTO(repository.save(obs));
    }

    public List<ObservacaoResponseDTO> listar(){
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<ObservacaoResponseDTO> buscarPorIdAluno(Long idAluno) {
        return repository.findByIdAluno(idAluno)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<ObservacaoResponseDTO> buscarPorIdProfessor(Long idProfessor) {
        return repository.findByIdProfessor(idProfessor)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
