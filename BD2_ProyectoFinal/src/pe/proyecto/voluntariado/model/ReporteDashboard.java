package pe.proyecto.voluntariado.model;

public class ReporteDashboard {

    private String organizacion;
    private int totalTransacciones;
    private double totalRecaudado;
    private double satisfaccionPromedio;

    // Getters y Setters
    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public int getTotalTransacciones() {
        return totalTransacciones;
    }

    public void setTotalTransacciones(int totalTransacciones) {
        this.totalTransacciones = totalTransacciones;
    }

    public double getTotalRecaudado() {
        return totalRecaudado;
    }

    public void setTotalRecaudado(double totalRecaudado) {
        this.totalRecaudado = totalRecaudado;
    }

    public double getSatisfaccionPromedio() {
        return satisfaccionPromedio;
    }

    public void setSatisfaccionPromedio(double satisfaccionPromedio) {
        this.satisfaccionPromedio = satisfaccionPromedio;
    }
}
