package MAIN;

import Controlador.LoginControlador;
import Modelo.LoginModelo;
import Vista.LoginVista;
import DAO.*;
import Interfaces.*;
import Entidad.*;

public class Main {
	public static void main(String[] args) {	
		
	//	MonedaDAO monedaDAO = new MonedaDAOImpl();
	//	monedaDAO.crear(new Moneda("F", "Pesos Argentinos", "ARS", 0.0009, 0.00, 0, "pesosarg.png"));
	//	monedaDAO.crear(new Moneda("F", "Dolares Estadounidenses", "USD", 1, 0.00, 0, "dolarusa.png"));
				
				
		LoginModelo modeloLog = new LoginModelo();
		LoginVista vistaLog = new LoginVista();
		new LoginControlador(modeloLog, vistaLog);
		
		//Mostrar la vista
		vistaLog.setVisible(true);

	}

}
