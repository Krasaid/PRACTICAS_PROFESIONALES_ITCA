/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODELS.Alumno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import MODELS.ConexionBD;
/**
 *
 * @author Krasaid
 */
public class AlumnoDAO {
     private Connection conn;

    public AlumnoDAO() {
        conn = ConexionBD.getConnection();
    }

    // Crear nuevo alumno
    public boolean agregarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumnos (nombre, carnet, correo, telefono, id_carrera) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getCarnet());
            ps.setString(3, alumno.getCorreo());
            ps.setString(4, alumno.getTelefono());
            ps.setInt(5, alumno.getIdCarrera());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al agregar alumno: " + e.getMessage());
            return false;
        }
    }

    // Obtener todos los alumnos
    public List<Alumno> obtenerAlumnos() {
        List<Alumno> lista = new ArrayList<>();
        String sql = "SELECT * FROM alumnos";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Alumno a = new Alumno();
                a.setIdAlumno(rs.getInt("id_alumno"));
                a.setNombre(rs.getString("nombre"));
                a.setCarnet(rs.getString("carnet"));
                a.setCorreo(rs.getString("correo"));
                a.setTelefono(rs.getString("telefono"));
                a.setIdCarrera(rs.getInt("id_carrera"));
                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener alumnos: " + e.getMessage());
        }
        return lista;
    }

    // Buscar alumno por ID
    public Alumno obtenerAlumnoPorId(int id) {
        Alumno a = null;
        String sql = "SELECT * FROM alumnos WHERE id_alumno = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                a = new Alumno();
                a.setIdAlumno(rs.getInt("id_alumno"));
                a.setNombre(rs.getString("nombre"));
                a.setCarnet(rs.getString("carnet"));
                a.setCorreo(rs.getString("correo"));
                a.setTelefono(rs.getString("telefono"));
                a.setIdCarrera(rs.getInt("id_carrera"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener alumno: " + e.getMessage());
        }
        return a;
    }

    // Actualizar datos de un alumno
    public boolean actualizarAlumno(Alumno alumno) {
        String sql = "UPDATE alumnos SET nombre=?, carnet=?, correo=?, telefono=?, id_carrera=? WHERE id_alumno=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getCarnet());
            ps.setString(3, alumno.getCorreo());
            ps.setString(4, alumno.getTelefono());
            ps.setInt(5, alumno.getIdCarrera());
            ps.setInt(6, alumno.getIdAlumno());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar alumno: " + e.getMessage());
            return false;
        }
    }

    //Eliminar alumno
    public boolean eliminarAlumno(int id) {
        String sql = "DELETE FROM alumnos WHERE id_alumno = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar alumno: " + e.getMessage());
            return false;
        }
    }
}
