package com.example.cineplusbackend.controller;

import com.example.cineplusbackend.model.Venta;
import com.example.cineplusbackend.repository.VentaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/ventas")
@CrossOrigin(origins = "*")
public class VentaController {

    private final VentaRepository repository;

    public VentaController(VentaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Venta> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Venta getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Venta create(@RequestBody Venta data) {
        Venta venta = new Venta(data.getTotalNeto(), data.getIva(), data.getTotal());
        return repository.save(venta);
    }
}
