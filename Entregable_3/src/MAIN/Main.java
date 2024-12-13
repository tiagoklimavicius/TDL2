package MAIN;

import Controlador.LoginControlador;
import Modelo.LoginModelo;
import Vista.LoginVista;

public class Main {

	public static void main(String[] args) {	
		LoginModelo modeloLog = new LoginModelo();
		LoginVista vistaLog = new LoginVista();
		new LoginControlador(modeloLog, vistaLog);
		
		//Mostrar la vista
		vistaLog.setVisible(true);

	}

}
