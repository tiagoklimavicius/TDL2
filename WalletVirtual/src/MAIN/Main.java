package MAIN;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.ConexionBD;
import DAO.MonedaDAOImpl;
import Interfaces.MonedaDAO;
import Modelo.Moneda;

public class Main {
	public static void main(String [] args) {
		try (Connection connection = ConexionBD.getConnection();                      //Esto esta para que se elimine la tabla asi se cargan los datos en cada prueba
		         Statement stmt = connection.createStatement()) {					  // El conexion realizada aparece dos veces por culpa de este try and catch.
		        stmt.executeUpdate("DELETE FROM MONEDA");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
	//PARA MONEDAS	
   	 MonedaDAO mon = new MonedaDAOImpl();
     // Crear monedas
     mon.crear(new Moneda("C", "Dogecoin", "DOGE", 3000.00, 99.00));
     mon.crear(new Moneda("F", "Pesos Argentinos", "ARS", 1000.00, 50.00));
     mon.crear(new Moneda("C", "Bitcoin", "BTC", 44000.00, 15.00));
     //Listar las 3 creadas
     List<Moneda> monedas = mon.listar();
     for (Moneda moneda : monedas) {
         System.out.println(moneda.getNomenclatura() + " - " + moneda.getNombre() + " - " + moneda.getValorDolar());
     }
     //Actualizo BTC y le cambio el valor,  funciona por nomenclatura
     mon.actualizar(new Moneda("C", "Bitcoin", "BTC", 3000.00, 20.00));
    //Listo de vuelta las monedas para efectuar el cambio
     List<Moneda> monedas2 = mon.listar();
     for (Moneda moneda : monedas2) {
    	 System.out.println(moneda.getNomenclatura() + " - " + moneda.getNombre() + " - " + moneda.getValorDolar());
     }
         
     //cierro la conexion
     ConexionBD.closeConnection();
	}
}
