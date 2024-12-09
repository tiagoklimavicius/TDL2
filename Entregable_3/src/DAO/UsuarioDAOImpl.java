package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entidad.Usuario;
import Interfaces.UsuarioDAO;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public void crear(Usuario usuario) {
        String sql = "INSERT INTO USUARIO (ID_PERSONA, EMAIL, PASSWORD, ACEPTA_TERMINOS) VALUES (?, ?, ?, ?)";
        Connection connection = ConexionBD.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, usuario.getIDPersona());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getPassword());
            pstmt.setBoolean(4, usuario.getAceptaTerminos());
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int ID = rs.getInt(1);
                usuario.setID(ID); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO";
        Connection connection = ConexionBD.getConnection();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setID(rs.getInt("ID"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setPassword(rs.getString("PASSWORD"));
                usuario.setAceptaTerminos(rs.getBoolean("ACEPTA_TERMINOS"));
                usuario.setIDPersona(rs.getInt("ID_PERSONA"));             // Asocia la persona
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public void actualizar(Usuario usuario) {
        String sql = "UPDATE USUARIO SET ID_PERSONA = ?, EMAIL = ?, PASSWORD = ?, ACEPTA_TERMINOS = ? WHERE ID = ?";
        Connection connection = ConexionBD.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, usuario.getIDPersona());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getPassword());
            pstmt.setBoolean(4, usuario.getAceptaTerminos());
            pstmt.setInt(5, usuario.getID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario obtener(int ID) {
        String sql = "SELECT * FROM USUARIO WHERE ID = ?";
        Connection connection = ConexionBD.getConnection();
        Usuario usuario = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, ID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setID(rs.getInt("ID"));
                    usuario.setEmail(rs.getString("EMAIL"));
                    usuario.setPassword(rs.getString("PASSWORD"));
                    usuario.setIDPersona(rs.getInt("ID_PERSONA"));
                    usuario.setAceptaTerminos(rs.getBoolean("ACEPTA_TERMINOS"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
    
    @Override
    public Usuario obtener(String email) {
        String sql = "SELECT * FROM USUARIO WHERE EMAIL = ?";
        Connection connection = ConexionBD.getConnection();
        Usuario usuario = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setID(rs.getInt("ID"));
                    usuario.setEmail(rs.getString("EMAIL"));
                    usuario.setPassword(rs.getString("PASSWORD"));
                    usuario.setIDPersona(rs.getInt("ID_PERSONA"));
                    usuario.setAceptaTerminos(rs.getBoolean("ACEPTA_TERMINOS"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}