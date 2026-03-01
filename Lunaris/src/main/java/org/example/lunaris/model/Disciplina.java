package org.example.lunaris.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "disciplina")
@Data
@Getter
@Setter
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(name = "url_photo")
    private String urlFoto;

    @OneToMany(mappedBy = "disciplina")
    private List<Notas> notas = new ArrayList<>();

    public Disciplina() {
    }
    public Disciplina(Integer id, String nome, String urlFoto, List<Notas> notas) {
        this.id = id;
        this.nome = nome;
        this.urlFoto = urlFoto;
        this.notas = notas;
    }

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

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public List<Notas> getNotas() {
        return notas;
    }

    public void setNotas(List<Notas> notas) {
        this.notas = notas;
    }
}
