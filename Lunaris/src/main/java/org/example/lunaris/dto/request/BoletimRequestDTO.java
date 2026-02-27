package org.example.lunaris.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoletimRequestDTO {

    @NotNull
    private Long alunoCpf;

    public BoletimRequestDTO() {
    }
    public BoletimRequestDTO(Long alunoCpf) {
        this.alunoCpf = alunoCpf;
    }

    public @NotNull Long getAlunoCpf() {
        return alunoCpf;
    }

    public void setAlunoCpf(@NotNull Long alunoCpf) {
        this.alunoCpf = alunoCpf;
    }
}
