package org.example.Practica1;

import java.io.Serializable;
import java.util.List;

public class Videojuego implements Serializable {
    private String nombre;
    private String plataforma;
    double precio;
    private boolean disponible;
    private List<String> generos;

    public Videojuego(String nombre, String plataforma, double precio, boolean disponible, List<String> generos) {
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.precio = precio;
        this.disponible = disponible;
        this.generos = generos;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Plataforma: " + plataforma + ", Precio: " + precio +
                ", Disponible: " + disponible + ", Géneros: " + generos;
    }
}
