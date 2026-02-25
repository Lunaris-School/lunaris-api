package org.example.lunaris.service;


import org.example.lunaris.Enum.RoleEnum;
import org.example.lunaris.dto.request.ProfessorPatchRequestDTO;
import org.example.lunaris.dto.request.ProfessorRequestDTO;
import org.example.lunaris.dto.response.ProfessorResponseDTO;
import org.example.lunaris.exception.NotFoundException;
import org.example.lunaris.model.Aluno;
import org.example.lunaris.model.Disciplina;
import org.example.lunaris.model.Professor;
import org.example.lunaris.model.Role;
import org.example.lunaris.repository.DisciplinaRepository;
import org.example.lunaris.repository.ProfessorRepository;
import org.example.lunaris.repository.RoleRepository;
import org.example.lunaris.repository.TurmaProfessorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final DisciplinaRepository disciplinaRepository;

    private final RoleRepository roleRepository;
    private final TurmaProfessorRepository turmaProfessorRepository;
    private final PasswordEncoder passwordEncoder;


    public ProfessorService(ProfessorRepository professorRepository, DisciplinaRepository disciplinaRepository, RoleRepository roleRepository, TurmaProfessorRepository turmaProfessorRepository, PasswordEncoder passwordEncoder) {
        this.professorRepository = professorRepository;
        this.disciplinaRepository = disciplinaRepository;
        this.roleRepository = roleRepository;
        this.turmaProfessorRepository = turmaProfessorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ProfessorResponseDTO getProfessorById(Long cpf) {
        Professor professor = findProfessor(cpf);
        return toDTO(professor);
    }

    public ProfessorResponseDTO salvarProfessor(ProfessorRequestDTO dto) {

        Disciplina disciplina = disciplinaRepository.findById(dto.getDisciplinaId())
                .orElseThrow(() -> new NotFoundException("Disciplina não encontrada"));

        System.out.println(dto.getCpf());
        Professor professor = new Professor();
        professor.setCpf(dto.getCpf());
        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());
        professor.setSenha(passwordEncoder.encode(dto.getSenha()));
        professor.setDisciplina(disciplina);
        professor.setDataContratacao(dto.getDataContratacao());

        Role professorRole = roleRepository.findByNome(RoleEnum.PROFESSOR.name());
        professor.setRole(professorRole);

        System.out.println(professor);

        return toDTO(professorRepository.save(professor));
    }

    public ProfessorResponseDTO atualizarProfessor(Long cpf, ProfessorPatchRequestDTO dto) {

        Professor professor = findProfessor(cpf);

        Disciplina disciplina = disciplinaRepository.findById(dto.getDisciplinaId())
                .orElseThrow(() -> new NotFoundException("Disciplina não encontrada"));

        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());
        professor.setSenha(passwordEncoder.encode(dto.getSenha()));
        professor.setDisciplina(disciplina);
        professor.setDataContratacao(dto.getDataContratacao());


        return toDTO(professorRepository.save(professor));
    }

    public ProfessorResponseDTO atualizarParcialProfessor(Long cpf, ProfessorPatchRequestDTO dto) {

        Professor professor = findProfessor(cpf);
        if (dto.getNome() != null) professor.setNome(dto.getNome());
        if (dto.getEmail() != null) professor.setEmail(dto.getEmail());
        if (dto.getSenha() != null) professor.setSenha(dto.getSenha());
        if (dto.getDisciplinaId() != null) professo
        if (dto.getDataContratacao() != null) professor.setDataContratacao(dto.getDataContratacao());


        return toDTO(professorRepository.save(professor));
    }

    public void deletarProfessor(Long cpf) {
        Professor professor = findProfessor(cpf);

        turmaProfessorRepository.deleteByProfessor(cpf);

        professorRepository.delete(professor);
    }

    public List<Aluno> buscarAlunosDoProfessor(Long professorCpf) {
        return professorRepository.buscarAlunosDoProfessor(professorCpf);
    }

    private Professor findProfessor(Long cpf) {
        return professorRepository.findById(cpf)
                .orElseThrow(() -> new NotFoundException("Professor não encontrado"));
    }

    private ProfessorResponseDTO toDTO(Professor professor) {
        return new ProfessorResponseDTO(
                professor.getCpf(),
                professor.getNome(),
                professor.getEmail(),
                professor.getDisciplina().getNome(),
                professor.getDataContratacao()
                );
    }
}
