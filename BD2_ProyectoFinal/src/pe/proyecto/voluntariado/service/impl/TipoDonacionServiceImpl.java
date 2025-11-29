package pe.proyecto.voluntariado.service.impl;

import pe.proyecto.voluntariado.dao.TipoDonacionDAO;
import pe.proyecto.voluntariado.dao.impl.TipoDonacionDAOImpl;
import pe.proyecto.voluntariado.model.TipoDonacion;
import pe.proyecto.voluntariado.service.TipoDonacionService;
import java.util.List;

public class TipoDonacionServiceImpl implements TipoDonacionService {
    private TipoDonacionDAO dao = new TipoDonacionDAOImpl();

    @Override
    public List<TipoDonacion> listarTodos() throws Exception {
        return dao.listarTodos();
    }

    @Override
    public TipoDonacion buscarPorId(int id) throws Exception {
        return dao.buscarPorId(id);
    }

    @Override
    public void insertar(TipoDonacion tipoDonacion) throws Exception {
        dao.insertar(tipoDonacion);
    }

    @Override
    public void modificar(TipoDonacion tipoDonacion) throws Exception {
        dao.modificar(tipoDonacion);
    }

    @Override
    public List<TipoDonacion> buscar(String texto) throws Exception {
        return dao.buscar(texto);
    }
}