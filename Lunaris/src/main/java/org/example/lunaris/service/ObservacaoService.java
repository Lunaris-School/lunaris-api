package org.example.lunaris.service;


import jakarta.transaction.Transactional;
import org.example.lunaris.dto.request.ObservacaoRequestDTO;
import org.example.lunaris.dto.response.ObservacaoResponseDTO;
import org.example.lunaris.exception.NotFoundException;
import org.example.lunaris.model.Observacao;
import org.example.lunaris.repository.AlunoRepository;
import org.example.lunaris.repository.ObservacaoRepository;
import org.example.lunaris.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObservacaoService {
    private final ObservacaoRepository repository;

    private final AlunoRepository alunoRepository;

    private final ProfessorRepository professorRepository;

    public ObservacaoService(ObservacaoRepository repository, AlunoRepository alunoRepository, ProfessorRepository professorRepository) {
        this.repository = repository;
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
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
                obs.getAlunoCpf(),
                obs.getProfessorCpf(),
                obs.getObservacao()
        );
    }

    @Transactional
    public ObservacaoResponseDTO criar(ObservacaoRequestDTO dto){
        alunoRepository.findById(dto.getIdAluno())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        professorRepository.findById(dto.getIdProfessor())
                .orElseThrow(() -> new NotFoundException("Professor não encontrado"));

        Observacao observacao = fromDTO(dto);
        return toDTO(repository.save(observacao));
    }

    @Transactional
    public ObservacaoResponseDTO atualizar(Integer id, ObservacaoRequestDTO dto){

        Observacao obs = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Observação não encontrada"));

        if(dto.getIdAluno() != null){
            alunoRepository.findById(dto.getIdAluno())
                    .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

            obs.setAlunoCpf(dto.getIdAluno());
        }

        if(dto.getIdProfessor() != null){
            professorRepository.findById(dto.getIdProfessor())
                    .orElseThrow(() -> new NotFoundException("Professor não encontrado"));

            obs.setProfessorCpf(dto.getIdProfessor());
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
        return repository.findByAlunoCpf(idAluno)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<ObservacaoResponseDTO> buscarPorIdProfessor(Long idProfessor) {
        return repository.findByProfessorCpf(idProfessor)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
