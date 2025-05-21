package org.example;

import java.io.Serializable;

public class Empleado implements Serializable {
    protected String nombre;
    protected double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public String toString() {
        return "Empleado: " + nombre + ", salario: " + salario;
    }
}
