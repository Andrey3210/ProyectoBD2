package pe.proyecto.voluntariado.service.impl;

import pe.proyecto.voluntariado.dao.AsignacionActividadDAO;
import pe.proyecto.voluntariado.dao.impl.AsignacionActividadDAOImpl;
import pe.proyecto.voluntariado.model.AsignacionActividad;
import pe.proyecto.voluntariado.service.AsignacionActividadService;
import java.util.List;

public class AsignacionActividadServiceImpl implements AsignacionActividadService {
    private AsignacionActividadDAO dao = new AsignacionActividadDAOImpl();

    @Override
    public List<AsignacionActividad> listarTodos() throws Exception {
        return dao.listarTodos();
    }

    @Override
    public AsignacionActividad buscarPorId(int id) throws Exception {
        return dao.buscarPorId(id);
    }

    @Override
    public void insertar(AsignacionActividad asignacion) throws Exception {
        dao.insertar(asignacion);
    }

    @Override
    public void modificar(AsignacionActividad asignacion) throws Exception {
        dao.modificar(asignacion);
    }

    @Override
    public List<AsignacionActividad> buscar(String texto) throws Exception {
        return dao.buscar(texto);
    }
}