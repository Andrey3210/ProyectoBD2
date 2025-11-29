package pe.proyecto.voluntariado.model;

import java.util.Date;

public class Donacion {
    private Integer id;
    private Integer voluntarioId;
    private String nombreVoluntario;
    private Integer organizacionId;
    private String nombreOrganizacion;
    private Integer tipoDonacionId;
    private String nombreTipoDonacion;
    private Double cantidad;
    private Date fecha;
    private Integer calificacion;

    public Donacion() {
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoluntarioId() {
        return voluntarioId;
    }

    public void setVoluntarioId(Integer voluntarioId) {
        this.voluntarioId = voluntarioId;
    }

    public String getNombreVoluntario() {
        return nombreVoluntario;
    }

    public void setNombreVoluntario(String nombreVoluntario) {
        this.nombreVoluntario = nombreVoluntario;
    }

    public Integer getOrganizacionId() {
        return organizacionId;
    }

    public void setOrganizacionId(Integer organizacionId) {
        this.organizacionId = organizacionId;
    }

    public String getNombreOrganizacion() {
        return nombreOrganizacion;
    }

    public void setNombreOrganizacion(String nombreOrganizacion) {
        this.nombreOrganizacion = nombreOrganizacion;
    }

    public Integer getTipoDonacionId() {
        return tipoDonacionId;
    }

    public void setTipoDonacionId(Integer tipoDonacionId) {
        this.tipoDonacionId = tipoDonacionId;
    }

    public String getNombreTipoDonacion() {
        return nombreTipoDonacion;
    }

    public void setNombreTipoDonacion(String nombreTipoDonacion) {
        this.nombreTipoDonacion = nombreTipoDonacion;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }
}