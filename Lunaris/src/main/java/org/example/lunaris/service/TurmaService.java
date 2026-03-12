package org.example.lunaris.service;

import org.example.lunaris.dto.request.TurmaRequestDTO;
import org.example.lunaris.dto.response.*;
import org.example.lunaris.exception.DuplicateException;
import org.example.lunaris.exception.NotFoundException;
import org.example.lunaris.model.*;
import org.example.lunaris.repository.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final ProfessorRepository professorRepository;
    private final TurmaProfessorRepository turmaProfessorRepository;
    private final TurmaDisciplinaRepository turmaDisciplinaRepository;
    private final DisciplinaRepository disciplinaRepository;

    public TurmaService(TurmaRepository turmaRepository, ProfessorRepository professorRepository, TurmaProfessorRepository turmaProfessorRepository, TurmaDisciplinaRepository turmaDisciplinaRepository, DisciplinaRepository disciplinaRepository) {
        this.turmaRepository = turmaRepository;
        this.professorRepository = professorRepository;
        this.turmaProfessorRepository = turmaProfessorRepository;
        this.turmaDisciplinaRepository = turmaDisciplinaRepository;
        this.disciplinaRepository = disciplinaRepository;
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
                            String.valueOf(turma.getAnoLetivo())
                    );
                })
                .toList();
    }

    public TurmaResponseDTO salvarTurma(TurmaRequestDTO dto) {

        Turma turmaExistente = turmaRepository.findByNome(dto.getNome());
        if (turmaExistente != null){
            throw new DuplicateException("Turma já foi cadastrada");
        }
        Turma turma = new Turma();
        turma.setNome(dto.getNome());
        turma.setAnoLetivo(dto.getAnoLetivo());

        Turma turmaSalva = turmaRepository.save(turma);

        return new TurmaResponseDTO(
                turmaSalva.getId(),
                turmaSalva.getNome(),
                String.valueOf(turmaSalva.getAnoLetivo())
        );
    }

    public boolean adicionarDisciplinas(Integer turmaId,List<Integer> disciplinasId){
        Turma turma = turmaRepository.findById(turmaId)
                .orElseThrow(() -> new NotFoundException("Turma não encontrado"));

        verificarDisciplinaProfessor(disciplinasId);

        for (Integer id : disciplinasId){
            Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
            Professor professor = professorRepository.findByDisciplina(disciplina.get());

            TurmaDisciplina turmaDisciplina = new TurmaDisciplina();
            turmaDisciplina.setTurma(turma);
            turmaDisciplina.setDisciplina(disciplina.get());

            TurmaProfessor turmaProfessor = new TurmaProfessor();
            turmaProfessor.setTurma(turma);
            turmaProfessor.setProfessor(professor);

            turmaDisciplinaRepository.save(turmaDisciplina);
            turmaProfessorRepository.save(turmaProfessor);
        }
        return true;
    }
    public void verificarDisciplinaProfessor(List<Integer> disciplinasId){
        for (Integer id : disciplinasId){
            Disciplina disciplina = disciplinaRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Disciplina não encontrado"));
            Professor professor = professorRepository.findByDisciplina(disciplina);

            if (professor == null){
                throw new NotFoundException("Nenhum professor foi encontrado para a disciplina");
            }
        }
    }

    public void deletarTurma(Integer id) {

        Turma turma = turmaRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Turma não encontrada"));

        turmaProfessorRepository.deleteByTurma(id);

        turmaRepository.delete(turma);
    }
    public List<TurmaResponseDTO> listarTurmas(){
        return turmaRepository.findAll().stream().map(turma ->
                new TurmaResponseDTO(turma.getId(),turma.getNome(),String.valueOf(turma.getAnoLetivo()))).toList();
    }
    public List<MediaTurmaDisciplinaDTO> listarMediaTurmaDisciplina(){
        List<Object[]> dados = turmaRepository.getMediaByDisciplina();
        return dados.stream().map(object -> (String) object[0])
                .distinct()
                .map(turma -> {
                    List<MediaDisciplinaDTO> disciplinas = dados.stream()
                            .filter(object -> object[0].equals(turma))
                            .map(object -> new MediaDisciplinaDTO(
                                    (String) object[1],
                                     Math.floor((Double) object[2] * 100)/ 100
                            ))
                            .toList();
                    return new MediaTurmaDisciplinaDTO(turma,disciplinas);
                })
        .toList();
    }

    public List<TurmaStatusResponseDTO> listarQuantidadeAlunoPorStatus(Long professorId){
        professorRepository.findById(professorId)
                .orElseThrow(() -> new NotFoundException("Professor não encontrado"));

        List<Object[]> dados = turmaRepository.getQuantidadeStatusByDisciplina(professorId);

        return dados.stream()
                .map(object -> new TurmaStatusResponseDTO(
                    (String) object[0],
                        List.of(new QuantidadeStatusResponseDTO(
                                ((Number) object[1]).intValue(),
                                ((Number) object[3]).intValue(),
                                ((Number) object[2]).intValue())
                        )))
                            .toList();
    }
}
