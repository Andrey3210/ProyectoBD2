package pe.proyecto.voluntariado.service.impl;

import pe.proyecto.voluntariado.dao.OrganizacionDAO;
import pe.proyecto.voluntariado.dao.impl.OrganizacionDAOImpl;
import pe.proyecto.voluntariado.model.Organizacion;
import pe.proyecto.voluntariado.service.OrganizacionService;
import java.util.List;

public class OrganizacionServiceImpl implements OrganizacionService {

    private final OrganizacionDAO dao = new OrganizacionDAOImpl();

    @Override
    public List<Organizacion> listarActivas() throws Exception {
        return dao.listarActivas();
    }

    @Override
    public List<Organizacion> listarInactivas() throws Exception {
        return dao.listarInactivas();
    }

    @Override
    public void desactivarOrganizacion(int organizacionId) throws Exception {
        dao.desactivarOrganizacion(organizacionId);
    }

    @Override
    public void activarOrganizacion(int organizacionId) throws Exception {
        dao.activarOrganizacion(organizacionId);
    }

    @Override
    public void insertar(Organizacion organizacion) throws Exception {
        dao.insertar(organizacion);
    }
    
    @Override
    public void modificar(Organizacion organizacion) throws Exception {  // ← NUEVO
        dao.modificar(organizacion);
    }
}
