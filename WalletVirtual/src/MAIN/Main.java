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
		try (Connection connection = ConexionBD.getConnection();
		         Statement stmt = connection.createStatement()) {
		        stmt.executeUpdate("DELETE FROM MONEDA");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
   	 MonedaDAO mon = new MonedaDAOImpl();
     // Crear monedas
     mon.crear(new Moneda("C", "Dogecoin", "DOGE", 3000.00, 99.00));
     
     List<Moneda> monedas = mon.listar();
     for (Moneda moneda : monedas) {
         System.out.println(moneda.getNombre() + " - " + moneda.getValorDolar());
     }
   
     // Cerrar la conexión
     ConexionBD.closeConnection();
	}
}
