package com.example.cineplusbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fecha;
    private Integer totalNeto;
    private Integer iva;
    private Integer total;

    public Venta() {
    }

    public Venta(Integer totalNeto, Integer iva, Integer total) {
        this.fecha = java.time.LocalDateTime.now().toString();
        this.totalNeto = totalNeto;
        this.iva = iva;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public Integer getTotalNeto() {
        return totalNeto;
    }

    public Integer getIva() {
        return iva;
    }

    public Integer getTotal() {
        return total;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTotalNeto(Integer totalNeto) {
        this.totalNeto = totalNeto;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
