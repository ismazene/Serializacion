package org.example;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private int edad;
    private transient String dni;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = "12345678X";
    }

    public String toString() {
        return nombre + " tiene " + edad + " años y DNI: " + dni;
    }
}
