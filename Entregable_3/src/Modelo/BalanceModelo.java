package Modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Entidad.*;

import DAO.ActivoDAOImpl;
import DAO.MonedaDAOImpl;
import DAO.PersonaDAOImpl;
import Interfaces.ActivoDAO;
import Interfaces.MonedaDAO;
import Interfaces.PersonaDAO;


public class BalanceModelo {
	public String buscarNombre(Usuario user) {
		PersonaDAO personaDAO = new PersonaDAOImpl();
		String nombre = personaDAO.obtener(user.getIDPersona()).getNombres();
		return nombre;
	}
	
	public List<Activo> obtenerActivos(Usuario user){
		ActivoDAO activoDAO = new ActivoDAOImpl();
		List <Activo> activos = activoDAO.listar();
		List <Activo> act = new ArrayList();
		for (Activo activo : activos) {
	   		if(activo.getIDUsuario()==user.getID()) {
	   			//si el activo coincide con el del usuario == el usuario tiene el activo
	   				act.add(activo);
	   			}
	   		}
		return act;
	}

	public String obtenerImagen(Activo activo) {
		MonedaDAO monedaDAO = new MonedaDAOImpl();
		Moneda moneda = monedaDAO.obtener(activo.getIDMoneda());
		String imagen = moneda.getNombreIcono();
		return imagen;
	}

	public String obtenerNombre(Activo activo) {
		MonedaDAO monedaDAO = new MonedaDAOImpl();
		Moneda moneda = monedaDAO.obtener(activo.getIDMoneda());
		String nombre = moneda.getNombre();
		return nombre;
	}

	public double obtenerPrecio(Activo activo) {
		MonedaDAO monedaDAO = new MonedaDAOImpl();
		Moneda moneda = monedaDAO.obtener(activo.getIDMoneda());
		double precio = moneda.getValorDolar() * activo.getCantidad();
		return precio;
	}
	
	public boolean exportarCSV(String nombreArchivo, JTable tabla) {
		try (FileWriter fw = new FileWriter(nombreArchivo);
		         BufferedWriter bw = new BufferedWriter(fw)) {
		        
		        // Obtener el modelo de la tabla
		        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		        
		        // Escribir los nombres de las columnas
		        for (int i = 0; i < modelo.getColumnCount(); i++) {
		            bw.write(modelo.getColumnName(i));
		            if (i < modelo.getColumnCount() - 1) {
		                bw.write(","); // Separador de columnas
		            }
		        }
		        bw.newLine(); // Nueva línea después de los encabezados

		        // Escribir las filas
		        for (int i = 0; i < modelo.getRowCount(); i++) {
		            for (int j = 0; j < modelo.getColumnCount(); j++) {
		                Object valor = modelo.getValueAt(i, j);
		                if (valor instanceof ImageIcon) {
		                    bw.write("Imagen"); // Opcional: indicar que es una imagen
		                } else {
		                    bw.write(valor.toString());
		                }
		                if (j < modelo.getColumnCount() - 1) {
		                    bw.write(","); // Separador de columnas
		                }
		            }
		            bw.newLine(); // Nueva línea después de cada fila
		        }

		        return true;
		    } catch (IOException ex) {
		        return false;
		    }
		
	}
}
