package Controlador;

import Entidad.Usuario;
import Modelo.BalanceModelo;
import Modelo.CotizacionesModelo;
import Modelo.LoginModelo;
import Modelo.TransaccionModelo;
import Vista.BalanceVista;
import Vista.CotizacionesVista;
import Vista.LoginVista;
import Vista.TransaccionVista;

public class BalanceControlador {
	private BalanceVista vista;
	private BalanceModelo modelo;
	private CotizacionesModelo modeloCot;
	private CotizacionesVista vistaCot;
	private LoginModelo modeloLog;
	private LoginVista vistaLog;
	private TransaccionModelo modeloTran;
	private TransaccionVista vistaTran;
	private Usuario user;
	
	
	public BalanceControlador(BalanceModelo modelo, BalanceVista vista, Usuario user) {
		this.modelo=modelo;
		this.vista=vista;
		this.user=user;
		
		modeloCot = new CotizacionesModelo();
		vistaCot = new CotizacionesVista();						//todo esto esta instanciado para el boton de cotizaciones
		
		
		modeloLog = new LoginModelo();
		vistaLog = new LoginVista();							//todo esto esta instanciado para el boton de cerrar sesion
		
		modeloTran = new TransaccionModelo();
		vistaTran = new TransaccionVista();
		
		

		//asignar boton de cerrar sesion
		
		this.vista.getBtnCerrar().addActionListener(e -> {
			new LoginControlador(modeloLog, vistaLog);
			vistaLog.setVisible(true); //se abre la ventana de iniciar sesion
			vista.dispose();			//se cierra la ventana de balances
			
		});
		
		//asignar boton de generar datos de pruebas							GENERAR STOCK ALETORIO
		
		//asignar boton de ordenar por cripto								SORT ORDER
			
		//asignar boton de ordenar por monto								SORT ORDER
			
		//asignar boton de exportar por csv
		
		//asignar boton de ir a mis operaciones
		
		//IR A OPERACIONES
		this.vista.getBtnTransacciones().addActionListener(e -> {
			new TransaccionControlador(modeloTran, vistaTran,user);
			vistaTran.setVisible(true); //se abre la ventana de operaciones
			vista.dispose();			//se cierra la ventana de balances
		});
		
		//asignar boton de ir a cotizaciones
		
		//IR A COTIZACIONES
		this.vista.getBtnCotizaciones().addActionListener(e -> {
			new CotizacionesControlador(modeloCot, vistaCot,user);
			vistaCot.setVisible(true); //se abre la ventana de cotizaciones
			vista.dispose();			//se cierra la ventana de balances
		});
		
		
		//poner nombre de usuario
		this.vista.setNombreUsuario(modelo.buscarNombre(user));
	}
}

