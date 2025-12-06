package pe.proyecto.voluntariado.model;

public class ReporteActividadDTO {

    private String actividad;
    private String categoria;
    private String organizadora;
    private String estado;
    private String fechaInicio;

    // Getters y Setters
    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getOrganizadora() {
        return organizadora;
    }

    public void setOrganizadora(String organizadora) {
        this.organizadora = organizadora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
