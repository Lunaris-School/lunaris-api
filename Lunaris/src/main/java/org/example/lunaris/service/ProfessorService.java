package org.example.lunaris.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.lunaris.dto.request.ProfessorPatchRequestDTO;
import org.example.lunaris.dto.request.ProfessorRequestDTO;
import org.example.lunaris.dto.response.ProfessorResponseDTO;
import org.example.lunaris.model.Aluno;
//import org.example.lunaris.model.Disciplina;
//import org.example.lunaris.model.Escola;
import org.example.lunaris.model.Disciplina;
import org.example.lunaris.model.Professor;
//import org.example.lunaris.repository.DisciplinaRepository;
//import org.example.lunaris.repository.EscolaRepository;
import org.example.lunaris.repository.DisciplinaRepository;
import org.example.lunaris.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final DisciplinaRepository disciplinaRepository;


    public List<ProfessorResponseDTO> buscarPorEscola(Integer escolaId) {
        return professorRepository.buscarPorEscola(escolaId)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public ProfessorResponseDTO getProfessorById(Integer id) {
        Professor professor = findProfessor(id);
        return toDTO(professor);
    }

    public ProfessorResponseDTO salvarProfessor(ProfessorRequestDTO dto) {

        Disciplina disciplina = disciplinaRepository.findById(dto.getDisciplinaId())
                .orElseThrow(() -> new EntityNotFoundException("Disciplina não encontrada"));
//
//        Escola escola = escolaRepository.findById(dto.getEscolaId())
//                .orElseThrow(() -> new EntityNotFoundException("Escola não encontrada"));

        Professor professor = new Professor();
        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());
        professor.setCpf(dto.getCpf());
        professor.setSenha(dto.getSenha());
        professor.setDataContratacao(dto.getData_contratacao());
//        professor.setDisciplina(disciplina);
//        professor.setEscola(escola);

        return toDTO(professorRepository.save(professor));
    }

    public ProfessorResponseDTO atualizarProfessor(Integer id, ProfessorRequestDTO dto) {

        Professor professor = findProfessor(id);

        Disciplina disciplina = disciplinaRepository.findById(dto.getDisciplinaId())
                .orElseThrow(() -> new EntityNotFoundException("Disciplina não encontrada"));
//
//        Escola escola = escolaRepository.findById(dto.getEscolaId())
//                .orElseThrow(() -> new EntityNotFoundException("Escola não encontrada"));

        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());
        professor.setCpf(dto.getCpf());
        professor.setSenha(dto.getSenha());
        professor.setDataContratacao(dto.getData_contratacao());
//        professor.setDisciplina(disciplina);
//        professor.setEscola(escola);

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
                    .orElseThrow(() -> new EntityNotFoundException("Disciplina não encontrada"));
            professor.setDisciplina(disciplina);
        }

        return toDTO(professorRepository.save(professor));
    }

    public void deletarProfessor(Integer id) {
        Professor professor = findProfessor(id);
        professorRepository.delete(professor);
    }

    public List<Aluno> buscarAlunosDoProfessor(Integer idProfessor) {
        return professorRepository.buscarAlunosDoProfessor(idProfessor);
    }

    private Professor findProfessor(Integer id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));
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
