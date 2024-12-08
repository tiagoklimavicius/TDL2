package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Interfaces.ActivoDAO;
import Modelo.Activo;

public class ActivoDAOImpl implements ActivoDAO {

    @Override
    public void crear(Activo activo) {
        String sql = "INSERT INTO ACTIVO (ID_USUARIO, ID_MONEDA, CANTIDAD) VALUES (?, ?, ?)";
        Connection connection = ConexionBD.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // Configurar los parámetros
            pstmt.setInt(1, activo.getIDUsuario());
            pstmt.setInt(2, activo.getIDMoneda());
            pstmt.setDouble(3, activo.getCantidad());
            
            // Ejecutar la consulta
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int ID = rs.getInt(1);
                activo.setID(ID); // Asignar el ID_PERSONA al objeto usuario
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    public List<Activo> listar() {
        List<Activo> activos = new ArrayList<>();
        String sql = "SELECT * FROM ACTIVO";
        Connection connection = ConexionBD.getConnection();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Activo activo = new Activo();
                activo.setID(rs.getInt("ID"));
                activo.setCantidad(rs.getDouble("CANTIDAD"));
                activo.setIDUsuario(rs.getInt("ID_USUARIO"));
                activo.setIDMoneda(rs.getInt("ID_MONEDA"));
                activos.add(activo);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return activos;
    }

    @Override
    public void actualizar(Activo activo) {
        String sql = "UPDATE ACTIVO SET CANTIDAD = ?, ID_USUARIO = ?, ID_MONEDA = ? WHERE ID = ?";
        Connection connection = ConexionBD.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, activo.getCantidad());
            pstmt.setInt(2, activo.getIDUsuario());
            pstmt.setInt(3, activo.getIDMoneda());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Activo obtener(int ID) {
        String sql = "SELECT * FROM ACTIVO WHERE ID = ?";
        Connection connection = ConexionBD.getConnection();
        Activo activo = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, ID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    activo = new Activo();
                    activo.setID(rs.getInt("ID"));
                    activo.setCantidad(rs.getDouble("CANTIDAD"));
                    activo.setIDUsuario(rs.getInt("ID_USUARIO"));
                    activo.setIDMoneda(rs.getInt("ID_MONEDA"));
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return activo;
    }
}