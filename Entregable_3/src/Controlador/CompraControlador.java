package Controlador;

import java.util.List;

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

public class CompraControlador {
	private CompraModelo modelo;
	private CompraVista vista;
	private CotizacionesModelo modeloCot;
	private CotizacionesVista vistaCot;
	private Usuario user;
	private Moneda moneda;
	
	public CompraControlador(CompraModelo modelo, CompraVista vista, Usuario user, Moneda moneda) {
		this.modelo=modelo;
		this.vista=vista;
		this.user=user;
		this.moneda=moneda;
		
		modeloCot = new CotizacionesModelo();
		vistaCot = new CotizacionesVista();
		
		
		//cargar las posibles fiat a elegir
		List<String> fiats = modelo.obtenerFiat(user);
		for(String fiat : fiats) {
			this.vista.agregarItem(fiat);
		}
		
		
		
		//BOTON DE CANCELAR LA COMPRA
		this.vista.getBtnCancelar().addActionListener(e -> {
			new CotizacionesControlador(modeloCot, vistaCot, user);
			vistaCot.setVisible(true); //se abre la ventana de cotizaciones
			vista.dispose();			//se cierra la ventana de compra
		});
		
		
		//antes de hacer la compra hay q calcular el btnEquivalente para poder mostrar el monto en pantalla
		
		this.vista.getBtnConfirmar().addActionListener(e -> {
			//ejecutar toda la compra aca
			double monto = this.vista.getCantidad();
			String fiat = this.vista.obtenerItem();
			//  obtener la fiat de la listita de monedas
		//	modelo.comprar(monto, fiat, user,moneda);
			
			
			
			new CotizacionesControlador(modeloCot, vistaCot, user);
			vistaCot.setVisible(true); //se abre la ventana de login
			vista.dispose();			//se cierra la ventana de transacciones
		});
		
		this.vista.getBtnConvertir().addActionListener(e -> {
			
		});
	}	
}