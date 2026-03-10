package org.example.lunaris.service;


import jakarta.transaction.Transactional;
import org.example.lunaris.dto.request.ObservacaoRequestDTO;
import org.example.lunaris.dto.response.ObservacaoResponseDTO;
import org.example.lunaris.exception.NotFoundException;
import org.example.lunaris.model.Aluno;
import org.example.lunaris.model.Observacao;
import org.example.lunaris.model.Professor;
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

    private ObservacaoResponseDTO toDTO(Observacao obs){
        return new ObservacaoResponseDTO(
                obs.getId(),
                obs.getAluno().getCpf(),
                obs.getProfessor().getCpf(),
                obs.getObservacao()
        );
    }

    @Transactional
    public ObservacaoResponseDTO criar(ObservacaoRequestDTO dto){
        Aluno aluno = alunoRepository.findById(dto.getAlunoCpf())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        Professor professor = professorRepository.findById(dto.getProfessorCpf())
                .orElseThrow(() -> new NotFoundException("Professor não encontrado"));

        Observacao observacao = new Observacao();

        observacao.setAluno(aluno);
        observacao.setProfessor(professor);
        observacao.setObservacao(dto.getObservacao());

        return toDTO(repository.save(observacao));
    }

    @Transactional
    public ObservacaoResponseDTO atualizar(Integer id, ObservacaoRequestDTO dto){

        Observacao obs = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Observação não encontrada"));

        if(dto.getAlunoCpf() != null){
            Aluno aluno = alunoRepository.findById(dto.getAlunoCpf())
                    .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

            obs.setAluno(aluno);
        }

        if(dto.getProfessorCpf() != null){
           Professor professor = professorRepository.findById(dto.getProfessorCpf())
                    .orElseThrow(() -> new NotFoundException("Professor não encontrado"));

            obs.setProfessor(professor);
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
