package com.example.proyecto_iweb.models.beans;

import java.sql.Blob;

public class Juegos {

     private int idJuegos;
     private String nombre;
     private String descripcion;
     private double precio;
     private double descuento;
     private int stock;
     private Blob foto;
     private boolean retirar_juego;
     private boolean juego_sugerido;
     private boolean Existentes;

    public boolean isExistentes() {
        return Existentes;
    }

    public void setExistentes(boolean existentes) {
        Existentes = existentes;
    }

    public int getIdJuegos() {
        return idJuegos;
    }

    public void setIdJuegos(int idJuegos) {
        this.idJuegos = idJuegos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public boolean isRetirar_juego() {
        return retirar_juego;
    }

    public void setRetirar_juego(boolean retirar_juego) {
        this.retirar_juego = retirar_juego;
    }

    public boolean isJuego_sugerido() {
        return juego_sugerido;
    }

    public void setJuego_sugerido(boolean juego_sugerido) {
        this.juego_sugerido = juego_sugerido;
    }
}
