package org.example.lunaris.service;

import org.example.lunaris.dto.request.DisciplinaCreateRequest;
import org.example.lunaris.dto.request.DisciplinaUpdateRequest;
import org.example.lunaris.dto.response.DisciplinaResponse;
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

    public DisciplinaResponse cadastrarNovaDisciplina(DisciplinaCreateRequest disciplinaRequest)
    {
        Disciplina disciplinaExistente = disciplinaRepository.findByNome(disciplinaRequest.getNome());

        if (disciplinaExistente != null){
            throw new DuplicateException("Disciplina já foi cadastrada");
        }
        Disciplina disciplina = new Disciplina();

        BeanUtils.copyProperties(disciplinaRequest,disciplina);

        Disciplina disciplinaSalva = disciplinaRepository.save(disciplina);
        return new DisciplinaResponse(disciplinaSalva.getId(),disciplinaSalva.getNome());

    }
    public DisciplinaResponse atualizar(int id, DisciplinaUpdateRequest disciplinaUpdateRequest){
        Optional<Disciplina> disciplinaOptional = disciplinaRepository.findById(id);

        if (disciplinaOptional.isEmpty()){
            throw new NotFoundException("Disciplina não encontrado");
        }
        Disciplina disciplina = new Disciplina();

        BeanUtils.copyProperties(disciplinaUpdateRequest,disciplina);

        Disciplina disciplinaSalva = disciplinaRepository.save(disciplina);

        return new DisciplinaResponse(disciplinaSalva.getId(),disciplinaSalva.getNome());
    }
    public List<DisciplinaResponse> listarDisciplinas(){
        return disciplinaRepository.findAll().stream().map(disciplina ->
                new DisciplinaResponse(disciplina.getId(),disciplina.getNome())).toList();
    }

}
