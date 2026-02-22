package org.example.lunaris.dto.response;

public class DisciplinaResponseDTO {
    Integer id;
    String nome;

    public DisciplinaResponseDTO() {
    }
    public DisciplinaResponseDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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
}
