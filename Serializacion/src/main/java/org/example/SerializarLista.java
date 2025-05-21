package org.example;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SerializarLista {
    public static void main(String[] args) {
        ArrayList<Persona> lista = new ArrayList<>();
        lista.add(new Persona("Carlos", 30));
        lista.add(new Persona("Lucía", 25));
        lista.add(new Persona("Ana", 40));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clase_prueba.ser"))) {
            out.writeObject(lista);
            System.out.println("Lista de personas serializada en clase_prueba.ser");
        } catch (IOException e) {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }
    }
}
