package org.example.lunaris.service;


import jakarta.transaction.Transactional;
import org.example.lunaris.Enum.RoleEnum;
import org.example.lunaris.dto.request.AlunoPatchRequestDTO;
import org.example.lunaris.dto.request.AlunoRequestDTO;
import org.example.lunaris.dto.response.AlunoRankingDTO;
import org.example.lunaris.dto.response.AlunoResponseDTO;
import org.example.lunaris.dto.response.AlunoTurmaResponseDTO;
import org.example.lunaris.exception.DuplicateException;
import org.example.lunaris.exception.NotFoundException;
import org.example.lunaris.exception.PreCadastroNotFoundException;
import org.example.lunaris.model.*;
import org.example.lunaris.repository.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class AlunoService {
    private final AlunoRepository repository;
    private final GeneroRepository generoRepository;
    private final RoleRepository roleRepository;
    private final TurmaRepository turmaRepository;
    private final PreCadastroRepository preCadastroRepository;
    private final PasswordEncoder passwordEncoder;


    public AlunoService(AlunoRepository repository, GeneroRepository generoRepository, RoleRepository roleRepository, TurmaRepository turmaRepository, PreCadastroRepository preCadastroRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.generoRepository = generoRepository;
        this.roleRepository = roleRepository;
        this.turmaRepository = turmaRepository;
        this.preCadastroRepository = preCadastroRepository;
        this.passwordEncoder = passwordEncoder;
    }
    private Aluno fromDTO(AlunoRequestDTO dto){
        Aluno aluno = new Aluno();
        aluno.setCpf(dto.getCpf());
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setSenha(passwordEncoder.encode(dto.getSenha()));
        aluno.setMatricula(dto.getMatricula());
        aluno.setGeneroId(dto.getGeneroId());

        return aluno;
    }

    private AlunoResponseDTO toDTO(Aluno aluno){
        return new AlunoResponseDTO(
                aluno.getCpf(),
                aluno.getNome(),
                aluno.getMatricula(),
                aluno.getEmail(),
                aluno.getGeneroId(),
                aluno.getTurma().getId()
        );
    }


    @Transactional
    public AlunoResponseDTO criarAluno(AlunoRequestDTO dto){
        Aluno alunoExistente = repository.buscaPorCpf(dto.getCpf());

        if (alunoExistente != null){
            throw new DuplicateException("Aluno já foi cadastrado");
        }

        Optional<PreCadastro> preCadastro = preCadastroRepository.findByAlunoCpf(dto.getCpf());

        if(preCadastro.isEmpty()){
            throw new PreCadastroNotFoundException("Esse aluno ainda não foi pré-cadastrado");
        }
        Integer turmaId = preCadastro.get().getTurmaId();

        preCadastroRepository.delete(preCadastro.get());

        Genero genero = generoRepository.buscaPorId(dto.getGeneroId());
        if(genero == null){
            throw new NotFoundException("Genero não encontrado");
        }

        Optional<Turma> turma = turmaRepository.findById(turmaId);

        if (turma.isEmpty()){
            throw new NotFoundException("Turma não encontrada");
        }

        Aluno aluno = fromDTO(dto);

        Role alunoRole = roleRepository.findByNome(RoleEnum.ALUNO.name());

        aluno.setRole(alunoRole);
        aluno.setTurma(turma.get());

        return toDTO(repository.save(aluno));
    }

    @Transactional
    public AlunoResponseDTO atualizarAluno(Long cpf, AlunoPatchRequestDTO dto){
        Aluno aluno = repository.buscaPorCpf(cpf);
        if(aluno == null){
            throw new NotFoundException("Aluno não encontrado");
        }

        if(dto.getNome() != null) aluno.setNome(dto.getNome());
        if(dto.getEmail() != null) aluno.setEmail(dto.getEmail());
        if(dto.getSenha() != null) aluno.setSenha(dto.getSenha());
        if(dto.getGeneroId() != null) {
            Genero genero = generoRepository.buscaPorId(dto.getGeneroId());
            if(genero == null){
                throw new NotFoundException("Genero não encontrado");
            }
            aluno.setGeneroId(dto.getGeneroId());
        }

        return toDTO(repository.save(aluno));
    }

    public AlunoResponseDTO buscarAluno(Long cpf){
        Aluno aluno = repository.buscaPorCpf(cpf);
        if(aluno == null){
            throw new NotFoundException("Aluno não encontrado");
        }
        return toDTO(aluno);
    }

    public List<AlunoResponseDTO> listarAlunos(){
        return repository.findAll().stream().map(this::toDTO).collect(toList());
    }

    public List<AlunoRankingDTO> getRanking(Long professorCpf,Integer disciplinaId, Integer quantidade){
        Pageable limite = PageRequest.of(0,quantidade);
        List<Object[]> dados = repository.rankingAlunos(professorCpf,disciplinaId, limite);
        return dados.stream().map(object ->{
            return new AlunoRankingDTO((String) object[0], Math.floor((Double) object[1] * 100) /100, (String) object[2], (String) object[3]);
        }).toList();
    }
    public List<AlunoTurmaResponseDTO> listarAlunosPorTurma(Integer ano){
        List<Object[]> dados = repository.countAlunosByTurma(ano);

        return dados.stream().map(object ->{
            Number total = (Number) object[0];
            return new AlunoTurmaResponseDTO(total.longValue(),(String) object[1], String.valueOf((Integer) object[2]));
        }).toList();
    }
}
