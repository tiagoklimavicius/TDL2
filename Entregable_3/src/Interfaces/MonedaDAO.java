package Interfaces;

import Entidad.Moneda;

public interface MonedaDAO extends CRUD<Moneda> {
	Moneda obtener(String nomenclatura);

}