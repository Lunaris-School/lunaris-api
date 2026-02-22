package org.example.lunaris.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.lunaris.dto.request.AdminCreateRequestDTO;
import org.example.lunaris.dto.request.AdminUpdateRequestDTO;
import org.example.lunaris.dto.response.AdminResponseDTO;
import org.example.lunaris.model.Administrador;
import org.springframework.http.ResponseEntity;

import java.util.List;
@Tag(name = "Administrador Controller", description = "Gerenciamento de administradores")
public interface AdministradorContract {

    @Operation(
            summary = "Cadastrar novo administrador",
            description = "Cria um novo administrador no sistema com role ADMIN."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Administrador cadastrado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AdminResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Administrador já cadastrado",
                    content = @Content
            )
    })
    ResponseEntity<AdminResponseDTO> cadastrar(AdminCreateRequestDTO adminResquest);

    @Operation(
            summary = "Atualizar administrador",
            description = "Atualiza os dados de um administrador existente pelo ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Administrador atualizado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AdminResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Administrador não encontrado",
                    content = @Content
            )
    })
    ResponseEntity<AdminResponseDTO> atualizar(int id, AdminUpdateRequestDTO adminUpdateRequest);

    @Operation(
            summary = "Lista os administradores",
            description = "Lista todos os administradores do banco."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Administradores retornados com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AdminResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Administradores não encontrado",
                    content = @Content
            )
    })
    ResponseEntity<List<AdminResponseDTO>> listarAdmins();

    @Operation(
            summary = "Busca um administrador",
            description = "Busca um administrador existente pelo ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Administrador retornado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Administrador.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Administrador não encontrado",
                    content = @Content
            )
    })
    ResponseEntity<Administrador> getById(int id);
}
