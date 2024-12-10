package Modelo;

import DAO.PersonaDAOImpl;
import Entidad.Usuario;
import Interfaces.PersonaDAO;

public class CotizacionesModelo {
	public String buscarNombre(Usuario user) {
		PersonaDAO personaDAO = new PersonaDAOImpl();
		String nombre = personaDAO.obtener(user.getIDPersona()).getNombres();
		return nombre;
	}
}
