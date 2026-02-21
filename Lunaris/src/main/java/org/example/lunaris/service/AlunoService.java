package org.example.lunaris.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.lunaris.dto.request.AlunoRequestDTO;
import org.example.lunaris.dto.response.AlunoResponseDTO;
import org.example.lunaris.model.Aluno;
import org.example.lunaris.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {
    private final AlunoRepository repository;
    private final ObjectMapper objectMapper;

    public AlunoService(AlunoRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }
    private Aluno fromDTO(AlunoRequestDTO dto){
        return objectMapper.convertValue(dto, Aluno.class);
    }

    private AlunoResponseDTO toDTO(Aluno aluno){
        return new AlunoResponseDTO(
                aluno.getCpf(),
                aluno.getNome(),
                aluno.getMatricula(),
                aluno.getEmail(),
                aluno.getRoleId(),
                aluno.getGeneroId()
        );
    }


    @Transactional
    public AlunoResponseDTO criarAluno(AlunoRequestDTO dto){
        Aluno aluno = fromDTO(dto);
        return toDTO(repository.save(aluno));
    }

    @Transactional
    public AlunoResponseDTO atualizarAluno(Long cpf, AlunoRequestDTO dto){
        Aluno aluno = repository.buscaPorCpf(cpf);
        if(aluno == null){
            throw new EntityNotFoundException("Aluno não encontrado");
        }

        if(dto.getNome() != null) aluno.setNome(dto.getNome());
        if(dto.getEmail() != null) aluno.setEmail(dto.getEmail());
        if(dto.getSenha() != null) aluno.setSenha(dto.getSenha());
        if(dto.getMatricula() != null) aluno.setMatricula(dto.getMatricula());
        if(dto.getGeneroId() != null) aluno.setGeneroId(dto.getGeneroId());
        if(dto.getRoleId() != null) aluno.setRoleId(dto.getRoleId());

        return toDTO(repository.save(aluno));
    }

    public AlunoResponseDTO buscarAluno(Long cpf){
        Aluno aluno = repository.buscaPorCpf(cpf);
        if(aluno == null){
            throw new EntityNotFoundException("Aluno não encontrado");
        }
        return toDTO(aluno);
    }

    public List<AlunoResponseDTO> listarAlunos(){
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }
}
