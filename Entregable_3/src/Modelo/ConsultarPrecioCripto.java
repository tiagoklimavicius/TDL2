package Modelo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import DAO.MonedaDAOImpl;
import Interfaces.MonedaDAO;

import Entidad.Moneda;

public class ConsultarPrecioCripto extends Thread {
    private static final String URL_API = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin,ethereum,usd-coin,tether,dogecoin&vs_currencies=usd";

    private boolean continuar = true; // Variable para detener el hilo

    @Override
    public void run() {
        while (continuar) {
            consultarPrecios(); // Ejecutar la consulta
            try {
                Thread.sleep(30000); // Esperar 5 segundos entre cada consulta
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido.");
                detener(); // Detener si el hilo se interrumpe
            }
        }
    }

    private void consultarPrecios() {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(URL_API))
                .GET()
                .build();
        try {
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
            if (respuesta.statusCode() == 200) {
                parsearYMostrarPrecios(respuesta.body());
            } else if (respuesta.statusCode() == 429) {
                System.out.println("Error: 429 Too Many Requests. Esperando...");
                Thread.sleep(10000); // Espera 10 segundos antes de reintentar
            } else {
                System.out.println("Error: " + respuesta.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void parsearYMostrarPrecios(String cuerpoRespuesta) {
        JSONObject json = new JSONObject(cuerpoRespuesta);
        //obtengo las criptomonedas y les actualizo sus respectivos precios en la BD
        
        //instancio las variables a utilizar
        MonedaDAO monedaDAO = new MonedaDAOImpl();
        Moneda moneda;
        
        //para BITCOIN
        moneda = monedaDAO.obtener("BTC");
        moneda.setValorDolar(json.getJSONObject("bitcoin").getDouble("usd"));
        System.out.println(moneda.getValorDolar());
        monedaDAO.actualizar(moneda);
        
        //para ETHEREUM
        moneda = monedaDAO.obtener("ETH");
        moneda.setValorDolar(json.getJSONObject("ethereum").getDouble("usd"));
        System.out.println(moneda.getValorDolar());
        monedaDAO.actualizar(moneda);
        
        //para USDC
        moneda = monedaDAO.obtener("USDC");
        moneda.setValorDolar(json.getJSONObject("usd-coin").getDouble("usd"));
        System.out.println(moneda.getValorDolar());
        monedaDAO.actualizar(moneda);
        
        //para USDT
        moneda = monedaDAO.obtener("USDT");
        moneda.setValorDolar(json.getJSONObject("tether").getDouble("usd"));
        System.out.println(moneda.getValorDolar());
        monedaDAO.actualizar(moneda);
        
        //para DOGE
        moneda = monedaDAO.obtener("DOGE");
        moneda.setValorDolar(json.getJSONObject("dogecoin").getDouble("usd"));
        System.out.println(moneda.getValorDolar());
        monedaDAO.actualizar(moneda);
    }

    public void detener() {
        continuar = false; // Cambiar el estado para detener el bucle
    }
}