package Modelo;

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
}
