package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Interfaces.MonedaDAO;
import Modelo.Moneda;

public class MonedaDAOImpl implements MonedaDAO {

    public void crear(Moneda moneda) {
        String sql = "INSERT INTO MONEDA (TIPO, NOMBRE, NOMENCLATURA, VALOR_DOLAR, VOLATILIDAD, STOCK, NOMBRE_ICONO) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection connection = ConexionBD.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, moneda.getTipo());
            pstmt.setString(2, moneda.getNombre());
            pstmt.setString(3, moneda.getNomenclatura());
            pstmt.setDouble(4, moneda.getValorDolar());
            pstmt.setDouble(5, moneda.getVolatilidad());
            pstmt.setDouble(6, moneda.getStock());
            pstmt.setString(7, moneda.getNombreIcono());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Moneda> listar() {
        List<Moneda> monedas = new ArrayList<>();
        String sql = "SELECT * FROM MONEDA";
        Connection connection = ConexionBD.getConnection();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Moneda moneda = new Moneda();
                moneda.setID(rs.getInt("ID"));
                moneda.setTipo(rs.getString("TIPO"));
                moneda.setNombre(rs.getString("NOMBRE"));
                moneda.setNomenclatura(rs.getString("NOMENCLATURA"));
                moneda.setValorDolar(rs.getDouble("VALOR_DOLAR"));
                moneda.setVolatilidad(rs.getDouble("VOLATILIDAD"));
                moneda.setStock(rs.getDouble("STOCK"));
                moneda.setNombreIcono(rs.getString("NOMBRE_ICONO"));
                monedas.add(moneda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return monedas;
    }

    public void actualizar(Moneda moneda) {
        String sql = "UPDATE MONEDA SET TIPO = ?, NOMBRE = ?, NOMENCLATURA = ?, VALOR_DOLAR = ?, VOLATILIDAD = ?, STOCK = ?, NOMBRE_ICONO = ? WHERE ID = ?";
        Connection connection = ConexionBD.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, moneda.getTipo());
            pstmt.setString(2, moneda.getNombre());
            pstmt.setString(3, moneda.getNomenclatura());
            pstmt.setDouble(4, moneda.getValorDolar());
            pstmt.setDouble(5, moneda.getVolatilidad());
            pstmt.setDouble(6, moneda.getStock());
            pstmt.setString(7, moneda.getNombreIcono());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Moneda obtener(int ID) {
        String sql = "SELECT * FROM MONEDA WHERE ID = ?";
        Connection connection = ConexionBD.getConnection();
        Moneda moneda = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, ID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    moneda = new Moneda();
                    moneda.setID(rs.getInt("ID"));
                    moneda.setTipo(rs.getString("TIPO"));
                    moneda.setNombre(rs.getString("NOMBRE"));
                    moneda.setNomenclatura(rs.getString("NOMENCLATURA"));
                    moneda.setValorDolar(rs.getDouble("VALOR_DOLAR"));
                    moneda.setVolatilidad(rs.getDouble("VOLATILIDAD"));
                    moneda.setStock(rs.getDouble("STOCK"));
                    moneda.setNombreIcono(rs.getString("NOMBRE_ICONO"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return moneda;
    }
}
