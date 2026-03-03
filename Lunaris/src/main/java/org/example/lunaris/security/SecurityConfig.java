package org.example.lunaris.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Value("${jwt.public-key}")
    private String publicKeyString;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors(cors -> {})
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers(
                            "/swagger-ui/**",
                            "/v3/api-docs/**",
                            "/swagger-ui.html",
                            "/auth/login"
                    ).permitAll();
                    configurarRotasAdmin(authorize);
                    configurarRotasAluno(authorize);
                    configurarRotasProfessor(authorize);

                    authorize.anyRequest().authenticated();
                })
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt ->
                        jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())
                ));

        return http.build();

    }

    @Bean
    public JwtDecoder jwtDecoder() throws Exception {
        PublicKey publicKey = carregarPublicKey();

        return NimbusJwtDecoder
                .withPublicKey((RSAPublicKey) publicKey)
                .build();
    }

    private PublicKey carregarPublicKey() throws Exception {
        byte[] decoded = Base64.getDecoder().decode(publicKeyString);

        X509EncodedKeySpec spec =
                new X509EncodedKeySpec(decoded);

        KeyFactory kf = KeyFactory.getInstance("RSA");

        return kf.generatePublic(spec);
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {

        JwtAuthenticationConverter converter =
                new JwtAuthenticationConverter();

        converter.setJwtGrantedAuthoritiesConverter(jwt -> {
            String role = jwt.getClaim("role");
            return List.of(new SimpleGrantedAuthority("ROLE_" + role));
        });

        return converter;
    }

    private void configurarRotasAdmin(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorize){
        authorize.requestMatchers("/api/admin/**").hasRole("ADMIN");
        authorize.requestMatchers("/api/disciplina/**").hasRole("ADMIN");
        authorize.requestMatchers("/api/pre-cadastro/**").hasRole("ADMIN");
        authorize.requestMatchers("/api/professor/deletar/{id}").hasRole("ADMIN");
        authorize.requestMatchers("/api/professor").hasRole("ADMIN");
        authorize.requestMatchers("/v1/turma").hasRole("ADMIN");
        authorize.requestMatchers("/v1/turma/deletar/").hasRole("ADMIN");
        authorize.requestMatchers("/genero/inserir").hasRole("ADMIN");
        authorize.requestMatchers("/genero/atualizar/").hasRole("ADMIN");
        authorize.requestMatchers("/api/professor/{id}").hasRole("ADMIN");
        authorize.requestMatchers("/v1/turma/listarTodas").hasAnyRole("ADMIN","PROFESSOR");

    }
    private void configurarRotasAluno(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorize){
        authorize.requestMatchers("/aluno/**").hasAnyRole("ALUNO", "ADMIN");
        authorize.requestMatchers("/v1/boletim/aluno/").hasRole("ALUNO");
        authorize.requestMatchers("/observacao/buscar/aluno/").hasRole("ALUNO");

    }
    private void configurarRotasProfessor(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorize){
        authorize.requestMatchers("/api/professor/atualizar-parcial/").hasRole("PROFESSOR");
        authorize.requestMatchers("/api/professor/{id}").hasRole("PROFESSOR");
        authorize.requestMatchers("/observacao/**").hasRole("PROFESSOR");
        authorize.requestMatchers("/v1/notas/**").hasRole("PROFESSOR");
        authorize.requestMatchers("/v1/boletim").hasRole("PROFESSOR");
        authorize.requestMatchers("/v1/turma/listarTurmaPorProfessor/").hasRole("PROFESSOR");

    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:5173"));
        configuration.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS", "PATCH"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration)
            throws Exception {

        return configuration.getAuthenticationManager();
    }
}