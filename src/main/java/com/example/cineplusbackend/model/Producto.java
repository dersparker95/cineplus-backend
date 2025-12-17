package com.example.cineplusbackend.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer precio;
    private Integer stock;

    @ElementCollection
    private List<String> opciones;

    public Producto() {
    }

    public Producto(String nombre, Integer precio, Integer stock, List<String> opciones) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.opciones = opciones;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public Integer getStock() {
        return stock;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }
}
