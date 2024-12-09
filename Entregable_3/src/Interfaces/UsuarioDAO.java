package Interfaces;

import Entidad.Usuario;

public interface UsuarioDAO extends CRUD<Usuario> {
	Usuario obtener(String email);
}