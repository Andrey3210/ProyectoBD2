package pe.proyecto.voluntariado.service.impl;

import pe.proyecto.voluntariado.dao.CategoriaDAO;
import pe.proyecto.voluntariado.dao.impl.CategoriaDAOImpl;
import pe.proyecto.voluntariado.model.Categoria;
import pe.proyecto.voluntariado.service.CategoriaService;
import java.util.List;

public class CategoriaServiceImpl implements CategoriaService {
    private CategoriaDAO dao = new CategoriaDAOImpl();

    @Override
    public List<Categoria> listarTodos() throws Exception {
        return dao.listarTodos();
    }

    @Override
    public Categoria buscarPorId(int id) throws Exception {
        return dao.buscarPorId(id);
    }

    @Override
    public void insertar(Categoria categoria) throws Exception {
        dao.insertar(categoria);
    }

    @Override
    public void modificar(Categoria categoria) throws Exception {
        dao.modificar(categoria);
    }

    @Override
    public List<Categoria> buscar(String texto) throws Exception {
        return dao.buscar(texto);
    }
}