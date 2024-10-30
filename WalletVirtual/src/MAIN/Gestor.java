package MAIN;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import DAO.*;
import Interfaces.MonedaDAO;
import Modelo.Moneda;

public class Gestor {
	
	private MonedaDAO monedaDAO = new MonedaDAOImpl();
	Scanner scanner = new Scanner(System.in);
	public void crearMoneda() {
		System.out.println("Ingrese el tipo de moneda (C para Cripto o F para FIAT):");
        String tipo = scanner.next().toUpperCase();
        while (!tipo.equals("C") && !tipo.equals("F")) {
            System.out.println("Tipo inválido. Ingrese 'C' para Cripto o 'F' para FIAT:");
            tipo = scanner.next().toUpperCase();
        }
        scanner.nextLine();
        System.out.println("Ingrese el nombre de la moneda:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la nomenclatura de la moneda:");
        String nomenclatura = scanner.next().toUpperCase();
        System.out.println("Ingrese el valor en dólares:");
        double valorDolar = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ingrese volatilidad:");
        double volatilidad = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ingrese stock:");
        double stock = scanner.nextDouble();
        scanner.nextLine();

        // Confirmación del usuario
        System.out.println("¿Confirma los datos? (S/N)");
        String confirmacion = scanner.next().toUpperCase();
        if (confirmacion.equals("S")) {
        	
            monedaDAO.crear(new Moneda(tipo, nombre, nomenclatura, valorDolar, volatilidad, stock));
            System.out.println("Moneda creada exitosamente.");
        }
    }
	
	public void generarStock() {
		List<Moneda> monedas = monedaDAO.listar(); // Recupera todas las monedas
        Random random = new Random();
        for (Moneda moneda : monedas) {
            double stockAleatorio = 10 + (500 - 10) * random.nextDouble(); // Genera stock aleatorio
            moneda.setStock(stockAleatorio); // Asigna el stock aleatorio a la moneda
            monedaDAO.actualizar(moneda); // Actualiza la moneda en la base de datos
        }
        System.out.println("Stock generado aleatoriamente");
    }
}
