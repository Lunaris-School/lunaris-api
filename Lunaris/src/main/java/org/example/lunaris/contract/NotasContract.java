package org.example.lunaris.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.lunaris.dto.request.NotasRequestDTO;
import org.example.lunaris.dto.response.NotasResponseDTO;
import org.springframework.http.ResponseEntity;

@Tag(name = "Notas Controller", description = "Gerenciamento de notas")
public interface NotasContract {

    @Operation(summary = "Lançar nota no boletim")
    ResponseEntity<NotasResponseDTO> lancarNota(NotasRequestDTO dto);
}
