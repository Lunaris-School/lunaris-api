package org.example.lunaris.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class BoletimResponseDTO {

    private Integer id;
    private Long alunoCpf;
    private String alunoNome;
    private Integer disciplinaId;
    private String disciplinaNome;
    private Integer mediaFinal;
    private List<NotasResponseDTO> notas;

    public BoletimResponseDTO() {

    }
    public BoletimResponseDTO(Integer id, Long alunoCpf, String alunoNome, Integer disciplinaId, String disciplinaNome, Integer mediaFinal, List<NotasResponseDTO> notas) {
        this.id = id;
        this.alunoCpf = alunoCpf;
        this.alunoNome = alunoNome;
        this.disciplinaId = disciplinaId;
        this.disciplinaNome = disciplinaNome;
        this.mediaFinal = mediaFinal;
        this.notas = notas;
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

    public Integer getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Integer disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public String getDisciplinaNome() {
        return disciplinaNome;
    }

    public void setDisciplinaNome(String disciplinaNome) {
        this.disciplinaNome = disciplinaNome;
    }

    public Integer getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(Integer mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public List<NotasResponseDTO> getNotas() {
        return notas;
    }

    public void setNotas(List<NotasResponseDTO> notas) {
        this.notas = notas;
    }
}
