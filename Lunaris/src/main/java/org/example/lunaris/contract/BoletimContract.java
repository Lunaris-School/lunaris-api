package org.example.lunaris.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.lunaris.dto.request.BoletimRequestDTO;
import org.example.lunaris.dto.response.BoletimResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Boletim Controller", description = "Gerenciamento de boletins")
public interface BoletimContract {
    @Operation(summary = "Criar boletim")
    ResponseEntity<BoletimResponseDTO> criar(BoletimRequestDTO dto);

    @Operation(summary = "Buscar boletins por aluno")
    ResponseEntity<List<BoletimResponseDTO>> buscarPorAluno(Integer id);
}
