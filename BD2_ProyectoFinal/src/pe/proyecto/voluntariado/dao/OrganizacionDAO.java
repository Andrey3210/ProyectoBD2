package pe.proyecto.voluntariado.dao;

import java.util.List;
import pe.proyecto.voluntariado.model.Organizacion;

public interface OrganizacionDAO {

    // Métodos específicos que tu UI ya está usando
    List<Organizacion> listarActivas() throws Exception;

    List<Organizacion> listarInactivas() throws Exception;

    void desactivarOrganizacion(int organizacionId) throws Exception;

    void activarOrganizacion(int organizacionId) throws Exception;

    void insertar(Organizacion organizacion) throws Exception;

    void modificar(Organizacion organizacion) throws Exception;

    // Método extra por si lo usas en otro lado
    Organizacion buscarPorId(int id) throws Exception;
}
