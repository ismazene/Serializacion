package org.example.Practica1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.*;

public class TiendaVideojuegos {
    public static void main(String[] args) {
        List<Videojuego> juegos = new ArrayList<>();

        juegos.add(new Videojuego("FIFA 23", "PS5", 59.99, true, Arrays.asList("Deportes")));
        juegos.add(new Videojuego("God of War", "PS5", 49.99, true, Arrays.asList("Acción", "Aventura")));
        juegos.add(new Videojuego("Gran Turismo 7", "PS5", 39.99, true, Arrays.asList("Carreras")));

        juegos.add(new Videojuego("Halo Infinite", "Xbox", 44.99, true, Arrays.asList("Acción", "Ciencia ficción")));
        juegos.add(new Videojuego("Forza Horizon 5", "Xbox", 34.99, true, Arrays.asList("Carreras")));
        juegos.add(new Videojuego("Minecraft", "Xbox", 19.99, true, Arrays.asList("Aventura", "Construcción")));

        juegos.add(new Videojuego("League of Legends", "PC", 0.00, true, Arrays.asList("MOBA", "Estrategia")));
        juegos.add(new Videojuego("Valorant", "PC", 0.00, true, Arrays.asList("Shooter", "Competitivo")));
        juegos.add(new Videojuego("Civilization VI", "PC", 29.99, true, Arrays.asList("Estrategia")));

        guardarEnJSON(juegos, "videojuegos.json");

        List<Videojuego> leidos = leerDesdeJSON("videojuegos.json");
        System.out.println("Lista leída desde JSON:");
        for (Videojuego v : leidos) {
            System.out.println(v);
        }

        leidos.add(new Videojuego("It Takes Two", "PC", 24.99, true, Arrays.asList("Cooperativo", "Aventura")));

        System.out.println("\nVideojuegos con precio menor a 30€:");
        for (Videojuego v : leidos) {
            if (v.precio < 30) {
                System.out.println(v);
            }
        }

        guardarEnJSON(leidos, "videojuegos.json");
    }

    private static void guardarEnJSON(List<Videojuego> lista, String archivo) {
        try (Writer writer = new FileWriter(archivo)) {
            new Gson().toJson(lista, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo JSON.");
        }
    }

    private static List<Videojuego> leerDesdeJSON(String archivo) {
        try (Reader reader = new FileReader(archivo)) {
            return new Gson().fromJson(reader, new TypeToken<List<Videojuego>>() {}.getType());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON.");
            return new ArrayList<>();
        }
    }
}
