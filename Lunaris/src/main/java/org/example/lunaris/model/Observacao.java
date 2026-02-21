package org.example.lunaris.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "observacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Observacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long idAluno;

    private Long idProfessor;

    @Column(length = 500)
    private String observacao;
}
