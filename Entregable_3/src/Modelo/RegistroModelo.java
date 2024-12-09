package Modelo;

import DAO.PersonaDAOImpl;
import DAO.UsuarioDAOImpl;
import Entidad.Persona;
import Entidad.Usuario;
import Interfaces.PersonaDAO;
import Interfaces.UsuarioDAO;

public class RegistroModelo {
	public boolean verificarUsuario(String email) {
		boolean check = false;
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		if(usuarioDAO.obtener(email) == null) {
			check = true;
		}
		return check;
	}
	
	public void crearUsuario(String nombre, String apellido, String email, String contraseña) {
		PersonaDAO personaDAO = new PersonaDAOImpl();
		Persona persona = new Persona(nombre,apellido);
		personaDAO.crear(persona);
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		usuarioDAO.crear(new Usuario(persona.getID(), email, contraseña, true ));
	}
}
