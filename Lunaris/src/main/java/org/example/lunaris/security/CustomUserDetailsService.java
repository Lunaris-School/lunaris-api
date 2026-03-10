package org.example.lunaris.security;

import org.example.lunaris.exception.NotFoundException;
import org.example.lunaris.model.Administrador;
import org.example.lunaris.model.Aluno;
import org.example.lunaris.model.Professor;
import org.example.lunaris.repository.AdministradorRepository;
import org.example.lunaris.repository.AlunoRepository;
import org.example.lunaris.repository.ProfessorRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final AlunoRepository alunoRepository;
    private final AdministradorRepository administradorRepository;

    private final ProfessorRepository professorRepository;

    public CustomUserDetailsService(AlunoRepository alunoRepository, AdministradorRepository administradorRepository, ProfessorRepository professorRepository) {
        this.alunoRepository = alunoRepository;
        this.administradorRepository = administradorRepository;
        this.professorRepository = professorRepository;
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
        Optional<Professor> professor = professorRepository.findByEmail(email);
        if (professor.isPresent()){
            return buildUser(professor.get().getEmail(),professor.get().getSenha(),professor.get().getRole().getNome());
        }
        throw new NotFoundException("Usuário não encontrado");

    }
    private UserDetails buildUser(String email, String password, String role) {

        return User.builder().username(email).password(password).roles(role).build();
    }

    public Map<String, Object> buscarIdUsuario(String email){
        Map<String, Object> objectMap = new HashMap<>();
        Optional<Aluno> aluno = alunoRepository.findByEmail(email);
        if (aluno.isPresent()){
            objectMap.put("id",aluno.get().getCpf());
            objectMap.put("nome",aluno.get().getNome());
            return objectMap;
        }
        Optional<Administrador> admin = Optional.ofNullable(administradorRepository.findByEmail(email));
        if (admin.isPresent()){
            objectMap.put("id",Long.valueOf(admin.get().getId()));
            objectMap.put("nome",admin.get().getNome());
            return objectMap;
        }
        Optional<Professor> professor = professorRepository.findByEmail(email);
        if (professor.isPresent()){
            objectMap.put("id",professor.get().getCpf());
            objectMap.put("nome",professor.get().getNome());
            return objectMap;
        }
        throw new NotFoundException("Usuário não encontrado");
    }
}
