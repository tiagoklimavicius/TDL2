package Modelo;

import java.time.LocalDateTime;

public class Transaccion {
	private int ID;
    private String resumen;           // string con la data del resumen
    private LocalDateTime fechaHora;
    private int IDUsuario;
    // FECHA
    // Operacion
    // Estado
// Podriamos ver aca de si agregar los atributos que teniamos en el UML o respetar directamente lo que nos dieron ellos en la tabla
    //En mi opinion no porque este modelo de Transaccion es re distinto al nuestro xdd
    
    public Transaccion() {
    	
    }
    
    public Transaccion(int ID, String resumen, LocalDateTime fechaHora, int IDUsuario) {
    	this.ID=ID;
    	this.resumen = resumen;
    	this.fechaHora = fechaHora;
    	this.IDUsuario=IDUsuario;
    }

	// Getters y setters
    
    public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

	public int getIDUsuario() {
		return IDUsuario;
	}

	public void setIDUsuario(int iDUsuario) {
		IDUsuario = iDUsuario;
	}
}
