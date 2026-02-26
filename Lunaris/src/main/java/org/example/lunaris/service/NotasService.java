package org.example.lunaris.service;

import org.example.lunaris.dto.request.NotasRequestDTO;
import org.example.lunaris.dto.response.NotasResponseDTO;
import org.example.lunaris.exception.NotFoundException;
import org.example.lunaris.model.Boletim;
import org.example.lunaris.model.Notas;
import org.example.lunaris.repository.BoletimRepository;
import org.example.lunaris.repository.NotasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotasService {

    private final NotasRepository notasRepository;
    private final BoletimRepository boletimRepository;

    public NotasService(NotasRepository notasRepository, BoletimRepository boletimRepository) {
        this.notasRepository = notasRepository;
        this.boletimRepository = boletimRepository;
    }

    public NotasResponseDTO lancarNota(NotasRequestDTO dto) {

        Boletim boletim = boletimRepository.findById(dto.getBoletimId())
                .orElseThrow(() -> new NotFoundException("Boletim não encontrado"));

        Notas nota = new Notas();
        nota.setBoletim(boletim);
        nota.setValorNota(dto.getValorNota());
        nota.setValorNota2(dto.getValorNota2());
        nota.setTipoAvaliacao(dto.getTipoAvaliacao());
        nota.setDataLancamento(dto.getDataLancamento());

        Notas salva = notasRepository.save(nota);

        atualizarMedia(boletim);

        return new NotasResponseDTO(
                salva.getId(),
                salva.getValorNota(),
                salva.getValorNota2(),
                salva.getTipoAvaliacao(),
                salva.getDataLancamento()
        );
    }

    private void atualizarMedia(Boletim boletim) {

        List<Notas> notas = notasRepository.findByBoletimId(boletim.getId());

        int soma = notas.stream().mapToInt(Notas::getValorNota).sum();
        int media = notas.isEmpty() ? 0 : soma / notas.size();

        boletim.setMediaFinal(media);
        boletimRepository.save(boletim);
    }
}
