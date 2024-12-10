package Modelo;

import java.util.ArrayList;
import java.util.List;

import DAO.PersonaDAOImpl;
import DAO.TransaccionDAOImpl;
import Entidad.Transaccion;
import Entidad.Usuario;
import Interfaces.PersonaDAO;
import Interfaces.TransaccionDAO;

public class TransaccionModelo {
	public List<String> buscarTransacciones(Usuario user) {
		TransaccionDAO transaccionDAO = new TransaccionDAOImpl();
		List <Transaccion> transacciones = transaccionDAO.listar();
		List <String> transac = new ArrayList();
		for (Transaccion transaccion : transacciones) {
	   		if(transaccion.getIDUsuario()==user.getID()) {
	   			transac.add(transaccion.getFechaHora()+" "+transaccion.getResumen());
	   		}
		}
		return transac;
		
	}
	
	public String buscarNombre(Usuario user) {
		PersonaDAO personaDAO = new PersonaDAOImpl();
		String nombre = personaDAO.obtener(user.getIDPersona()).getNombres();
		return nombre;
	}
}
