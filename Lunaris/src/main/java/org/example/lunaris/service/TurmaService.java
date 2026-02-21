package org.example.lunaris.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.lunaris.dto.request.TurmaRequestDTO;
import org.example.lunaris.dto.response.TurmaResponseDTO;
import org.example.lunaris.model.Professor;
import org.example.lunaris.model.Turma;
import org.example.lunaris.model.TurmaProfessor;
import org.example.lunaris.repository.ProfessorRepository;
import org.example.lunaris.repository.TurmaProfessorRepository;
import org.example.lunaris.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final ProfessorRepository professorRepository;
    private final TurmaProfessorRepository turmaProfessorRepository;

    public List<TurmaResponseDTO> buscarPorTurma(Integer idProfessor) {

        List<TurmaProfessor> vinculos =
                turmaProfessorRepository.findByProfessorId(idProfessor);

        return vinculos.stream()
                .map(v -> {
                    Turma turma = turmaRepository.findById(v.getTurmaId())
                            .orElseThrow();

                    Professor professor = professorRepository.findById(idProfessor)
                            .orElseThrow();

                    return new TurmaResponseDTO(
                            turma.getId(),
                            turma.getNome(),
                            turma.getAnoLetivo(),
                            professor.getIdProfessor(),
                            professor.getNome()
                    );
                })
                .toList();
    }

    public TurmaResponseDTO salvarTurma(TurmaRequestDTO dto) {

        Professor professor = professorRepository.findById(dto.getProfessorId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Professor não encontrado"));

        Turma turma = new Turma();
        turma.setNome(dto.getNome());
        turma.setAnoLetivo(dto.getAnoLetivo());

        Turma turmaSalva = turmaRepository.save(turma);

        TurmaProfessor vinculo = new TurmaProfessor();
        vinculo.setTurmaId(turmaSalva.getId());
        vinculo.setProfessorId(dto.getProfessorId());
        vinculo.setDisciplinaId(dto.getDisciplinaId());

        turmaProfessorRepository.save(vinculo);

        return new TurmaResponseDTO(
                turmaSalva.getId(),
                turmaSalva.getNome(),
                turmaSalva.getAnoLetivo(),
                professor.getIdProfessor(),
                professor.getNome()
        );
    }

    public void deletarTurma(Integer id) {

        Turma turma = turmaRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Turma não encontrada"));

        turmaRepository.delete(turma);
    }
}
