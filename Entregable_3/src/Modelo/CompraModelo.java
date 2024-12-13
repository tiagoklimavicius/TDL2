package Modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DAO.*;
import Entidad.*;
import Interfaces.*;

public class CompraModelo {
	public void comprar(Usuario user, Moneda moneda) {      //HACER COMPRA
		
	}
	
	public List<String> obtenerFiat(Usuario user){
		ActivoDAO activoDAO = new ActivoDAOImpl();
		List <Activo> activos = activoDAO.listar();
		List <String> act = new ArrayList();
		MonedaDAO monedaDAO = new MonedaDAOImpl();
		for (Activo activo : activos) {
	   		if(activo.getIDUsuario()==user.getID()) {
	   			//si el activo coincide con el del usuario == el usuario tiene el activo
	   			Moneda moneda = monedaDAO.obtener(activo.getIDMoneda());
	   			if(moneda.getTipo().equals("F")) {
	   				//si la moneda a la que corresponde el activo es una de tipo fiat se agrega a la lista
	   				act.add(moneda.getNombre());
	   			}
	   		}
		}
		return act;
	}
	
	public double obtenerEquivalente (double monto, String fiat, Moneda moneda) {
		MonedaDAO monedaDAO = new MonedaDAOImpl();
		Moneda monedaFiat = monedaDAO.obtener(fiat);
		double equivalente = ( monedaFiat.getValorDolar() * monto ) / moneda.getValorDolar();	//calculo el equivalente utilizando la fiat y el monto seleccionado
		return equivalente;		
	}
	
	public boolean comprarCripto(double monto, String fiat, Usuario user, Moneda moneda) {
		boolean check = false;
		
		//asumo que si ya estoy en esta instancia tanto la cripto como la fiat EXISTEN
		
		double equivalente = obtenerEquivalente(monto, fiat, moneda);
		
		//ya tengo los datos de MONTO - FIAT - CRIPTO - EQUIVALENTE - USUARIO
		
		//necesito el activo de la fiat y el activo de la moneda del usuario. Si no existe lo creo
		
		MonedaDAO monedaDAO = new MonedaDAOImpl();
		Moneda monedaFiat = monedaDAO.obtener(fiat);
		
		//Obtengo la instancia moneda de la moneda fiat (BUSCANDO POR NOMENCLATURA)
		
		ActivoDAO activoDAO = new ActivoDAOImpl();
		Activo activoFiat =  activoDAO.obtenerPorUsuarioYMoneda(user.getID(), monedaFiat.getID());		//LO QUE DEVUELVE ESTO ES EL ACTIVO FIAT QUE POSEE EL USUARIO DE LA MONEDA FIAT SELECCIONADA
		
		
		
		//necesito verificar que estos dos existan, donde no existan el resultado de estos dos es null
		
		if(activoFiat != null) {
			//SI EL USUARIO POSEE EL ACTIVO FIAT CONTINUO (PARA ESTE CASO YA DEBERIA SER OBLIGATORIO QUE LO POSEA IGUALMENTE,YA QUE NO DEBERIA PERMITIRLE USARLO SINO)
			if(activoFiat.getCantidad() <= monto) {
				//SI PASO ESTE IF ES QUE POSEO LA CANTIDAD SUFICIENTE PARA REALIZAR LA COMPRA
				if(moneda.getStock() >= equivalente) {
					//SI PASO ESTE IF POSEO SUFICIENTE CANTIDAD DE LA MONEDA EN LA WALLET PARA REALIZAR LA COMPRA
					
					//en este instante ya poseo cantidad suficiente de moneda fiat y cantidad suficiente de stock para realizar la compra
					//debo chequear si poseo el activo cripto y si es que no lo instancio.
					
					Activo activoCripto = activoDAO.obtenerPorUsuarioYMoneda(user.getID(), moneda.getID());			// ESTO DEVUELVE EL ACTIVO QUE POSEE EL USUARIO DE LA MONEDA CRIPTO A COMPRAR
					if( activoCripto == null) {   
			
						//dentro de este if es que el activo no existe por lo tanto lo vamos a crear.
						activoDAO.crear(new Activo(equivalente, user.getID(), moneda.getID()));             //creo el activo relacionandolo con el usuario y la moneda a comprar
						moneda.setStock(moneda.getStock() - equivalente);									//actualizo el stock de la cripto
						monedaDAO.actualizar(moneda);														//actualizo el valor en la tabla
						activoFiat.setCantidad(activoFiat.getCantidad() - monto);							//actualizo la cantidad de fiat 
						activoDAO.actualizar(activoFiat);													//actualizo en la tabla de activos
						check=true;
									
					}
					else {			//SI ES QUE EL ACTIVO YA EXISTE SOLO RESTA ACTUALIZARLO
						activoCripto.setCantidad(activoCripto.getCantidad() + equivalente);				//Incremendo la cantidad del activo
						activoDAO.actualizar(activoCripto);												//actualizo en la tabla los datos del activo
						moneda.setStock(moneda.getStock() - equivalente);								//actualizo el stock de la cripto
						monedaDAO.actualizar(moneda);													//actualizo el valor en la tabla
						activoFiat.setCantidad(activoFiat.getCantidad() - monto);						//actualizo la cantidad de fiat 
						activoDAO.actualizar(activoFiat);												//actualizo en la tabla de activos
						check=true;
						
						}	
						String resumen = ("COMPRA "+ equivalente+" "+ moneda.getNomenclatura());
						TransaccionDAO transaccionDAO = new TransaccionDAOImpl();
						transaccionDAO.crear(new Transaccion(resumen, LocalDateTime.now(), user.getID()));				//Creo la transaccion en la DB
				}
				//else {} NO HAY STOCK SUFICIENTE PARA REALIZAR LA COMPRA
			}
			//else{} NO HAY CANTIDAD DE FIAT SUFICIENTE PARA LA COMPRA
		}
		//else {} EL USUARIO NO POSEE EL ACTIVO FIAT (NO DEBERIA PASAR)
		return check;
	}
}
