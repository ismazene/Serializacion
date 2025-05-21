package org.example;

import java.io.*;
import java.util.*;

public class SerializarMapa {
    public static void main(String[] args) {
        HashMap<String, Persona> mapa = new HashMap<>();
        mapa.put("carlos", new Persona("Carlos", 30));
        mapa.put("lucia", new Persona("Lucía", 25));
        mapa.put("ana", new Persona("Ana", 40));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("mapa.ser"))) {
            out.writeObject(mapa);
            System.out.println("Mapa serializado en mapa.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("mapa.ser"))) {
            HashMap<String, Persona> mapaRecuperado = (HashMap<String, Persona>) in.readObject();

            TreeMap<String, Persona> mapaOrdenado = new TreeMap<>(mapaRecuperado);

            for (Map.Entry<String, Persona> entry : mapaOrdenado.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
