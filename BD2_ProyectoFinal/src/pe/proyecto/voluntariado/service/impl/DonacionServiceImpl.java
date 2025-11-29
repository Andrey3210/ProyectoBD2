package pe.proyecto.voluntariado.service.impl;

import pe.proyecto.voluntariado.dao.DonacionDAO;
import pe.proyecto.voluntariado.dao.impl.DonacionDAOImpl;
import pe.proyecto.voluntariado.model.Donacion;
import pe.proyecto.voluntariado.service.DonacionService;
import java.util.List;

public class DonacionServiceImpl implements DonacionService {
    private DonacionDAO dao = new DonacionDAOImpl();

    @Override
    public List<Donacion> listarTodos() throws Exception {
        return dao.listarTodos();
    }

    @Override
    public Donacion buscarPorId(int id) throws Exception {
        return dao.buscarPorId(id);
    }

    @Override
    public void insertar(Donacion donacion) throws Exception {
        dao.insertar(donacion);
    }

    @Override
    public void modificar(Donacion donacion) throws Exception {
        dao.modificar(donacion);
    }

    @Override
    public List<Donacion> buscar(String texto) throws Exception {
        return dao.buscar(texto);
    }
}