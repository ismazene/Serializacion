package org.example;

public class Jefe extends Empleado {
    private String departamento;

    public Jefe(String nombre, double salario, String departamento) {
        super(nombre, salario);
        this.departamento = departamento;
    }

    public String toString() {
        return "Jefe: " + nombre + ", salario: " + salario + ", departamento: " + departamento;
    }
}
