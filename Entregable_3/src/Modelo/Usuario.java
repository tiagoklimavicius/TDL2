package Modelo;

public class Usuario {
    private int ID;
    private int ID_persona;
    private String email;
    private String password;
    private boolean aceptaTerminos;

    public Usuario(int iD, int iD_persona, String email, String password, boolean aceptaTerminos) {
        super();
        ID = iD;
        ID_persona = iD_persona;
        this.email = email;
        this.password = password;
        this.aceptaTerminos = aceptaTerminos;
    }

    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public int getID_persona() {
        return ID_persona;
    }
    public void setID_persona(int iD_persona) {
        ID_persona = iD_persona;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isAceptaTerminos() {
        return aceptaTerminos;
    }
    public void setAceptaTerminos(boolean aceptaTerminos) {
        this.aceptaTerminos = aceptaTerminos;
    }



}