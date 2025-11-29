package pe.proyecto.voluntariado.service;

import pe.proyecto.voluntariado.model.Organizacion;
import java.util.List;

public interface OrganizacionService {
    List<Organizacion> listarActivas() throws Exception;
    List<Organizacion> listarInactivas() throws Exception;
    void desactivarOrganizacion(int organizacionId) throws Exception;
    void activarOrganizacion(int organizacionId) throws Exception;
    void insertar(Organizacion organizacion) throws Exception;
    void modificar(Organizacion organizacion) throws Exception;
}
