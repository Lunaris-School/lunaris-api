package org.example.lunaris.repository;


import org.example.lunaris.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {
    @Query("""
          SELECT g FROM Genero g WHERE g.id = :id
          """)
    Genero buscaPorId(@Param("id") Integer id);

    Genero findByNome(String nome);
}