package MAIN;

import java.time.LocalDateTime;
import java.util.Collections;	
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import DAO.*;
import Modelo.*;
import Comparadores.*;

public class Gestor {
	private ActivoDAOImpl activoDAO;
	private MonedaDAOImpl monedaDAO ;
	private TransaccionDAOImpl transaccionDAO;
	private Scanner scanner;
	
	public Gestor() {
		this.monedaDAO = new MonedaDAOImpl();
		this.activoDAO = new ActivoDAOImpl();
		this.transaccionDAO = new TransaccionDAOImpl();
		this.scanner = new Scanner(System.in);
	}
	
	
	public void crearMoneda() {
		System.out.println("Ingrese el tipo de moneda (C para Cripto o F para FIAT):");
        String tipo = scanner.next().toUpperCase();
        while (!tipo.equals("C") && !tipo.equals("F")) {
            System.out.println("Tipo inválido. Ingrese 'C' para Cripto o 'F' para FIAT:");
            tipo = scanner.next().toUpperCase();
        }
        scanner.nextLine();
        System.out.println("Ingrese el nombre de la moneda:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la nomenclatura de la moneda:");
        String nomenclatura = scanner.next().toUpperCase();
        System.out.println("Ingrese el valor en dólares:");
        double valorDolar = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ingrese volatilidad:");
        double volatilidad = scanner.nextDouble();
        scanner.nextLine();
        Double stock = 0.00;
        if (tipo.equals("F")) {
        	System.out.println("Ingrese stock (puede dejar en blanco si no aplica):");
        	String inStock = scanner.nextLine();
        	if(!inStock.isEmpty()) {
        		stock = Double.valueOf(inStock);
        	}
        }
        else {
        	System.out.println("Ingrese stock:");
        	stock = scanner.nextDouble();
        	scanner.nextLine();
        }
        // Confirmación del usuario
        System.out.println("¿Confirma los datos? (S/N)");
        String confirmacion = scanner.next().toUpperCase();
        if (confirmacion.equals("S")) {
            monedaDAO.crear(new Moneda(tipo, nombre, nomenclatura, valorDolar, volatilidad, stock));
            System.out.println("Moneda creada exitosamente.");
        }
        else {
        	System.out.println("Operacion cancelada.");
        }
    }
	
	public void listarMonedas(boolean ordenarPorNomenclatura) {
	    List<Moneda> monedas = monedaDAO.listar();
	    if (ordenarPorNomenclatura) {
	        monedas.sort(new MonedaComparatorPorNomenclatura());
	    } else {
	        Collections.sort(monedas); // Usa compareTo de Moneda
	    }
	    for (Moneda moneda : monedas) {
	        System.out.println(moneda.toString());
	    }
	}

	
	public void generarStock() {
		List<Moneda> monedas = monedaDAO.listar(); // Recupera todas las monedas
        Random random = new Random();
        for (Moneda moneda : monedas) {
        	if(moneda.getTipo().equals("C")) {
        		double stockAleatorio = 10 + (500 - 10) * random.nextDouble(); // Genera stock aleatorio
        		moneda.setStock(stockAleatorio); // Asigna el stock aleatorio a la moneda
        		monedaDAO.actualizar(moneda); // Actualiza la moneda en la base de datos
        	}
        }
        System.out.println("Stock generado aleatoriamente");
    }
	
	public void listarStock(boolean ordenarPorNomenclatura) {
	    List<Moneda> monedas = monedaDAO.listar();
	    if (ordenarPorNomenclatura) {
	        monedas.sort(new MonedaComparatorPorNomenclatura());
	    } else {
	        monedas.sort(new MonedaComparatorPorStock());
	    }
	    for (Moneda moneda : monedas) {
	        System.out.println(moneda.getNombre() + ": " + moneda.getStock());
	    }
	}

	
	public void generarActivo() {
		System.out.println("Ingrese cantidad:");
		double cantidad = scanner.nextDouble();
		System.out.println("Ingrese nomenclatura: ");
		String nomenclatura = scanner.next().toUpperCase();
		
		if (activoDAO.obtener(nomenclatura) == null) {
            System.out.println("Error: La nomenclatura ingresada no existe.");
            return;
        }
		System.out.println("¿Confirma los datos? (S/N)");
        String confirmacion = scanner.next().toUpperCase();
        if (confirmacion.equals("S")) {
        	activoDAO.crear(new Activo(nomenclatura, cantidad));
        	System.out.println("Activo creado exitosamente.");
        }
        else {
        	System.out.println("Operacion cancelada.");
        }
	}
	
