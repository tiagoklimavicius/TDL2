package Controlador;

import java.util.List;

import Entidad.*;
import Modelo.BalanceModelo;
import Modelo.CotizacionesModelo;
import Modelo.FondosModelo;
import Modelo.LoginModelo;
import Modelo.TransaccionModelo;
import Vista.BalanceVista;
import Vista.CotizacionesVista;
import Vista.FondosVista;
import Vista.LoginVista;
import Vista.TransaccionVista;

public class BalanceControlador {
	private BalanceVista vista;
	private BalanceModelo modelo;
	private CotizacionesModelo modeloCot;
	private CotizacionesVista vistaCot;
	private LoginModelo modeloLog;
	private LoginVista vistaLog;
	private TransaccionModelo modeloTran;
	private TransaccionVista vistaTran;
	private FondosModelo modeloFon;
	private FondosVista vistaFon;
	private Usuario user;
	
	
	public BalanceControlador(BalanceModelo modelo, BalanceVista vista, Usuario user) {
		this.modelo=modelo;
		this.vista=vista;
		this.user=user;
		
		modeloCot = new CotizacionesModelo();
		vistaCot = new CotizacionesVista();						//todo esto esta instanciado para el boton de cotizaciones
		
		
		modeloLog = new LoginModelo();
		vistaLog = new LoginVista();							//todo esto esta instanciado para el boton de cerrar sesion
		
		modeloTran = new TransaccionModelo();
		vistaTran = new TransaccionVista();
		
		modeloFon = new FondosModelo();
		vistaFon = new FondosVista();
		
		
		// Obtener los datos de los activos del usuario.
		List<Activo> activos = modelo.obtenerActivos(user);
		//una vez tengo los activos, para cada uno tengo que agregarlo a la tabla de BALANCE
		for (Activo activo : activos) {
			//para cada uno tengo que obtener su ImageIcon, Nombre y Precio
			String imagen = modelo.obtenerImagen(activo);						//obtengo la ruta de donde esta la imagen
			String nombre = modelo.obtenerNombre(activo);						//obtengo el nombre del activo
			double precio = modelo.obtenerPrecio(activo);						//obtengo el monto que poseo de tal activo
			double redondeado = Math.round(precio * 100000.0) / 100000.0;
			this.vista.llenarTabla(imagen, nombre, redondeado);						//agrego a la tabla este activo
		}
		
		
		//setear el balance
		vista.setBalance(vista.getBalance());
		

		//asignar boton de cerrar sesion
		
		this.vista.getBtnCerrar().addActionListener(e -> {
			new LoginControlador(modeloLog, vistaLog);
			vistaLog.setVisible(true); //se abre la ventana de iniciar sesion
			vista.dispose();			//se cierra la ventana de balances
			
		});
		
		//asignar boton de generar datos de pruebas							GENERAR STOCK ALETORIO
			
		//asignar boton de exportar por csv
		
		this.vista.getBtnExportar().addActionListener(e -> {								//esto exporta los datos a una tabla nombrada con el email del usuario y se almacena en el directorio que esta el proyecto
			if(modelo.exportarCSV("tabla_"+user.getEmail()+".csv", vista.getTabla())) {
				vista.mostrarMensaje("Datos exportados exitosamente a tabla_"+user.getEmail()+".csv");
			}
			else {
				vista.mostrarMensajeError("Error al exportar los datos");
			}
		});
		
		//asignar boton de ir a mis operaciones
		
		//IR A OPERACIONES
		this.vista.getBtnTransacciones().addActionListener(e -> {
			new TransaccionControlador(modeloTran, vistaTran,user);
			vistaTran.setVisible(true); //se abre la ventana de operaciones
			vista.dispose();			//se cierra la ventana de balances
		});
		
		//asignar boton de ir a cotizaciones
		
		//IR A COTIZACIONES
		this.vista.getBtnCotizaciones().addActionListener(e -> {
			new CotizacionesControlador(modeloCot, vistaCot,user);
			vistaCot.setVisible(true); //se abre la ventana de cotizaciones
			vista.dispose();			//se cierra la ventana de balances
		});
		
		
		//asignar boton de ingresar fondos
		this.vista.getBtnFondos().addActionListener(e -> {
			new FondosControlador(modeloFon, vistaFon ,user);
			vistaFon.setVisible(true); //se abre la ventana de ingresar fondos
			vista.dispose();			//se cierra la ventana de balances
		});
		
		//poner nombre de usuario
		this.vista.setNombreUsuario(modelo.buscarNombre(user));
	}
	
	
	
	
}

