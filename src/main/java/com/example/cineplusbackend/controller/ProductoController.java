package com.example.cineplusbackend.controller;

import com.example.cineplusbackend.model.Producto;
import com.example.cineplusbackend.repository.ProductoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Arrays;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoRepository repository;

    public ProductoController(ProductoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Producto> getAll() {
        if (repository.count() == 0) {
            List<Producto> productos = Arrays.asList(
                    new Producto("Jockey CinePlus", 8990, 10, Arrays.asList("Recto", "Curvo")),
                    new Producto("Polera CinePlus", 12990, 20, Arrays.asList("S", "M", "L", "XL")),
                    new Producto("Poster CinePlus", 5990, 15, Arrays.asList("Horizontal", "Vertical")),
                    new Producto("Llavero CinePlus", 3990, 30, Arrays.asList("Resina", "Metal")),
                    new Producto("Balde cabritas", 4990, 25, Arrays.asList("Chico", "Mediano", "Grande"))
            );
            repository.saveAll(productos);
        }
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Producto create(@RequestBody Producto producto) {
        return repository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable Long id, @RequestBody Producto data) {
        return repository.findById(id).map(p -> {
            p.setNombre(data.getNombre());
            p.setPrecio(data.getPrecio());
            p.setStock(data.getStock());
            p.setOpciones(data.getOpciones());
            return repository.save(p);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
