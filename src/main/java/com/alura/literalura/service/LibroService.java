package com.alura.literalura.service;

import com.alura.literalura.model.Libro;
import com.alura.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> listaLibros() {
        return libroRepository.findAll();
    }

    public List<Libro> buscarLibrosPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }

    public Libro crearLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Optional<Libro> buscarLibroPorId(Long id) {
        return libroRepository.findById(id);
    }

    public Optional<Libro> buscarLibroPorTitulo(String titulo) {
        return libroRepository.findByTituloIgnoreCase(titulo);
    }

    public Libro actualizarLibro(Long id, Libro libroDescripcion) {
        Libro libro = libroRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        libro.setTitulo(libroDescripcion.getTitulo());
        libro.setIdioma(libroDescripcion.getIdioma());
        libro.setNumeroDescargas(libroDescripcion.getNumeroDescargas());
        libro.setAutor(libroDescripcion.getAutor());

        return libroRepository.save(libro);
    }

    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }
}
