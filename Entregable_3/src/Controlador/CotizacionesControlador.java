package Controlador;

import Modelo.BalanceModelo;
import Modelo.CotizacionesModelo;
import Vista.BalanceVista;
import Vista.CotizacionesVista;

public class CotizacionesControlador {
	private CotizacionesModelo modelo;
	private CotizacionesVista vista;
	private BalanceModelo modeloBal;
	private BalanceVista vistaBal;
	
	public CotizacionesControlador(CotizacionesModelo modelo, CotizacionesVista vista) {
		this.modelo=modelo;
		this.vista=vista;
		
		modeloBal = new BalanceModelo();
		vistaBal = new BalanceVista();									//instanciado por el boton de VOLVER
		
		
		this.vista.getBtnVolver().addActionListener(e -> {
			new BalanceControlador(modeloBal, vistaBal);
			vistaBal.setVisible(true); //se abre la ventana de balances
			vista.dispose();			//se cierra la ventana de cotizaciones
		});
	}
}
