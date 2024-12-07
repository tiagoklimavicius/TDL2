package Modelo;

public class Activo implements Comparable<Activo> {
    private double cantidad;
    private int ID;
    private int IDMoneda;
    private int IDUsuario;

    public Activo() {                    //para ActivoDAOImpl

    }

    public Activo(double cantidad, int ID, int IDMoneda, int IDUsuario) {         //para el main
        this.cantidad = cantidad;
        this.ID=ID;
        this.IDMoneda=IDMoneda;
        this.IDUsuario=IDUsuario;
    }

    // Getters y setters
    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDMoneda() {
        return IDMoneda;
    }

    public void setIDMoneda(int IDMoneda) {
        this.IDMoneda = IDMoneda;
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    @Override 
    public int compareTo(Activo otroActivo) { 
        return Double.compare(this.cantidad, otroActivo.cantidad); 
    }
}