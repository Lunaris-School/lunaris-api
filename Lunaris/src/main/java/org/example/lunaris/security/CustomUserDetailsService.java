package org.example.lunaris.security;

import org.example.lunaris.exception.NotFoundException;
import org.example.lunaris.model.Administrador;
import org.example.lunaris.model.Aluno;
import org.example.lunaris.repository.AdministradorRepository;
import org.example.lunaris.repository.AlunoRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final AlunoRepository alunoRepository;
    private final AdministradorRepository administradorRepository;

    public CustomUserDetailsService(AlunoRepository alunoRepository, AdministradorRepository administradorRepository) {
        this.alunoRepository = alunoRepository;
        this.administradorRepository = administradorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Aluno> aluno = alunoRepository.findByEmail(email);
        if (aluno.isPresent()){
            return buildUser(aluno.get().getEmail(),aluno.get().getSenha(),aluno.get().getRole().getNome());
        }
        Optional<Administrador> admin = Optional.ofNullable(administradorRepository.findByEmail(email));
        if (admin.isPresent()){
            return buildUser(admin.get().getEmail(),admin.get().getSenha(),admin.get().getRole().getNome());

        }
        throw new NotFoundException("Usuário não encontrado");

    }
    private UserDetails buildUser(String email, String password, String role) {

        return User.builder().username(email).password(password).roles(role).build();
    }
}
