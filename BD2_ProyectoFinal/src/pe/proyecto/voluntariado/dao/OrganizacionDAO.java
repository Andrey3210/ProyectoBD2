package pe.proyecto.voluntariado.dao;

import pe.proyecto.voluntariado.model.Organizacion;
import java.util.List;

public interface OrganizacionDAO {
    List<Organizacion> listarActivas() throws Exception;
    List<Organizacion> listarInactivas() throws Exception;
    void desactivarOrganizacion(int organizacionId) throws Exception;
    void activarOrganizacion(int organizacionId) throws Exception;
    void insertar(Organizacion organizacion) throws Exception;
    void modificar(Organizacion organizacion) throws Exception;
}

