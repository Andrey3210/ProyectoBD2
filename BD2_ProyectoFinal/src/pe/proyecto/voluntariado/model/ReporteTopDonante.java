package pe.proyecto.voluntariado.model;

public class ReporteTopDonante {

    private String voluntarioNombre;
    private int nroDonaciones;
    private double totalDonado;

    // Getters y Setters
    public String getVoluntarioNombre() {
        return voluntarioNombre;
    }

    public void setVoluntarioNombre(String voluntarioNombre) {
        this.voluntarioNombre = voluntarioNombre;
    }

    public int getNroDonaciones() {
        return nroDonaciones;
    }

    public void setNroDonaciones(int nroDonaciones) {
        this.nroDonaciones = nroDonaciones;
    }

    public double getTotalDonado() {
        return totalDonado;
    }

    public void setTotalDonado(double totalDonado) {
        this.totalDonado = totalDonado;
    }
}
