package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Entidad.Usuario;
import Modelo.BalanceModelo;
import Modelo.FondosModelo;
import Modelo.LoginModelo;
import Vista.BalanceVista;
import Vista.FondosVista;
import Vista.LoginVista;

public class FondosControlador {
	private FondosModelo modelo;
	private FondosVista vista;
	private BalanceModelo modeloBal;
	private BalanceVista vistaBal;
	private LoginModelo modeloLog;
	private LoginVista vistaLog;
	private Usuario user;
	
	public FondosControlador(FondosModelo modelo, FondosVista vista, Usuario user) {
		this.modelo=modelo;
		this.vista=vista;
		this.user=user;
		
		modeloBal = new BalanceModelo();
		vistaBal= new BalanceVista();
				
		modeloLog = new LoginModelo();
		vistaLog = new LoginVista();
		
		//cargar las posibles fiat a elegir
		List<String> fiats = modelo.obtenerFiat();
		for(String fiat : fiats) {
			this.vista.agregarItem(fiat);
		}
		
		
		
		//BOTON DE CANCELAR LA COMPRA
		this.vista.getBtnCancelar().addActionListener(e -> {
			new BalanceControlador(modeloBal, vistaBal, user);
			vistaBal.setVisible(true); //se abre la ventana de balance
			vista.dispose();			//se cierra la ventana de ingresar fondos
		});
		
		
		this.vista.getBtnConfirmar().addActionListener(new ConfirmarListener());
		
		//poner nombre de usuario
				this.vista.setNombreUsuario(modelo.buscarNombre(user));
				
				this.vista.getBtnCerrar().addActionListener(e -> {
					new LoginControlador(modeloLog, vistaLog);
					vistaLog.setVisible(true); //se abre la ventana de login
					vista.dispose();			//se cierra la ventana de transacciones
				});
	}	
	
	class ConfirmarListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				
				double monto = vista.getCantidad();
				String fiat = vista.obtenerItem();
				
				if (vista.obtenerItem() == null) {
				    throw new IllegalArgumentException("Debe seleccionar una moneda fiat para pagar.");
				}
	
				if( modelo.comprarFiat(monto, fiat, user)) {
					vista.mostrarMensaje("Será rederigido a la aplicación del metodo de pago seleccionado:.");
					vista.mostrarMensaje("Transacción exitosa");
					new BalanceControlador(modeloBal, vistaBal, user);
					vistaBal.setVisible(true); //se abre la ventana de cotizaciones
					vista.dispose();			//se cierra la ventana de compra
				}
				else {
					vista.mostrarMensajeError("Ocurrió un error en la transacción.");
				}
				
			} catch (IllegalArgumentException ex) {
	            vista.mostrarMensajeError(ex.getMessage());
			}
		}
	}
}