package com.example.cineplusbackend.repository;

import com.example.cineplusbackend.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
