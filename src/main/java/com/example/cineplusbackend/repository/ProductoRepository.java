package com.example.cineplusbackend.repository;

import com.example.cineplusbackend.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
