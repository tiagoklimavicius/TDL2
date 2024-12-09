package Controlador;

import Entidad.Moneda;
import Entidad.Usuario;
import Modelo.BalanceModelo;
import Modelo.CompraModelo;
import Modelo.CotizacionesModelo;
import Modelo.LoginModelo;
import Vista.BalanceVista;
import Vista.CompraVista;
import Vista.CotizacionesVista;
import Vista.LoginVista;

public class CotizacionesControlador {
	private CotizacionesModelo modelo;
	private CotizacionesVista vista;
	private BalanceModelo modeloBal;
	private BalanceVista vistaBal;
	private LoginModelo modeloLog;
	private LoginVista vistaLog;
	private CompraModelo modeloCom;
	private CompraVista vistaCom;
	private Usuario user;
	private Moneda moneda;
	
	public CotizacionesControlador(CotizacionesModelo modelo, CotizacionesVista vista, Usuario user) {
		this.modelo=modelo;
		this.vista=vista;
		this.user=user;
		
		modeloBal = new BalanceModelo();
		vistaBal = new BalanceVista();									//instanciado por el boton de VOLVER
		
		modeloLog = new LoginModelo();
		vistaLog = new LoginVista();
		
		modeloCom = new CompraModelo();
		vistaCom = new CompraVista();
		
		
		this.vista.getBtnVolver().addActionListener(e -> {
			new BalanceControlador(modeloBal, vistaBal, user);
			vistaBal.setVisible(true); //se abre la ventana de balances
			vista.dispose();			//se cierra la ventana de cotizaciones
		});
		
		//poner nombre de usuario
		this.vista.setNombreUsuario(modelo.buscarNombre(user));
		
		this.vista.getBtnCerrar().addActionListener(e -> {
			new LoginControlador(modeloLog, vistaLog);
			vistaLog.setVisible(true); //se abre la ventana de login
			vista.dispose();			//se cierra la ventana de transacciones
		});
		
		this.vista.getBtnComprarBtc().addActionListener(e -> {
			new CompraControlador(modeloCom, vistaCom, user, moneda);				//AGREGAR LA MONEDA DE ALGUNA FORMA
			vistaCom.setVisible(true); //se abre la ventana de login
			vista.dispose();			//se cierra la ventana de transacciones
		});
	}	
}
