package org.example.lunaris.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.lunaris.dto.request.NotasRequestDTO;
import org.example.lunaris.dto.request.NotasUpdateRequestDTO;
import org.example.lunaris.dto.response.NotasResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Notas Controller", description = "Gerenciamento de notas")
public interface NotasContract {

    @Operation(summary = "Lançar nota no boletim")
    ResponseEntity<NotasResponseDTO> lancarNota(NotasRequestDTO dto);
    @Operation(summary = "Atualizar nota no boletim")
    ResponseEntity<NotasResponseDTO> atualizarNotas(Integer notaId,
                                                    NotasUpdateRequestDTO dto);
}
