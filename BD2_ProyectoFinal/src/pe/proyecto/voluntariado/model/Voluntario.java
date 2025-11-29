package pe.proyecto.voluntariado.model;

import java.util.Date;

public class Voluntario {

    private Integer id;
    private String dni;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String email;
    private String telefono;
    private String direccion;
    private String estadoCivil;
    private Date fechaRegistro;

    // Constructor vacío
    public Voluntario() {
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    // Método auxiliar para obtener nombre completo
    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }

    // Método auxiliar para calcular edad
    public Integer getEdad() {
        if (fechaNacimiento == null) {
            return null;
        }

        java.util.Calendar nacimiento = java.util.Calendar.getInstance();
        nacimiento.setTime(fechaNacimiento);

        java.util.Calendar hoy = java.util.Calendar.getInstance();

        int edad = hoy.get(java.util.Calendar.YEAR) - nacimiento.get(java.util.Calendar.YEAR);

        if (hoy.get(java.util.Calendar.DAY_OF_YEAR) < nacimiento.get(java.util.Calendar.DAY_OF_YEAR)) {
            edad--;
        }

        return edad;
    }

    @Override
    public String toString() {
        return dni + " - " + nombres + " " + apellidos;
    }
}
