package pe.proyecto.voluntariado.service.impl;

import pe.proyecto.voluntariado.dao.VoluntarioDAO;
import pe.proyecto.voluntariado.dao.impl.VoluntarioDAOImpl;
import pe.proyecto.voluntariado.model.Voluntario;
import pe.proyecto.voluntariado.service.VoluntarioService;
import java.util.List;

public class VoluntarioServiceImpl implements VoluntarioService {
    private VoluntarioDAO dao = new VoluntarioDAOImpl();

    @Override
    public List<Voluntario> listarTodos() throws Exception {
        return dao.listarTodos();
    }

    @Override
    public Voluntario buscarPorId(int id) throws Exception {
        return dao.buscarPorId(id);
    }

    @Override
    public Voluntario buscarPorDni(String dni) throws Exception {
        return dao.buscarPorDni(dni);
    }

    @Override
    public void insertar(Voluntario voluntario) throws Exception {
        dao.insertar(voluntario);
    }

    @Override
    public void modificar(Voluntario voluntario) throws Exception {
        dao.modificar(voluntario);
    }

    @Override
    public List<Voluntario> buscar(String texto) throws Exception {
        return dao.buscar(texto);
    }
}