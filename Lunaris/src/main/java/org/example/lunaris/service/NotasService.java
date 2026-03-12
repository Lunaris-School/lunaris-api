package org.example.lunaris.service;

import org.example.lunaris.dto.request.NotasRequestDTO;
import org.example.lunaris.dto.request.NotasUpdateRequestDTO;
import org.example.lunaris.dto.response.NotasResponseDTO;
import org.example.lunaris.exception.NotFoundException;
import org.example.lunaris.model.Boletim;
import org.example.lunaris.model.Disciplina;
import org.example.lunaris.model.Notas;
import org.example.lunaris.repository.BoletimRepository;
import org.example.lunaris.repository.DisciplinaRepository;
import org.example.lunaris.repository.NotasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotasService {

    private final NotasRepository notasRepository;
    private final BoletimRepository boletimRepository;
    private final DisciplinaRepository disciplinaRepository;

    public NotasService(NotasRepository notasRepository, BoletimRepository boletimRepository, DisciplinaRepository disciplinaRepository) {
        this.notasRepository = notasRepository;
        this.boletimRepository = boletimRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    public NotasResponseDTO lancarNota(NotasRequestDTO dto) {

        Boletim boletim = boletimRepository.findById(dto.getBoletimId())
                .orElseThrow(() -> new NotFoundException("Boletim não encontrado"));

        Disciplina disciplina = disciplinaRepository.findById(dto.getDisciplinaId())
                .orElseThrow(() -> new NotFoundException("Disciplina não encontrada"));

        Notas nota = new Notas();
        nota.setBoletim(boletim);
        nota.setValorNota(dto.getValorNota());
        nota.setValorNota2(dto.getValorNota2());
        nota.setDisciplina(disciplina);
        nota.setTipoAvaliacao(dto.getTipoAvaliacao());
        nota.setDataLancamento(dto.getDataLancamento());

        Notas salva = notasRepository.save(nota);

        atualizarMedia(boletim);

        return new NotasResponseDTO(
                salva.getId(),
                salva.getValorNota(),
                salva.getValorNota2(),
                salva.getTipoAvaliacao(),
                salva.getDisciplina().getId(),
                salva.getDisciplina().getNome(),
                salva.getDataLancamento()
        );
    }
    public NotasResponseDTO atualizarNota(Integer notaId, NotasUpdateRequestDTO dto) {

        Notas notas = notasRepository.findById(notaId)
                .orElseThrow(() -> new NotFoundException("Notas não encontrado"));

        Boletim boletim = boletimRepository.findById(dto.getBoletimId())
                .orElseThrow(() -> new NotFoundException("Boletim não encontrado"));

        if (dto.getValorNota() != null) notas.setValorNota(dto.getValorNota());
        if (dto.getValorNota2() != null) notas.setValorNota2(dto.getValorNota2());
        if (dto.getTipoAvaliacao() != null) notas.setTipoAvaliacao(dto.getTipoAvaliacao());

        Notas salva = notasRepository.save(notas);

        atualizarMedia(boletim);

        return new NotasResponseDTO(
                salva.getId(),
                salva.getValorNota(),
                salva.getValorNota2(),
                salva.getTipoAvaliacao(),
                salva.getDisciplina().getId(),
                salva.getDisciplina().getNome(),
                salva.getDataLancamento()
        );
    }

    private void atualizarMedia(Boletim boletim) {

        List<Notas> notas = notasRepository.findByBoletimId(boletim.getId());

        double soma = notas.stream()
                .mapToDouble(n -> (n.getValorNota() + n.getValorNota2()) / 2)
                .sum();

        double media = notas.isEmpty() ? 0 : soma / notas.size();

        boletim.setMediaFinal(media);
        boletimRepository.save(boletim);
    }
}
