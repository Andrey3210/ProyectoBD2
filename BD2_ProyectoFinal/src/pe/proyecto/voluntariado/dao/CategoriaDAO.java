package pe.proyecto.voluntariado.dao;

import pe.proyecto.voluntariado.model.Categoria;
import java.util.List;

public interface CategoriaDAO {
    List<Categoria> listarTodos() throws Exception;
    Categoria buscarPorId(int id) throws Exception;
    void insertar(Categoria categoria) throws Exception;
    void modificar(Categoria categoria) throws Exception;
    List<Categoria> buscar(String texto) throws Exception;
}