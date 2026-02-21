package org.example.lunaris.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "turma_disciplina_professor")
@Getter
@Setter
public class TurmaProfessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "turma_id", nullable = false)
    private Integer turmaId;

    @Column(name = "disciplina_id", nullable = false)
    private Integer disciplinaId;

    @Column(name = "professor_id", nullable = false)
    private Integer professorId;
}
