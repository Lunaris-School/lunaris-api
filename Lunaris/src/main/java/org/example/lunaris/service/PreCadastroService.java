package org.example.lunaris.service;

import org.example.lunaris.dto.request.PreCadastroRequestDTO;
import org.example.lunaris.dto.response.PreCadastroResponseDTO;
import org.example.lunaris.exception.DuplicateException;
import org.example.lunaris.model.PreCadastro;
import org.example.lunaris.repository.PreCadastroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PreCadastroService {
    private final PreCadastroRepository preCadastroRepository;

    public PreCadastroService(PreCadastroRepository preCadastroRepository) {
        this.preCadastroRepository = preCadastroRepository;
    }

    public PreCadastroResponseDTO adicionar(PreCadastroRequestDTO preCadastroRequest){
        Optional<PreCadastro> preCadastroOptional = preCadastroRepository.findByAlunoCpf(preCadastroRequest.getAlunoCpf());

        if (preCadastroOptional.isPresent()){
            throw new DuplicateException("O pre cadastro desse aluno já foi realizado");
        }
        PreCadastro preCadastro = new PreCadastro();

        BeanUtils.copyProperties(preCadastroRequest,preCadastro);
        preCadastro.setDataAutorizacao(LocalDateTime.now());

        PreCadastro preCadastroSalvo = preCadastroRepository.save(preCadastro);

        return new PreCadastroResponseDTO(preCadastroSalvo.getId(),preCadastro.getAlunoCpf(),preCadastro.getNome(),preCadastro.getDataAutorizacao());
    }
}
