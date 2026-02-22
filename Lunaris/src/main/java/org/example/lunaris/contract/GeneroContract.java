package org.example.lunaris.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.lunaris.dto.request.GeneroRequestDTO;
import org.example.lunaris.dto.response.GeneroResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Genero Controller", description = "Gerenciamento de gêneros")
public interface GeneroContract {
    @Operation(summary = "Listar gêneros",
            description = "Retorna todos os gêneros cadastrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de gêneros retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneroResponseDTO.class))),
            @ApiResponse(responseCode = "204", description = "Nenhum gênero encontrado")
    })
    ResponseEntity<List<GeneroResponseDTO>> listar();

    @Operation(summary = "Criar novo gênero",
            description = "Cria um novo gênero no sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Gênero criado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneroResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    ResponseEntity<GeneroResponseDTO> inserir(GeneroRequestDTO dto);

    @Operation(summary = "Atualizar gênero",
            description = "Atualiza os dados de um gênero existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Gênero atualizado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneroResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Gênero não encontrado")
    })
    ResponseEntity<GeneroResponseDTO> atualizar(Integer id, GeneroRequestDTO dto);
}
