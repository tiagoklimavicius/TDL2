package DAO;

import java.sql.*;

public class ConexionBD {
protected static Connection c=null;
    private static final String BD_URL="jdbc:sqlite:walletDB.db";
    
    public static Connection getConnection() {
        try {
            // Verificar si la conexión aún está abierta
            if (c == null || c.isClosed()) {
                c = DriverManager.getConnection(BD_URL);
               // System.out.println("Conexión realizada");
                creaciónDeTablasEnBD(c);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return c;
  }
    
    public static void closeConnection() {
    try {
    if((c!= null) && !(c.isClosed())) {
    c.close();
    System.out.println("Conexion cerrada");
    }
    }
    catch (SQLException e) {
    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    System.exit(0);
    }
    }
    
    private static void creaciónDeTablasEnBD(Connection connection) throws SQLException {
    Statement stmt;
    stmt = connection.createStatement();
    String sql = "CREATE TABLE  IF NOT EXISTS PERSONA "
    		+ "("
    		+ " ID       INTEGER   PRIMARY KEY AUTOINCREMENT NOT NULL , "
    		+ " NOMBRES       VARCHAR(50)    NOT NULL, "
    		+ " APELLIDOS       VARCHAR(50)    NOT NULL "
    		+ ")";
    stmt.executeUpdate(sql);
    sql = "CREATE TABLE  IF NOT EXISTS USUARIO " 
    		+ "(" 
    		+ " ID       INTEGER   PRIMARY KEY AUTOINCREMENT NOT NULL , "
    		+ " ID_PERSONA       INTEGER   NOT NULL, "
    		+ " EMAIL       VARCHAR(50)    NOT NULL, "
    		+ " PASSWORD       VARCHAR(50)    NOT NULL, "
    		+ " ACEPTA_TERMINOS       BOOLEAN    NOT NULL, "
    		+ " FOREIGN KEY(ID_PERSONA) REFERENCES PERSONA(ID)"
    		+ ")";
    stmt.executeUpdate(sql);
    
    sql = "CREATE TABLE  IF NOT EXISTS MONEDA "
    		+ "("
    		+ " ID       INTEGER   PRIMARY KEY AUTOINCREMENT NOT NULL , "
    		+ " TIPO       VARCHAR(1)    NOT NULL, "
    		+ " NOMBRE       VARCHAR(50)    NOT NULL, "
    		+ " NOMENCLATURA VARCHAR(10)  NOT NULL, "
    		+ " VALOR_DOLARREAL     NOT NULL, "
    		+ " VOLATILIDADREAL     NULL, "
    		+ " STOCKREAL     NULL, "
    		+ " NOMBRE_ICONO       VARCHAR(50)    NOT NULL "
    		+ ")";
    stmt.executeUpdate(sql);
    sql = "CREATE TABLE  IF NOT EXISTS ACTIVO"
    		+ "("
    		+ " ID       INTEGER   PRIMARY KEY AUTOINCREMENT NOT NULL , "
    		+ " ID_USUARIO INTEGER    NOT NULL, "
    		+ " ID_MONEDA INTEGER    NOT NULL, "
    		+ " CANTIDAD    NOT NULL, "
    		+ " FOREIGN KEY(ID_USUARIO) REFERENCES USUARIO(ID),"
    		+ " FOREIGN KEY(ID_MONEDA) REFERENCES MONEDA(ID) "
    		+ ")";
    stmt.executeUpdate(sql);
    sql = "CREATE TABLE  IF NOT EXISTS TRANSACCION"
    		+ "("
    		+ " ID     INTEGER   PRIMARY KEY AUTOINCREMENT NOT NULL , "
    		+ " RESUMEN VARCHAR(1000)   NOT NULL, "
    		+ " FECHA_HORADATETIME  NOT NULL "
    		+ " ID_USUARIO INTEGER    NOT NULL, "
    		+ " FOREIGN KEY(ID_USUARIO) REFERENCES USUARIO(ID)"
    		+ ")";
    stmt.executeUpdate(sql);
    
    stmt.close();
    }
}