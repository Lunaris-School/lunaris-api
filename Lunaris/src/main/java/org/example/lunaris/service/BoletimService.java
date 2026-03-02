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

    public BoletimService(BoletimRepository boletimRepository, AlunoRepository alunoRepository) {
        this.boletimRepository = boletimRepository;
        this.alunoRepository = alunoRepository;
    }

    public BoletimResponseDTO criarBoletim(BoletimRequestDTO dto) {

        Aluno aluno = alunoRepository.findById(dto.getAlunoCpf())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        Boletim boletim = new Boletim();
        boletim.setAluno(aluno);
        boletim.setMediaFinal(0.0);

        Boletim salvo = boletimRepository.save(boletim);

        return new BoletimResponseDTO(
                salvo.getId(),
                aluno.getCpf(),
                aluno.getNome(),
                aluno.getTurma().getId(),
                aluno.getTurma().getNome(),
                0.0,
                List.of());
    }

    public List<BoletimResponseDTO> buscarPorAluno(Long cpf) {

        Aluno aluno = alunoRepository.findById(cpf)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        return boletimRepository.findByAluno(aluno)
                .stream()
                .map(b -> new BoletimResponseDTO(
                        b.getId(),
                        b.getAluno().getCpf(),
                        b.getAluno().getNome(),
                        aluno.getTurma().getId(),
                        aluno.getTurma().getNome(),
                        b.getMediaFinal(),
                        b.getNotas().stream()
                                .map(n -> new NotasResponseDTO(
                                        n.getId(),
                                        n.getValorNota(),
                                        n.getValorNota2(),
                                        n.getTipoAvaliacao(),
                                        n.getDisciplina().getId(),
                                        n.getDisciplina().getNome(),
                                        n.getDataLancamento()
                                )).toList()
                )).toList();
    }
}
