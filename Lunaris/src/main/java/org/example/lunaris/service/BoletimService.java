package org.example.lunaris.service;

import org.example.lunaris.dto.request.BoletimRequestDTO;
import org.example.lunaris.dto.response.BoletimResponseDTO;
import org.example.lunaris.dto.response.NotasResponseDTO;
import org.example.lunaris.exception.NotFoundException;
import org.example.lunaris.model.*;
import org.example.lunaris.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletimService {

    private final BoletimRepository boletimRepository;
    private final AlunoRepository alunoRepository;
    private final DisciplinaRepository disciplinaRepository;

    public BoletimService(BoletimRepository boletimRepository, AlunoRepository alunoRepository, DisciplinaRepository disciplinaRepository) {
        this.boletimRepository = boletimRepository;
        this.alunoRepository = alunoRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    public BoletimResponseDTO criarBoletim(BoletimRequestDTO dto) {

        Aluno aluno = alunoRepository.findById(Long.valueOf(dto.getAlunoId()))
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        Disciplina disciplina = disciplinaRepository.findById(dto.getDisciplinaId())
                .orElseThrow(() -> new NotFoundException("Disciplina não encontrada"));

        Boletim boletim = new Boletim();
        boletim.setAluno(aluno);
        boletim.setDisciplina(disciplina);
        boletim.setMediaFinal(0);

        Boletim salvo = boletimRepository.save(boletim);

        return new BoletimResponseDTO(
                salvo.getId(),
                aluno.getCpf(),
                aluno.getNome(),
                disciplina.getId(),
                disciplina.getNome(),
                0,
                List.of()
        );
    }

    public List<BoletimResponseDTO> buscarPorAluno(Integer alunoId) {

        Aluno aluno = alunoRepository.findById(Long.valueOf(alunoId))
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        return boletimRepository.findByAluno(aluno)
                .stream()
                .map(b -> new BoletimResponseDTO(
                        b.getId(),
                        b.getAluno().getCpf(),
                        b.getAluno().getNome(),
                        b.getDisciplina().getId(),
                        b.getDisciplina().getNome(),
                        b.getMediaFinal(),
                        b.getNotas().stream()
                                .map(n -> new NotasResponseDTO(
                                        n.getId(),
                                        n.getValorNota(),
                                        n.getTipoAvaliacao(),
                                        n.getDataLancamento()
                                )).toList()
                )).toList();
    }
}
