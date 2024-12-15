package Modelo;

import java.util.ArrayList;
import java.util.List;

import Entidad.*;

import DAO.ActivoDAOImpl;
import DAO.MonedaDAOImpl;
import DAO.PersonaDAOImpl;
import Interfaces.ActivoDAO;
import Interfaces.MonedaDAO;
import Interfaces.PersonaDAO;


public class BalanceModelo {
	public String buscarNombre(Usuario user) {
		PersonaDAO personaDAO = new PersonaDAOImpl();
		String nombre = personaDAO.obtener(user.getIDPersona()).getNombres();
		return nombre;
	}
	
	public List<Activo> obtenerActivos(Usuario user){
		ActivoDAO activoDAO = new ActivoDAOImpl();
		List <Activo> activos = activoDAO.listar();
		List <Activo> act = new ArrayList();
		for (Activo activo : activos) {
	   		if(activo.getIDUsuario()==user.getID()) {
	   			//si el activo coincide con el del usuario == el usuario tiene el activo
	   				act.add(activo);
	   			}
	   		}
		return act;
	}

	public String obtenerImagen(Activo activo) {
		MonedaDAO monedaDAO = new MonedaDAOImpl();
		Moneda moneda = monedaDAO.obtener(activo.getIDMoneda());
		String imagen = moneda.getNombreIcono();
		return imagen;
	}

	public String obtenerNombre(Activo activo) {
		MonedaDAO monedaDAO = new MonedaDAOImpl();
		Moneda moneda = monedaDAO.obtener(activo.getIDMoneda());
		String nombre = moneda.getNombre();
		return nombre;
	}

	public double obtenerPrecio(Activo activo) {
		MonedaDAO monedaDAO = new MonedaDAOImpl();
		Moneda moneda = monedaDAO.obtener(activo.getIDMoneda());
		double precio = moneda.getValorDolar() * activo.getCantidad();
		return precio;
	}
}
