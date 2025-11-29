package pe.proyecto.voluntariado.model;

public class Categoria {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer calificacionMax;

    public Categoria() {
    }

    public Categoria(Integer id, String nombre, String descripcion, Integer calificacionMax) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.calificacionMax = calificacionMax;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCalificacionMax() {
        return calificacionMax;
    }

    public void setCalificacionMax(Integer calificacionMax) {
        this.calificacionMax = calificacionMax;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
