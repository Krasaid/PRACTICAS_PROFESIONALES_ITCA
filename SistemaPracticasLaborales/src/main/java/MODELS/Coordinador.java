/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELS;

/**
 *
 * @author Krasaid
 */
public class Coordinador {
                          private int id;
    private String nombre;
    private String correo;
    private String password;
    private String area; // Enum: 'Hardware', 'Software', 'Electrica'
   // 🔹 Constructor vacío (requerido por JavaBeans y JSP)
    public Coordinador() {
    }

    // 🔹 Constructor con parámetros (útil para inserciones rápidas)
    public Coordinador(int id, String nombre, String correo, String password, String area) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.area = area;
    }

    // 🔹 Constructor sin ID (para inserciones automáticas con AUTO_INCREMENT)
    public Coordinador(String nombre, String correo, String password, String area) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.area = area;
    }

    // 🔹 Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    // 🔹 Método auxiliar (opcional)
    @Override
    public String toString() {
        return "Coordinador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
