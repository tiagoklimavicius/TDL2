package Modelo;

import java.util.ArrayList;
import java.util.List;

import DAO.ActivoDAOImpl;
import DAO.MonedaDAOImpl;
import DAO.PersonaDAOImpl;
import Entidad.Activo;
import Entidad.Moneda;
import Entidad.Usuario;
import Interfaces.ActivoDAO;
import Interfaces.MonedaDAO;
import Interfaces.PersonaDAO;

public class FondosModelo {
	public List<String> obtenerFiat(){
		MonedaDAO monedaDAO = new MonedaDAOImpl();
		List <Moneda> monedas = monedaDAO.listar();
		List <String> mon = new ArrayList();
		for (Moneda moneda : monedas) {
	   		if(moneda.getTipo().equals("F")) {
	   			//si la moneda almacenada en el sistema es de tipo FIAT
	   				mon.add(moneda.getNomenclatura());
	   			}
	   		}
		return mon;
	}	
	
	public boolean comprarFiat(double monto, String fiat, Usuario user) {
		boolean check = false;
		//verificar si el usuario posee el activo
		//busco el ID de la moneda con la nomenclatura de parametro y con eso utilizo tanto IDMoneda como IDUsuario para buscar el activo
		MonedaDAO monedaDAO = new MonedaDAOImpl();
		Moneda moneda = monedaDAO.obtener(fiat);
		ActivoDAO activoDAO = new ActivoDAOImpl();
		Activo activoF = activoDAO.obtenerPorUsuarioYMoneda(user.getID(), moneda.getID());
		if(activoF == null) {
			//si el activo fiat es null significa que el usuario aun no posee el activo, por lo que debo crearlo
			activoDAO.crear(new Activo(monto, moneda.getID(), user.getID()));
			//ya se creo el activo con el valor seleccionado para ingresar.
			check = true;
		}
		else {
			//significa que el usuario ya posee el activo, solo resta actualizarlo
			activoF.setCantidad(activoF.getCantidad() + monto);
			activoDAO.actualizar(activoF);
			//ya con esto se actualiza el monto en la base de datos para el usuario
			check = true;
		}
		
		//todavia no encuentro que error puede haber en este caso como para que el metodo devuelta un false, se supone que todas las condiciones ya fueron analizadas, a menos que pase algo externo.
		
		return check;
	}
	
	public String buscarNombre(Usuario user) {
		PersonaDAO personaDAO = new PersonaDAOImpl();
		String nombre = personaDAO.obtener(user.getIDPersona()).getNombres();
		return nombre;
	}
}
