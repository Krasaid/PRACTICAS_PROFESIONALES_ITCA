/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELS;

import java.sql.Date;
/**
 *
 * @author Krasaid
 */
public class Propuesta {
    
   
    private int id;
    private int idAlumno;
    private String empresa;
    private int horas;
    private String estado; // 'En revisión', 'Aprobado', 'Rechazado'
    private String motivoRechazo;
    private Date fechaEnvio;

    public Propuesta() {
    }

    public Propuesta(int id, int idAlumno, String empresa, int horas, String estado, String motivoRechazo, Date fechaEnvio) {
        this.id = id;
        this.idAlumno = idAlumno;
        this.empresa = empresa;
        this.horas = horas;
        this.estado = estado;
        this.motivoRechazo = motivoRechazo;
        this.fechaEnvio = fechaEnvio;
    }

    // --- Getters y Setters ---
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivoRechazo() {
        return motivoRechazo;
    }

    public void setMotivoRechazo(String motivoRechazo) {
        this.motivoRechazo = motivoRechazo;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
}
