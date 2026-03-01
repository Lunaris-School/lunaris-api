package org.example.lunaris.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "turma")
@Getter
@Setter
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 2)
    private String nome;

    @Column(name = "ano_letivo", nullable = false)
    private Integer anoLetivo;

    @OneToMany(mappedBy = "turma")
    List<TurmaProfessor> turmaProfessors;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(Integer anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public List<TurmaProfessor> getTurmaProfessors() {
        return turmaProfessors;
    }

    public void setTurmaProfessors(List<TurmaProfessor> turmaProfessors) {
        this.turmaProfessors = turmaProfessors;
    }
}
