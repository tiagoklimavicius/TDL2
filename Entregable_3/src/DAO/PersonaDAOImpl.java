package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Interfaces.PersonaDAO;
import Modelo.Persona;

public class PersonaDAOImpl implements PersonaDAO {

    @Override
    public void crear(Persona persona) {
        String sql = "INSERT INTO PERSONA (NOMBRES, APELLIDOS) VALUES (?, ?)";
        Connection connection = ConexionBD.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, persona.getNombres());
            pstmt.setString(2, persona.getApellidos());
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int ID = rs.getInt(1);
                persona.setID(ID); // Asignar el ID_PERSONA al objeto usuario
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Persona> listar() {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT * FROM PERSONA";
        Connection connection = ConexionBD.getConnection();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setID(rs.getInt("ID"));
                persona.setNombres(rs.getString("NOMBRES"));
                persona.setApellidos(rs.getString("APELLIDOS"));
                personas.add(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;
    }

    @Override
    public void actualizar(Persona persona) {
        String sql = "UPDATE PERSONA SET NOMBRES = ?, APELLIDOS = ? WHERE ID = ?";
        Connection connection = ConexionBD.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, persona.getNombres());
            pstmt.setString(2, persona.getApellidos());
      //      pstmt.setInt(5, persona.getID());         ?????? para qué
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Persona obtener(int ID) {
        String sql = "SELECT * FROM PERSONA WHERE ID = ?";
        Connection connection = ConexionBD.getConnection();
        Persona persona = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, ID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    persona = new Persona();
                    persona.setID(rs.getInt("ID"));												//aca si agregarlo pq es uno nuevo
                    persona.setNombres(rs.getString("NOMBRES"));
                    persona.setApellidos(rs.getString("APELLIDOS"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persona;
    }
}