	public void listarActivos(boolean ordenarPorNomenclatura) {
	    List<Activo> activos = activoDAO.listar();
	    if (ordenarPorNomenclatura) {
	        activos.sort(new ActivoComparatorPorNomenclatura());
	    } else {
	        Collections.sort(activos); // Usa compareTo de Activo
	    }
	    for (Activo activo : activos) {
	        System.out.println(activo.getNomenclatura() + ": " + activo.getCantidad());
	    }
	}
	
	public void simularCompra() {
		System.out.println("||     COMPRA DE CRIPTOMONEDA     ||");
		System.out.println("Ingrese nomenclatura de la criptomoneda a comprar: ");
		String nomenclaturaC = scanner.next().toUpperCase();
		System.out.println("Ingrese nomenclatura de la moneda FIAT: ");
		String nomenclaturaF = scanner.next().toUpperCase();
		System.out.println("Ingrese cantidad a comprar de la moneda FIAT: ");
		double cantidad = scanner.nextDouble();
		//primero pregunto si existe la moneda y la almaceno en la variable cripto
		Moneda cripto = monedaDAO.obtener(nomenclaturaC);
		Moneda fiat = monedaDAO.obtener(nomenclaturaF);
		if(cripto != null && fiat != null) {				//si tanto la cripto como la fiat existen comienzo a ejecutar
			
			//calculo la cantidad de la criptomoneda que voy a necesitar
			
			double equivalente = (fiat.getValorDolar() * cantidad) / cripto.getValorDolar();  //multiplico la cantidad de fiat que tengo por su valor en dolar y divido por el precio de la cripto
			
			Activo actF = activoDAO.obtener(nomenclaturaF);   //obtengo el activo de la fiat a utilizar.
			
			if(actF != null){			//chequeo que el activo exista
			
				if(actF.getCantidad() >= cantidad) {			//si la cantidad del activo fiat es mayor o igual a la cantidad a comprar continuo.
				
					//ahora con el equivalente consulto si el stock de la cripto a comprar supera o es igual a lo que quiero comprar
				
					if(cripto.getStock() >= equivalente) {
				
						//para este momento el stock es suficiente para poder efectuar la compra
						//primero reviso si la criptomoneda ya es un activo para asi variar sus valores
				
						System.out.println("Hay stock suficiente para realizar la compra.");
						System.out.println("¿Confirma la operación? (S/N)");
						String confirmacion = scanner.next().toUpperCase();
						if (confirmacion.equals("S")) {
		        	
							Activo actC = activoDAO.obtener(nomenclaturaC);
							if( actC == null) {   
					
								//dentro de este if es que el activo no existe por lo tanto lo vamos a crear.
								activoDAO.crear(new Activo(nomenclaturaC, equivalente));             //creo el activo con la nomenclatura indicada y como cantidad el equivalente
								cripto.setStock(cripto.getStock() - equivalente);					//actualizo el stock de la cripto
								monedaDAO.actualizar(cripto);										//actualizo el valor en la tabla
								actF.setCantidad(actF.getCantidad() - cantidad);					//actualizo la cantidad de fiat 
								activoDAO.actualizar(actF);											//actualizo en la tabla de activos
											
							}
							else {			//si el activo existe
								actC.setCantidad(actC.getCantidad() + equivalente);				//Incremendo la cantidad del activo
								activoDAO.actualizar(actC);										//actualizo en la tabla los datos del activo
								cripto.setStock(cripto.getStock() - equivalente);					//actualizo el stock de la cripto
								monedaDAO.actualizar(cripto);										//actualizo el valor en la tabla
								actF.setCantidad(actF.getCantidad() - cantidad);					//actualizo la cantidad de fiat 
								activoDAO.actualizar(actF);											//actualizo en la tabla de activos
							}
							
							String resumen = "Operacion: Compra - Moneda origen: "+ nomenclaturaF +" - Moneda destino: "+ nomenclaturaC+" - Cantidad: "+cantidad;
							transaccionDAO.crear(new Transaccion(resumen, LocalDateTime.now()));				//Creo la transaccion en la DB
		        	
							System.out.println("Operación realizada efectivamente.");
						}
						else {
							System.out.println("Operación cancelada.");
						}
					}
					else {
						System.out.println("Ocurrió un error. No hay suficiente stock.");
					}
				}
				else {
					System.out.println("Ocurrió un error. La cantidad de FIAT ingresado no es suficiente.");
				}
			}
			else {
				System.out.println("Ocurrió un error. No posee la moneda FIAT indicada.");
			}
			
		}
		else {
			System.out.println("Ocurrió un error. Revise las monedas ingresadas.");
		}	
	}	
}

	