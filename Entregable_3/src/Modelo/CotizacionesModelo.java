package Modelo;

import java.util.List;
import java.util.Random;

import DAO.MonedaDAOImpl;
import DAO.PersonaDAOImpl;
import Entidad.Moneda;
import Entidad.Usuario;
import Interfaces.MonedaDAO;
import Interfaces.PersonaDAO;

public class CotizacionesModelo {
	public String buscarNombre(Usuario user) {
		PersonaDAO personaDAO = new PersonaDAOImpl();
		String nombre = personaDAO.obtener(user.getIDPersona()).getNombres();
		return nombre;
	}
	
	public Moneda obtenerMoneda(String nomenclatura) {
		MonedaDAO monedaDAO = new MonedaDAOImpl();					//dado que las monedas cargadas van del 1 al 5 siendo 1 btc, 2 eth, 3 usdc, 4 usdt y 5 doge al mandar el id puedo obtener el objeto de la moneda.
		Moneda moneda = monedaDAO.obtener(nomenclatura);
		return moneda;
	}
	
	public void generarStock() {
			MonedaDAO monedaDAO = new MonedaDAOImpl();
			List<Moneda> monedas = monedaDAO.listar(); // Recupera todas las monedas
	        Random random = new Random();
	        for (Moneda moneda : monedas) {
	        	if(moneda.getTipo().equals("C")) {
	        		double stockAleatorio = 10 + (5000 - 10) * random.nextDouble(); // Genera stock aleatorio           
	        		moneda.setStock(moneda.getStock() + stockAleatorio); // Asigna el stock aleatorio a la moneda
	        		monedaDAO.actualizar(moneda); // Actualiza la moneda en la base de datos
	        	}
	        }
	    }
	}
