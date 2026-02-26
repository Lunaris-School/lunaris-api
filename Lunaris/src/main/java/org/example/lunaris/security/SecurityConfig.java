package org.example.lunaris.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable()) // desativa CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                );

        return http.build();
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
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}