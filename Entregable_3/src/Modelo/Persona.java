package Modelo;

public class Persona {
    private int ID;
    private String nombres;
    private String apellidos;
    
    public Persona() {			//para PersonaDAOImpl
    		
    }

    public Persona(int ID, String nombres, String apellidos) {
        super();
        this.ID = ID;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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