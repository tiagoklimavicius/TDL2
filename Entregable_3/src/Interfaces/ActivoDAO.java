package Interfaces;

import Entidad.Activo;

public interface ActivoDAO extends CRUD<Activo> {
	Activo obtenerPorUsuarioYMoneda(int IDUsuario, int IDMoneda);
}
