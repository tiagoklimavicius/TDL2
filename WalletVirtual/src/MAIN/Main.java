
package MAIN;

import DAO.*;
import Modelo.*;
import Interfaces.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonedaDAO monedaDAO = new MonedaDAOImpl();
        ActivoDAO activoDAO = new ActivoDAOImpl();
        StockDAO stockDAO = new StockDAOImpl();
        TransaccionDAO transaccionDAO = new TransaccionDAOImpl();

        boolean continuar = true;
        
        try (Connection connection = ConexionBD.getConnection();                      //Esto esta para que se elimine la tabla asi se cargan los datos en cada prueba
		         Statement stmt = connection.createStatement()) {					  // El conexion realizada aparece dos veces por culpa de este try and catch.
		        stmt.executeUpdate("DELETE FROM MONEDA");                             //Elimina los datos de moneda
		        stmt.executeUpdate("DELETE FROM ACTIVO");							  //Elimina los datos de activo
		        stmt.executeUpdate("DELETE FROM TRANSACCION");						//Elimina los datos de transaccion
		        stmt.executeUpdate("DELETE FROM STOCK");							//Elimina los datos de stock
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

        while (continuar) {
            System.out.println("Bienvenido al sistema de Billetera Virtual");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear Moneda");
            System.out.println("2. Listar Monedas");
            System.out.println("3. Generar Stock Aleatorio");
            System.out.println("4. Listar Stock");
            System.out.println("5. Generar Mis Activos");
            System.out.println("6. Listar Mis Activos");
            System.out.println("7. Simular Compra de Criptomoneda");
            System.out.println("8. Simular Swap de Criptomoneda");
            System.out.println("9. Salir");
            
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1: // Crear Moneda
                    crearMoneda(scanner, monedaDAO);
                    break;
                case 2: // Listar Monedas
                    listarMonedas(monedaDAO);
                    break;
                case 3: // Generar Stock Aleatorio
                    generarStockAleatorio(monedaDAO);							//aca tambien deberia pasarse stockDAO
                    break;
                case 4: // Listar Stock
                	System.out.println("Listado de stock");
      //              listarStock(monedaDAO);										//listar stock deberia tener otro parametro ya que las monedas no tienen el stock, a menos que les demos el stock a las monedas
                    break;
                case 5: // Generar Mis Activos
                	System.out.println("Generar activos");
                    //generarMisActivos(scanner, monedaDAO, activoDAO);
                    break;
                case 6: // Listar Mis Activos
                    listarMisActivos(activoDAO);
                    break;
                case 7: // Simular Compra de Criptomoneda
                    simularCompra(scanner, monedaDAO, activoDAO, transaccionDAO);
                    break;
                case 8: // Simular Swap de Criptomoneda
                    simularSwap(scanner, monedaDAO, activoDAO, transaccionDAO);
                    break;
                case 9: // Salir
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
                    break;
            }
        }
        
        scanner.close();
        ConexionBD.closeConnection(); // Cerrar la conexión al final
        System.out.println("Saliendo del sistema...");
    }

    // Métodos para cada opción del menú
    private static void crearMoneda(Scanner scanner, MonedaDAO monedaDAO) {
        System.out.println("Ingrese el tipo de moneda (C para Cripto o F para FIAT):");
        String tipo = scanner.next().toUpperCase();
        while (!tipo.equals("C") && !tipo.equals("F")) {
            System.out.println("Tipo inválido. Ingrese 'C' para Cripto o 'F' para FIAT:");
            tipo = scanner.next().toUpperCase();
        }

        System.out.println("Ingrese el nombre de la moneda:");
        String nombre = scanner.next();
        System.out.println("Ingrese la nomenclatura de la moneda:");
        String nomenclatura = scanner.next().toUpperCase();
        System.out.println("Ingrese el valor en dólares:");
        double valorDolar = scanner.nextDouble();
        System.out.println("Ingrese volatilidad:");
        double volatilidad = scanner.nextDouble();

        // Confirmación del usuario
        System.out.println("¿Confirma los datos? (S/N)");
        String confirmacion = scanner.next().toUpperCase();
        if (confirmacion.equals("S")) {
            monedaDAO.crear(new Moneda(tipo, nombre, nomenclatura, valorDolar, volatilidad));
            System.out.println("Moneda creada exitosamente.");
        }
    }

    private static void listarMonedas(MonedaDAO monedaDAO) {
        List<Moneda> monedas = monedaDAO.listar();
        monedas.sort((m1, m2) -> Double.compare(m2.getValorDolar(), m1.getValorDolar())); // Ordenar por valor en dólares
        System.out.println("Listado de Monedas (ordenadas por valor en dólares):");
        for (Moneda moneda : monedas) {
            System.out.println(moneda.getNomenclatura() + " - " + moneda.getNombre() + " - $" + moneda.getValorDolar());
        }
    }

    private static void generarStockAleatorio(MonedaDAO monedaDAO) {
        List<Moneda> monedas = monedaDAO.listar();
        Random random = new Random();
        for (Moneda moneda : monedas) {
            double nuevoStock = 1000 * random.nextDouble(); // Generar stock aleatorio
            monedaDAO.actualizar(new Moneda(moneda.getTipo(), moneda.getNombre(), moneda.getNomenclatura(), moneda.getValorDolar(), nuevoStock));
            System.out.println("Nuevo stock para " + moneda.getNomenclatura() + ": " + nuevoStock);
        }
    }

 //   private static void listarStock(MonedaDAO monedaDAO) {
 //       List<Moneda> monedas = monedaDAO.listar();
  //      monedas.sort((m1, m2) -> Double.compare(m2.getStock(), m1.getStock())); // Ordenar por stock
 //       System.out.println("Listado de Stock:");
 //       for (Moneda moneda : monedas) {
 //           System.out.println(moneda.getNomenclatura() + " - Stock: " + moneda.getStock());
 //       }
  //  }

  //  private static void generarMisActivos(Scanner scanner, MonedaDAO monedaDAO, ActivoDAO activoDAO) {
  //      System.out.println("Ingrese la nomenclatura de la moneda:");
  //      String nomenclatura = scanner.next().toUpperCase();
   //     Moneda moneda = monedaDAO.obtenerPorClave(nomenclatura);
   //     if (moneda != null) {
    //        System.out.println("Ingrese la cantidad:");
     //       double cantidad = scanner.nextDouble();
     //       activoDAO.crear(new Activo(nomenclatura, cantidad));
     //       System.out.println("Activo creado.");
     //   } else {
     //       System.out.println("Moneda no encontrada.");
     //   }
  //  }

    private static void listarMisActivos(ActivoDAO activoDAO) {
        List<Activo> activos = activoDAO.listar();
        activos.sort((a1, a2) -> Double.compare(a2.getCantidad(), a1.getCantidad())); // Ordenar por cantidad
        System.out.println("Listado de Activos:");
        for (Activo activo : activos) {
            System.out.println(activo.getNomenclatura() + " - Cantidad: " + activo.getCantidad());
        }
    }

    private static void simularCompra(Scanner scanner, MonedaDAO monedaDAO, ActivoDAO activoDAO, TransaccionDAO transaccionDAO) {
        // Implementar lógica para simular compra de criptomoneda
    }

    private static void simularSwap(Scanner scanner, MonedaDAO monedaDAO, ActivoDAO activoDAO, TransaccionDAO transaccionDAO) {
        // Implementar lógica para simular swap de criptomonedas
    }
}