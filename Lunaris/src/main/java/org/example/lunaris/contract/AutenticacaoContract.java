package org.example.lunaris.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.lunaris.dto.login.LoginRequestDTO;
import org.example.lunaris.dto.login.LoginResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

@Tag(name = "Autenticação Controller", description = "Gerenciamento de login e permissões")
public interface AutenticacaoContract {
    @Operation(
            summary = "Realiza login",
            description = "Autentica o usuário e retorna um JWT contendo id e role"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = LoginResponseDTO.class))),
            @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    })
    ResponseEntity<LoginResponseDTO> login(LoginRequestDTO loginRequestDTO) throws Exception;

    @Operation(
            summary = "Retorna dados do usuário autenticado",
            description = "Retorna id, email e role do usuário logado"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dados retornados com sucesso"),
            @ApiResponse(responseCode = "401", description = "Não autenticado")
    })
    ResponseEntity<?> get(JwtAuthenticationToken token);
}
