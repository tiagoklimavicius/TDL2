package Controlador;

import java.util.List;

import Entidad.Usuario;
import Modelo.BalanceModelo;
import Modelo.LoginModelo;
import Modelo.TransaccionModelo;
import Vista.BalanceVista;
import Vista.LoginVista;
import Vista.TransaccionVista;

public class TransaccionControlador {
	private TransaccionModelo modelo;
	private TransaccionVista vista;
	private BalanceModelo modeloBal;
	private BalanceVista vistaBal;
	private LoginModelo modeloLog;
	private LoginVista vistaLog;
	private Usuario user;
	
	public TransaccionControlador(TransaccionModelo modelo, TransaccionVista vista, Usuario user) {
		this.modelo=modelo;
		this.vista=vista;
		this.user=user;
		
		modeloBal = new BalanceModelo();
		vistaBal = new BalanceVista();									//instanciado por el boton de VOLVER
		
		modeloLog = new LoginModelo();
		vistaLog = new LoginVista();
		
		
		//Cargar las transacciones del usuario
		List<String> transacciones =modelo.buscarTransacciones(user);
		for(String transaccion : transacciones) {
			
			vista.agregarTransaccion(transaccion);
		}
		
		
		this.vista.getBtnVolver().addActionListener(e -> {
			new BalanceControlador(modeloBal, vistaBal, user);
			vistaBal.setVisible(true); //se abre la ventana de balances
			vista.dispose();			//se cierra la ventana de transacciones
		});
		
		this.vista.getBtnCerrar().addActionListener(e -> {
			new LoginControlador(modeloLog, vistaLog);
			vistaLog.setVisible(true); //se abre la ventana de login
			vista.dispose();			//se cierra la ventana de transacciones
		});
		
		//poner nombre de usuario
				this.vista.setNombreUsuario(modelo.buscarNombre(user));
	}
}