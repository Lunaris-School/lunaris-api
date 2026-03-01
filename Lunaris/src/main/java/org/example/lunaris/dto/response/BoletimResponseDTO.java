package org.example.lunaris.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class BoletimResponseDTO {

    private Integer id;
    private Long alunoCpf;
    private String alunoNome;
    private Integer turmaId;
    private String turmaNome;
    private Double mediaFinal;
    private List<NotasResponseDTO> notas;

    public BoletimResponseDTO() {

    }
    public BoletimResponseDTO(Integer id, Long alunoCpf, String alunoNome, Integer turmaId, String turmaNome, Double mediaFinal, List<NotasResponseDTO> notas) {
        this.id = id;
        this.alunoCpf = alunoCpf;
        this.alunoNome = alunoNome;
        this.turmaId = turmaId;
        this.turmaNome = turmaNome;
        this.mediaFinal = mediaFinal;
        this.notas = notas;
    }

    public Integer getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Integer turmaId) {
        this.turmaId = turmaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAlunoCpf() {
        return alunoCpf;
    }

    public void setAlunoCpf(Long alunoCpf) {
        this.alunoCpf = alunoCpf;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public Double getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(Double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public List<NotasResponseDTO> getNotas() {
        return notas;
    }

    public void setNotas(List<NotasResponseDTO> notas) {
        this.notas = notas;
    }
}
