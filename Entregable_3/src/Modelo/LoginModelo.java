package Modelo;

import Interfaces.UsuarioDAO;
import DAO.UsuarioDAOImpl;
import Entidad.Usuario;

public class LoginModelo {
	
	public boolean verificarUsuario(String email, String password) {
		boolean check = false;
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		Usuario usuario = usuarioDAO.obtener(email);
		if(usuario !=null) {					
			if(usuario.getPassword().equals(password)) {
			//el usuario existe y coincide la contraseña ---> PUEDE INGRESAR
			check = true;
			}
		}
		return check;
	}
}
