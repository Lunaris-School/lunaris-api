package org.example.lunaris.service;

import org.example.lunaris.dto.request.TurmaRequestDTO;
import org.example.lunaris.dto.response.TurmaResponseDTO;
import org.example.lunaris.exception.DuplicateException;
import org.example.lunaris.exception.NotFoundException;
import org.example.lunaris.model.Professor;
import org.example.lunaris.model.Turma;
import org.example.lunaris.model.TurmaProfessor;
import org.example.lunaris.repository.ProfessorRepository;
import org.example.lunaris.repository.TurmaProfessorRepository;
import org.example.lunaris.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final ProfessorRepository professorRepository;
    private final TurmaProfessorRepository turmaProfessorRepository;

    public TurmaService(TurmaRepository turmaRepository, ProfessorRepository professorRepository, TurmaProfessorRepository turmaProfessorRepository) {
        this.turmaRepository = turmaRepository;
        this.professorRepository = professorRepository;
        this.turmaProfessorRepository = turmaProfessorRepository;
    }

    public List<TurmaResponseDTO> buscarPorTurma(Long cpf) {

        Professor professor = professorRepository.findById(cpf)
                .orElseThrow(() -> new NotFoundException("Professor não encontrado"));

        List<TurmaProfessor> vinculos =
                turmaProfessorRepository.findByProfessor(professor);

        return vinculos.stream()
                .map(v -> {
                    Turma turma = turmaRepository.findById(v.getTurma().getId())
                            .orElseThrow();

                    return new TurmaResponseDTO(
                            turma.getId(),
                            turma.getNome(),
                            String.valueOf(turma.getAnoLetivo()),
                            professor.getCpf(),
                            professor.getNome()
                    );
                })
                .toList();
    }

    public TurmaResponseDTO salvarTurma(TurmaRequestDTO dto) {

        Turma turmaExistente = turmaRepository.findByNome(dto.getNome());
        if (turmaExistente != null){
            throw new DuplicateException("Turma já foi cadastrada");
        }

        Professor professor = professorRepository.findById(dto.getProfessorCpf())
                .orElseThrow(() ->
                        new NotFoundException("Professor não encontrado"));

        Turma turma = new Turma();
        turma.setNome(dto.getNome());
        turma.setAnoLetivo(dto.getAnoLetivo());

        Turma turmaSalva = turmaRepository.save(turma);

        TurmaProfessor vinculo = new TurmaProfessor();
        vinculo.setTurma(turmaSalva);
        vinculo.setProfessor(professor);

        turmaProfessorRepository.save(vinculo);

        return new TurmaResponseDTO(
                turmaSalva.getId(),
                turmaSalva.getNome(),
                String.valueOf(turmaSalva.getAnoLetivo()),
                professor.getCpf(),
                professor.getNome()
        );
    }

    public void deletarTurma(Integer id) {

        Turma turma = turmaRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Turma não encontrada"));

        turmaProfessorRepository.deleteByTurma(id);

        turmaRepository.delete(turma);
    }
}
