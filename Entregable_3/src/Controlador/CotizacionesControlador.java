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
		
		
		//setear precios para cada moneda
		double btc =modelo.obtenerMoneda("BTC").getValorDolar();
		double eth =modelo.obtenerMoneda("ETH").getValorDolar();
		double usdc =modelo.obtenerMoneda("USDC").getValorDolar();
		double usdt =modelo.obtenerMoneda("USDT").getValorDolar();
		double doge =modelo.obtenerMoneda("DOGE").getValorDolar();
		vista.setPrecios(btc, eth, usdc, usdt, doge);
		
		
		
		
		
		
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
		
		
		
		//BOTONES DE COMPRA PARA CADA MONEDA
		
		this.vista.getBtnComprarBtc().addActionListener(e -> {
			moneda = modelo.obtenerMoneda("BTC");
			new CompraControlador(modeloCom, vistaCom, user, moneda);				//OBTENGO LA MONEDA BTC Y LLAMO A LA COMPRA
			vistaCom.setVisible(true); //se abre la ventana de compra
			vista.dispose();			//se cierra la ventana de transacciones
		});
		
		this.vista.getBtnComprarEth().addActionListener(e -> {
			moneda = modelo.obtenerMoneda("ETH");
			new CompraControlador(modeloCom, vistaCom, user, moneda);				//OBTENGO LA MONEDA ETH Y LLAMO A LA COMPRA
			vistaCom.setVisible(true); //se abre la ventana de compra
			vista.dispose();			//se cierra la ventana de transacciones
		});
		
		this.vista.getBtnComprarUsdc().addActionListener(e -> {
			moneda = modelo.obtenerMoneda("USDC");
			new CompraControlador(modeloCom, vistaCom, user, moneda);				//OBTENGO LA MONEDA USDC Y LLAMO A LA COMPRA
			vistaCom.setVisible(true); //se abre la ventana de compra
			vista.dispose();			//se cierra la ventana de transacciones
		});
		
		this.vista.getBtnComprarUsdt().addActionListener(e -> {
			moneda = modelo.obtenerMoneda("USDT");
			new CompraControlador(modeloCom, vistaCom, user, moneda);				//OBTENGO LA MONEDA USDT Y LLAMO A LA COMPRA
			vistaCom.setVisible(true); //se abre la ventana de compra
			vista.dispose();			//se cierra la ventana de transacciones
		});
		
		this.vista.getBtnComprarDoge().addActionListener(e -> {
			moneda = modelo.obtenerMoneda("DOGE");
			new CompraControlador(modeloCom, vistaCom, user, moneda);				//OBTENGO LA MONEDA DOGE Y LLAMO A LA COMPRA
			vistaCom.setVisible(true); //se abre la ventana de compra
			vista.dispose();			//se cierra la ventana de transacciones
		});
	}	
}
