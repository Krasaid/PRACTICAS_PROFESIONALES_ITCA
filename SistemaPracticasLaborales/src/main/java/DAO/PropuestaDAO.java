/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import MODELS.Propuesta;
import MODELS.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Krasaid
 */
public class PropuestaDAO {
     private Connection con;

    public PropuestaDAO() {
        con = ConexionBD.getConnection();
    }

    //INSERTAR PROPUESTA
    public boolean insertarPropuesta(Propuesta propuesta) {
        String sql = "INSERT INTO propuestas (id_alumno, empresa, horas, estado, motivo_rechazo, fecha_envio) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, propuesta.getIdAlumno());
            ps.setString(2, propuesta.getEmpresa());
            ps.setInt(3, propuesta.getHoras());
            ps.setString(4, propuesta.getEstado());
            ps.setString(5, propuesta.getMotivoRechazo());
            ps.setDate(6, propuesta.getFechaEnvio());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar propuesta: " + e.getMessage());
            return false;
        }
    }

    // LISTAR TODAS LAS PROPUESTAS
    public List<Propuesta> listarPropuestas() {
        List<Propuesta> lista = new ArrayList<>();
        String sql = "SELECT * FROM propuestas";
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Propuesta p = new Propuesta();
                p.setId(rs.getInt("id"));
                p.setIdAlumno(rs.getInt("id_alumno"));
                p.setEmpresa(rs.getString("empresa"));
                p.setHoras(rs.getInt("horas"));
                p.setEstado(rs.getString("estado"));
                p.setMotivoRechazo(rs.getString("motivo_rechazo"));
                p.setFechaEnvio(rs.getDate("fecha_envio"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar propuestas: " + e.getMessage());
        }
        return lista;
    }

    // OBTENER PROPUESTA POR ID
    public Propuesta obtenerPorId(int id) {
        String sql = "SELECT * FROM propuestas WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Propuesta p = new Propuesta();
                p.setId(rs.getInt("id"));
                p.setIdAlumno(rs.getInt("id_alumno"));
                p.setEmpresa(rs.getString("empresa"));
                p.setHoras(rs.getInt("horas"));
                p.setEstado(rs.getString("estado"));
                p.setMotivoRechazo(rs.getString("motivo_rechazo"));
                p.setFechaEnvio(rs.getDate("fecha_envio"));
                return p;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener propuesta: " + e.getMessage());
        }
        return null;
    }

    // ACTUALIZAR ESTADO DE PROPUESTA
    public boolean actualizarEstado(int id, String nuevoEstado, String motivoRechazo) {
        String sql = "UPDATE propuestas SET estado = ?, motivo_rechazo = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nuevoEstado);
            ps.setString(2, motivoRechazo);
            ps.setInt(3, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar estado: " + e.getMessage());
            return false;
        }
    }

    //ELIMINAR PROPUESTA
    public boolean eliminarPropuesta(int id) {
        String sql = "DELETE FROM propuestas WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar propuesta: " + e.getMessage());
            return false;
        }
    }
}
