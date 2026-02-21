package org.example.lunaris.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "professor")
@Getter
@Setter
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProfessor;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private Long cpf;

    @Column(nullable = false)
    private String senha;

    @Column(name = "data_contratacao", nullable = false)
    private Date dataContratacao;

    @Column(name= "role_id")
    private Integer roleId;
//
//    @ManyToOne
//    @JoinColumn(name = "disciplina_id", nullable = false)
//    private Disciplina disciplina;
//
//    @ManyToOne
//    @JoinColumn(name = "escola_id", nullable = false)
//    private Escola escola;

    @OneToMany(mappedBy = "professor")
    private List<Turma> turmas;
}
