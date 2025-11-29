package pe.proyecto.voluntariado.service.impl;

import pe.proyecto.voluntariado.dao.impl.ActividadDAOImpl;
import pe.proyecto.voluntariado.model.Actividad;
import java.util.List;
import pe.proyecto.voluntariado.dao.ActividadDAO;
import pe.proyecto.voluntariado.service.ActividadService;

public class ActividadServiceImpl implements ActividadService {
    private ActividadDAO dao = new ActividadDAOImpl();

    @Override
    public List<Actividad> listarTodos() throws Exception {
        return dao.listarTodos();
    }

    @Override
    public Actividad buscarPorId(int id) throws Exception {
        return dao.buscarPorId(id);
    }

    @Override
    public void insertar(Actividad actividad) throws Exception {
        dao.insertar(actividad);
    }

    @Override
    public void modificar(Actividad actividad) throws Exception {
        dao.modificar(actividad);
    }

    @Override
    public List<Actividad> buscar(String texto) throws Exception {
        return dao.buscar(texto);
    }
}