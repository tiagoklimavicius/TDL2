package Modelo;

import Interfaces.UsuarioDAO;
import DAO.UsuarioDAOImpl;
import Entidad.Usuario;

public class LoginModelo {
	
	public Usuario verificarUsuario(String email, String password) {
		boolean check = false;
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		Usuario usuario = usuarioDAO.obtener(email);
		if(usuario !=null) {							//si el usuario es distinto de null
			if(!usuario.getPassword().equals(password)) {
			usuario=null;				//si el usuario existe pero la contraseña esta mal devuelvo null
			}
		}
		return usuario;					//en caso de que no tenga problema con el null va a devolver el usuario completo con los datos correctos.
	}
}
