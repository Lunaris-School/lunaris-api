package org.example.lunaris.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "notas")
@Getter
@Setter
public class Notas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "boletim_id", nullable = false)
    private Boletim boletim;

    @Column(name = "valor_nota", nullable = false)
    private Integer valorNota;

    @Column(name = "tipo_avaliacao", nullable = false)
    private String tipoAvaliacao;

    @Column(name = "data_lancamento", nullable = false)
    private LocalDate dataLancamento;
}
