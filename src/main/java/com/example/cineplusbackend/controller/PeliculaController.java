package com.example.cineplusbackend.controller;

import com.example.cineplusbackend.model.Pelicula;
import com.example.cineplusbackend.repository.PeliculaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
@CrossOrigin(origins = "*")
public class PeliculaController {

    private final PeliculaRepository repository;

    public PeliculaController(PeliculaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Pelicula> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Pelicula create(@RequestBody Pelicula pelicula) {
        return repository.save(pelicula);
    }
}
