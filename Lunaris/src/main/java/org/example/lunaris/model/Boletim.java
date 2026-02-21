package org.example.lunaris.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "boletim")
@Getter
@Setter
public class Boletim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

//    @ManyToOne
//    @JoinColumn(name = "disciplina_id", nullable = false)
//    private Disciplina disciplina;

    @Column(name = "media_final")
    private Integer mediaFinal;

    @OneToMany(mappedBy = "boletim", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notas> notas;
}
