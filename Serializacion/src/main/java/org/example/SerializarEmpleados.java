package org.example;

import java.io.*;
import java.util.*;

public class SerializarEmpleados {
    public static void main(String[] args) {
        ArrayList<Empleado> lista = new ArrayList<>();
        lista.add(new Empleado("Juan", 1000));
        lista.add(new Jefe("Maria", 2000, "Ventas"));
        lista.add(new Empleado("Pedro", 1200));
        lista.add(new Jefe("Ana", 2500, "Marketing"));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("empleados.ser"))) {
            out.writeObject(lista);
            System.out.println("Lista de empleados serializada en empleados.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserializar y mostrar
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("empleados.ser"))) {
            ArrayList<Empleado> listaRecuperada = (ArrayList<Empleado>) in.readObject();

            for (Empleado e : listaRecuperada) {
                System.out.println(e);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
