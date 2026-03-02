package org.example.lunaris.controller;

import org.example.lunaris.contract.AutenticacaoContract;
import org.example.lunaris.dto.login.LoginRequestDTO;
import org.example.lunaris.dto.login.LoginResponseDTO;
import org.example.lunaris.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController implements AutenticacaoContract {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AutenticacaoController(AuthenticationManager authenticationManager,
                          JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) throws Exception {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequestDTO.getEmail(),
                                loginRequestDTO.getSenha()
                        )
                );

        String token = jwtService.generarToken(authentication);

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @Override
    @GetMapping("/buscarDetalhesUsuario")
    public ResponseEntity<?> get(JwtAuthenticationToken token){
        String email = token.getName();
        String role = token.getToken().getClaim("role");
        Long userId = token.getToken().getClaim("userId");

        return ResponseEntity.ok(Map.of(
                "id", userId,
                "email", email,
                "role", role
        ));
    }
}
