package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controlador.LoginControlador.IniciarListener;
import Modelo.LoginModelo;
import Modelo.RegistroModelo;
import Vista.LoginVista;
import Vista.RegistroVista;

public class RegistroControlador {
	private RegistroModelo modelo;
	private RegistroVista vista;
	private LoginModelo modeloLog;
	private LoginVista vistaLog;
	
	public RegistroControlador(RegistroModelo modelo, RegistroVista vista) {
		this.modelo=modelo;
		this.vista=vista;
				
		vistaLog = new LoginVista();
		modeloLog = new LoginModelo();
	//	
		
		
		//asignar el controlador al boton de confirmar
		this.vista.getBtnConfirmar().addActionListener(new ConfirmarListener());
		
	}
	
	
	
	//clase interna que implementa la accion de iniciar sesion
	class ConfirmarListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				String nombre = vista.getNombre();
				String apellido = vista.getApellido();
				String email = vista.getEmail();
				String contraseña = vista.getContraseña();
				String contraseña2 = vista.getContraseña2();
				
				
				if (email.isEmpty() || contraseña.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || contraseña2.isEmpty()) {
	                throw new IllegalArgumentException("Ningún campo puede estar vacío.");
	            }
				
				if(!vista.isChckbxTyCSelected()) {
					throw new IllegalStateException("Debe aceptar los terminos y condiciones para continuar.");
				}
				
				if(!contraseña.equals(contraseña2)) {
					throw new IllegalArgumentException("Las contraseñas no coinciden.");
				}
				
				if(modelo.verificarUsuario(email)) {			//Si el usuario no existe continua (DEVUELVE TRUE SI NO EXISTE)
					
					//el usuario no existe procedo a crearlo
					modelo.crearUsuario(nombre,apellido,email,contraseña);
					vista.mostrarMensaje("Usuario creado exitosamente. Por favor inicie sesión.");
					vista.dispose();
					new LoginControlador(modeloLog,vistaLog);
					vistaLog.setVisible(true);
					
					
				}
				else {
					vista.mostrarMensajeError("El email indicado ya está en uso.");
				}
				
			} catch (IllegalArgumentException ex) {
	            vista.mostrarMensajeError(ex.getMessage());
			}	catch (IllegalStateException ex) {
	            vista.mostrarMensajeError(ex.getMessage());
			}
		}
	}
}
