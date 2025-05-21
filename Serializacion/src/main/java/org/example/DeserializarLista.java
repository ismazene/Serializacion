package org.example;

import java.io.*;
import java.util.ArrayList;

public class DeserializarLista {
    public static void main(String[] args) {
        ArrayList<Persona> lista = null;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("clase_prueba.ser"))) {
            lista = (ArrayList<Persona>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, creando uno con datos por defecto");
            lista = crearDatosPorDefecto();
            serializarLista(lista);
        } catch (IOException e) {
            System.out.println("Error de IO al leer el archivo, creando uno con datos por defecto");
            lista = crearDatosPorDefecto();
            serializarLista(lista);
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada.");
            e.printStackTrace();
        }

        if (lista != null) {
            for (Persona p : lista) {
                System.out.println(p);
            }
        }
    }

    private static ArrayList<Persona> crearDatosPorDefecto() {
        ArrayList<Persona> lista = new ArrayList<>();
        lista.add(new Persona("Default1", 20));
        lista.add(new Persona("Default2", 22));
        return lista;
    }

    private static void serializarLista(ArrayList<Persona> lista) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clase_prueba.ser"))) {
            out.writeObject(lista);
            System.out.println("Archivo clase_prueba.ser creado con datos por defecto.");
        } catch (IOException e) {
            System.out.println("Error al crear archivo con datos por defecto.");
            e.printStackTrace();
        }
    }
}
