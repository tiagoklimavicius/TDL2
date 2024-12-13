package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		
		
		//configurar todo el modelo de la compra utilizando la moneda recibida
		this.vista.setCriptoN(moneda.getNomenclatura());  	//seteo la nomenclatura de la cripto
		this.vista.setCriptoNombre(moneda.getNombre());		//seteo el nombre de la cripto
		this.vista.setPrecio(moneda.getValorDolar());		//DEJARLO ASI O AL MISMO TIEMPO OBTENER EL VALOR ACTUALIZADO CADA 5 SEGUNDOS.
		this.vista.setIconoCripto(moneda.getNombreIcono());
		
		
		
		
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
		
	
			

		
		
		this.vista.getBtnConfirmar().addActionListener(new ConfirmarListener());
		this.vista.getBtnConvertir().addActionListener(new ConvertirListener());
	}	
	
	class ConvertirListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				
				double monto = vista.getCantidad();
				String fiat = vista.obtenerItem();
				
				if (vista.obtenerItem() == null) {
				    throw new IllegalArgumentException("Debe seleccionar una moneda fiat para pagar.");
				}
				double equivalente = modelo.obtenerEquivalente(monto, fiat, moneda);
				vista.setEquivalente(equivalente);
				
			} catch (IllegalArgumentException ex) {
	            vista.mostrarMensajeError(ex.getMessage());
			}
		}
	}
	
	class ConfirmarListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				
				double monto = vista.getCantidad();
				String fiat = vista.obtenerItem();
				
				if (vista.obtenerItem() == null) {
				    throw new IllegalArgumentException("Debe seleccionar una moneda fiat para pagar.");
				}
	
				if( modelo.comprarCripto(monto, fiat, user ,moneda)) {
					vista.mostrarMensaje("La compra fue realizada con éxito.");
					new CotizacionesControlador(modeloCot, vistaCot, user);
					vistaCot.setVisible(true); //se abre la ventana de cotizaciones
					vista.dispose();			//se cierra la ventana de compra
				}
				else {
					vista.mostrarMensajeError("Ocurrió un error en la compra.");
				}
				
			} catch (IllegalArgumentException ex) {
	            vista.mostrarMensajeError(ex.getMessage());
			}
		}
	}
}