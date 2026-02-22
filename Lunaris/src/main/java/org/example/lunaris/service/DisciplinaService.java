package org.example.lunaris.service;

import org.example.lunaris.dto.request.DisciplinaCreateRequestDTO;
import org.example.lunaris.dto.request.DisciplinaUpdateRequestDTO;
import org.example.lunaris.dto.response.DisciplinaResponseDTO;
import org.example.lunaris.exception.DuplicateException;
import org.example.lunaris.exception.NotFoundException;
import org.example.lunaris.model.Disciplina;
import org.example.lunaris.repository.DisciplinaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public DisciplinaResponseDTO cadastrarNovaDisciplina(DisciplinaCreateRequestDTO disciplinaRequest)
    {
        Disciplina disciplinaExistente = disciplinaRepository.findByNome(disciplinaRequest.getNome());

        if (disciplinaExistente != null){
            throw new DuplicateException("Disciplina já foi cadastrada");
        }
        Disciplina disciplina = new Disciplina();

        BeanUtils.copyProperties(disciplinaRequest,disciplina);

        Disciplina disciplinaSalva = disciplinaRepository.save(disciplina);
        return new DisciplinaResponseDTO(disciplinaSalva.getId(),disciplinaSalva.getNome());

    }
    public DisciplinaResponseDTO atualizar(int id, DisciplinaUpdateRequestDTO disciplinaUpdateRequest){
        Optional<Disciplina> disciplinaOptional = disciplinaRepository.findById(id);

        if (disciplinaOptional.isEmpty()){
            throw new NotFoundException("Disciplina não encontrado");
        }
        Disciplina disciplina = new Disciplina();

        BeanUtils.copyProperties(disciplinaUpdateRequest,disciplina);

        Disciplina disciplinaSalva = disciplinaRepository.save(disciplina);

        return new DisciplinaResponseDTO(disciplinaSalva.getId(),disciplinaSalva.getNome());
    }
    public List<DisciplinaResponseDTO> listarDisciplinas(){
        return disciplinaRepository.findAll().stream().map(disciplina ->
                new DisciplinaResponseDTO(disciplina.getId(),disciplina.getNome())).toList();
    }

}
