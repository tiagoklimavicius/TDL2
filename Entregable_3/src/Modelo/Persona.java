package Modelo;

public class Persona {
    private int ID;
    private String nombres;
    private String apellidos;

    public Persona(int iD, String nombres, String apellidos) {
        super();
        ID = iD;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

}