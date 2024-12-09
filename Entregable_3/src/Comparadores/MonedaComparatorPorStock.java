package Comparadores;

import java.util.Comparator;

import Entidad.Moneda;

public class MonedaComparatorPorStock implements Comparator<Moneda> { 
	@Override 
	public int compare(Moneda m1, Moneda m2) { 
		return Double.compare(m2.getStock(), m1.getStock()); // Orden descendente 
	} 
}