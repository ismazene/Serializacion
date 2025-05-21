package org.example.Practica2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class ApiCripto {
    public static void main(String[] args) {
        try {
            String apiUrl = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin,ethereum&vs_currencies=usd,eur";

            URL url = new URL(apiUrl);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder json = new StringBuilder();
            String linea;
            while ((linea = in.readLine()) != null) {
                json.append(linea);
            }
            in.close();

            Gson gson = new Gson();
            Map<String, Criptomonedas.Moneda> datos = gson.fromJson(json.toString(), new TypeToken<Map<String, Criptomonedas.Moneda>>() {}.getType());

            System.out.println("Precios actuales:");
            for (String nombre : datos.keySet()) {
                Criptomonedas.Moneda m = datos.get(nombre);
                System.out.println( nombre.toUpperCase());
                System.out.println("USD: " + m.usd);
                System.out.println("EUR: " + m.eur);
            }

        } catch (Exception e) {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }
    }
}
