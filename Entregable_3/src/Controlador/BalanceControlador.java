package Controlador;

import Modelo.BalanceModelo;
import Modelo.CotizacionesModelo;
import Modelo.LoginModelo;
import Vista.BalanceVista;
import Vista.CotizacionesVista;
import Vista.LoginVista;

public class BalanceControlador {
	private BalanceVista vista;
	private BalanceModelo modelo;
	private CotizacionesModelo modeloCot;
	private CotizacionesVista vistaCot;
	private LoginModelo modeloLog;
	private LoginVista vistaLog;
	
	
	public BalanceControlador(BalanceModelo modelo, BalanceVista vista) {
		this.modelo=modelo;
		this.vista=vista;
		
		modeloCot = new CotizacionesModelo();
		vistaCot = new CotizacionesVista();						//todo esto esta instanciado para el boton de cotizaciones
		
		
		modeloLog = new LoginModelo();
		vistaLog = new LoginVista();							//todo esto esta instanciado para el boton de cerrar sesion
		
		
		

		//asignar boton de cerrar sesion
		
		this.vista.getBtnCerrar().addActionListener(e -> {
			new LoginControlador(modeloLog, vistaLog);
			vistaLog.setVisible(true); //se abre la ventana de iniciar sesion
			vista.dispose();			//se cierra la ventana de balances
			
		});
		
		//asignar boton de generar datos de pruebas
		
		//asignar boton de ordenar por cripto
		
		//asignar boton de ordenar por monto
		
		//asignar boton de exportar por csv
		
		//asignar boton de ir a mis operaciones
		
		//asignar boton de ir a cotizaciones
		
		//IR A COTIZACIONES
		this.vista.getBtnCotizaciones().addActionListener(e -> {
			new CotizacionesControlador(modeloCot, vistaCot);
			vistaCot.setVisible(true); //se abre la ventana de cotizaciones
			vista.dispose();			//se cierra la ventana de balances
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*		//asignar el controlador al boton de ingresar
		this.vista.getBtnIngresar().addActionListener(new IniciarListener());
		
		//asignar el controlador al boton de registrarse
		
		//ACCESO A SECCION REGISTRO
		
	}
	
	
	
	//clase interna que implementa la accion de iniciar sesion
	class IniciarListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				String email = vista.getEmail();
				String contraseña = vista.getContraseña();
				
				if (email.isEmpty() || contraseña.isEmpty()) {
	                throw new IllegalArgumentException("Ningún campo puede estar vacío.");
	            }
				
				if(modelo.verificarUsuario(email, contraseña)) {
					//el usuario existe y la contraseña coincide
					//debe acceder a la aplicacion y pasar a la seccion de balance (NO IMPLEMENTADA TODAVIA)
					vista.mostrarMensaje("Ha iniciado sesión correctamente.");       
					vista.dispose();
					
					//ACCESO A SECCION BALANCE
				}
				else {
					vista.mostrarMensajeError("Email o contraseña incorrectos. Intente nuevamente.");
				}
			} catch (IllegalArgumentException ex) {
	            vista.mostrarMensajeError(ex.getMessage());
			}
		} 		*/
	}
}

