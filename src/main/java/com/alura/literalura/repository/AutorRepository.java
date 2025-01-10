package com.alura.literalura.repository;

import com.alura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a LEFT JOIN FETCH a.libros")
    List<Autor> findAllConLibros();

    @Query("SELECT a FROM Autor a LEFT JOIN FETCH a.libros WHERE(a.anioMuerte IS NULL OR " +
            "a.anioMuerte > :anio) AND a.anioNacido <= :anio")
    List<Autor> findAutoresVivosConLibros(@Param("anio")int anio);

    Optional<Autor> findByNombre(String nombre);
}
