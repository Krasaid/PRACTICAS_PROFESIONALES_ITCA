/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import MODELS.Coordinador;
import MODELS.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Krasaid
 */
public class CoordinadorDAO {
     private Connection conexion;

    public CoordinadorDAO() {
        try {
            conexion = ConexionBD.getConexion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Obtener todos los coordinadores
    public List<Coordinador> obtenerCoordinadores() {
        List<Coordinador> lista = new ArrayList<>();
        String sql = "SELECT * FROM coordinadores";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Coordinador c = new Coordinador();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setCorreo(rs.getString("correo"));
                c.setPassword(rs.getString("password"));
                c.setArea(rs.getString("area"));
                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    //Obtener coordinador por ID
    public Coordinador obtenerPorId(int id) {
        Coordinador c = null;
        String sql = "SELECT * FROM coordinadores WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Coordinador();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setCorreo(rs.getString("correo"));
                c.setPassword(rs.getString("password"));
                c.setArea(rs.getString("area"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    //Agregar nuevo coordinador
    public boolean agregar(Coordinador c) {
        String sql = "INSERT INTO coordinadores (nombre, correo, password, area) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getCorreo());
            ps.setString(3, c.getPassword());
            ps.setString(4, c.getArea());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Actualizar coordinador existente
    public boolean actualizar(Coordinador c) {
        String sql = "UPDATE coordinadores SET nombre = ?, correo = ?, password = ?, area = ? WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getCorreo());
            ps.setString(3, c.getPassword());
            ps.setString(4, c.getArea());
            ps.setInt(5, c.getId());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Eliminar coordinador
    public boolean eliminar(int id) {
        String sql = "DELETE FROM coordinadores WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //  Validar login de coordinador 
    public Coordinador validarLogin(String correo, String password) {
        Coordinador c = null;
        String sql = "SELECT * FROM coordinadores WHERE correo = ? AND password = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, correo);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Coordinador();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setCorreo(rs.getString("correo"));
                c.setPassword(rs.getString("password"));
                c.setArea(rs.getString("area"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
}
