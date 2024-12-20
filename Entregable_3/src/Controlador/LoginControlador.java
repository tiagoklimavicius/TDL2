package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import Entidad.Usuario;
import Vista.BalanceVista;
import Vista.LoginVista;
import Vista.RegistroVista;
import Modelo.BalanceModelo;
import Modelo.LoginModelo;
import Modelo.RegistroModelo;

public class LoginControlador {
	private LoginVista vista;
	private LoginModelo modelo;
	private RegistroVista vistaReg;
	private RegistroModelo modeloReg;
	private BalanceModelo modeloBal;
	private BalanceVista vistaBal;
	private Usuario user;
	
	public LoginControlador(LoginModelo modelo, LoginVista vista) {
		this.modelo=modelo;
		this.vista=vista;
		
		//Instanciar el controlador de registro para el boton de registrar
		vistaReg = new RegistroVista();
		modeloReg = new RegistroModelo();
							
		
		//Instanciar el controlador de balance para cuando se inicie sesion
		modeloBal = new BalanceModelo();
		vistaBal = new BalanceVista();
		
		//asignar el controlador al boton de ingresar
		this.vista.getBtnIngresar().addActionListener(new IniciarListener());
		
		//asignar el controlador al boton de registrarse
		
		//ACCESO A SECCION REGISTRO
		this.vista.getBtnRegistrarse().addActionListener(e -> {
			new RegistroControlador(modeloReg, vistaReg);
			vistaReg.setVisible(true); //se abre la ventana del registro
			vista.dispose();			//se cierra la ventana de iniciar sesion
		
		});
		
		//BOTON INSTANCIAR MONEDAS
		this.vista.getBtnIniciar().addActionListener(e-> {
			modelo.iniciarMonedas();
			vista.mostrarMensaje("Monedas iniciadas correctamente");
		});
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
				user = modelo.verificarUsuario(email, contraseña);
				if(user!=null) {
					//el usuario existe y la contraseña coincide
					//debe acceder a la aplicacion y pasar a la seccion de balance (NO IMPLEMENTADA TODAVIA)
					vista.mostrarMensaje("Ha iniciado sesión correctamente.");       
					//ACCESO A SECCION BALANCE
					new BalanceControlador(modeloBal,vistaBal,user);		//este new esta aca porque requiere que se haya iniciado sesion primero para poder activarse
					vistaBal.setVisible(true);
					vista.dispose();
					
					
				}
				else {
					vista.mostrarMensajeError("Email o contraseña incorrectos. Intente nuevamente.");
				}
			} catch (IllegalArgumentException ex) {
	            vista.mostrarMensajeError(ex.getMessage());
			}
		}
	}
}

