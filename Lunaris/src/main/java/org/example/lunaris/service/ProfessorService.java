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

    public ProfessorResponseDTO getProfessorById(Integer id) {
        Professor professor = findProfessor(id);
        return toDTO(professor);
    }

    public ProfessorResponseDTO salvarProfessor(ProfessorRequestDTO dto) {

        Disciplina disciplina = disciplinaRepository.findById(dto.getDisciplinaId())
                .orElseThrow(() -> new NotFoundException("Disciplina não encontrada"));

        Professor professor = new Professor();
        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());
        professor.setCpf(dto.getCpf());
        professor.setSenha(passwordEncoder.encode(dto.getSenha()));
        professor.setDataContratacao(dto.getDataContratacao());
        professor.setDisciplina(disciplina);

        Role professorRole = roleRepository.findByNome(RoleEnum.PROFESSOR.name());

        professor.setRole(professorRole);

        return toDTO(professorRepository.save(professor));
    }

    public ProfessorResponseDTO atualizarProfessor(Integer id, ProfessorRequestDTO dto) {

        Professor professor = findProfessor(id);

        Disciplina disciplina = disciplinaRepository.findById(dto.getDisciplinaId())
                .orElseThrow(() -> new NotFoundException("Disciplina não encontrada"));

        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());
        professor.setCpf(dto.getCpf());
        professor.setSenha(passwordEncoder.encode(dto.getSenha()));
        professor.setDataContratacao(dto.getDataContratacao());
        professor.setDisciplina(disciplina);

        return toDTO(professorRepository.save(professor));
    }

    public ProfessorResponseDTO atualizarParcialProfessor(Integer id, ProfessorPatchRequestDTO dto) {

        Professor professor = findProfessor(id);

        if (dto.getNome() != null) professor.setNome(dto.getNome());
        if (dto.getEmail() != null) professor.setEmail(dto.getEmail());
        if (dto.getSenha() != null) professor.setSenha(dto.getSenha());
        if (dto.getDataContratacao() != null) professor.setDataContratacao(dto.getDataContratacao());

        if (dto.getDisciplinaId() != null) {
            Disciplina disciplina = disciplinaRepository.findById(dto.getDisciplinaId())
                    .orElseThrow(() -> new NotFoundException("Disciplina não encontrada"));
            professor.setDisciplina(disciplina);
        }

        return toDTO(professorRepository.save(professor));
    }

    public void deletarProfessor(Integer id) {
        Professor professor = findProfessor(id);

        turmaProfessorRepository.deleteByProfessor(id);

        professorRepository.delete(professor);
    }

    public List<Aluno> buscarAlunosDoProfessor(Integer idProfessor) {
        return professorRepository.buscarAlunosDoProfessor(idProfessor);
    }

    private Professor findProfessor(Integer id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Professor não encontrado"));
    }

    private ProfessorResponseDTO toDTO(Professor professor) {
        return new ProfessorResponseDTO(
                professor.getIdProfessor(),
                professor.getNome(),
                professor.getEmail(),
                professor.getCpf(),
                professor.getDataContratacao(),
                professor.getDisciplina().getNome());
    }
}
