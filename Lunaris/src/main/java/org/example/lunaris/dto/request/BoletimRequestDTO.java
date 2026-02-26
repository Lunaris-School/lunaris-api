package org.example.lunaris.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoletimRequestDTO {

    @NotNull
    private Integer alunoCpf;

    public @NotNull Integer getAlunoCpf() {
        return alunoCpf;
    }

    public void setAlunoCpf(@NotNull Integer alunoCpf) {
        this.alunoCpf = alunoCpf;
    }
}
