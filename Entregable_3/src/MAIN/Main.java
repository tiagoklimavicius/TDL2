package MAIN;

import Controlador.LoginControlador;
import Modelo.ConsultarPrecioCripto;
import Modelo.LoginModelo;
import Vista.LoginVista;
import DAO.*;
import Entidad.*;
import Interfaces.*;

public class Main {
	public static void main(String[] args) {	
		
		/*	MonedaDAO monedaDAO = new MonedaDAOImpl();
		
		
		
		monedaDAO.crear(new Moneda("C", "Bitcoin", "BTC", 100000, 0.00, 100, "bitcoin.png"));
		monedaDAO.crear(new Moneda("C", "Ethereum", "ETH", 2500, 0.00, 100, "ethereum.png"));
		monedaDAO.crear(new Moneda("C", "Usdc", "USDC", 1, 0.00, 100, "usdc.png"));
		monedaDAO.crear(new Moneda("C", "Usdt", "USDT", 1, 0.00, 100, "usdt.png"));
		monedaDAO.crear(new Moneda("C", "Dogecoin", "DOGE", 0.003, 0.00, 100, "dogecoin.png"));
		monedaDAO.crear(new Moneda("F", "Pesos Argentinos", "ARS", 0.0009, 0.00, 0, "pesosarg.png"));
		monedaDAO.crear(new Moneda("F", "Dolares Estadounidenses", "USD", 1, 0.00, 0, "dolarusa.png"));		*/
		
		
		
		
				
		ConsultarPrecioCripto consulta = new ConsultarPrecioCripto();
		consulta.start();
		LoginModelo modeloLog = new LoginModelo();
		LoginVista vistaLog = new LoginVista();
		
		new LoginControlador(modeloLog, vistaLog);
		
		//Mostrar la vista
		vistaLog.setVisible(true);

	}

}
