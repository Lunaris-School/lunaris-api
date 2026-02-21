package org.example.lunaris.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Entity
@Table(name = "pre_cadastro")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class PreCadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "aluno_cpf")
    private BigInteger alunoCpf;
    @Column(name = "data_autorizacao")
    private LocalDateTime dataAutorizacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getAlunoCpf() {
        return alunoCpf;
    }

    public void setAlunoCpf(BigInteger alunoCpf) {
        this.alunoCpf = alunoCpf;
    }

    public LocalDateTime getDataAutorizacao() {
        return dataAutorizacao;
    }

    public void setDataAutorizacao(LocalDateTime dataAutorizacao) {
        this.dataAutorizacao = dataAutorizacao;
    }
}
