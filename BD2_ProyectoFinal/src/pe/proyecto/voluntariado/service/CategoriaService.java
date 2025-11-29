package pe.proyecto.voluntariado.service;

import pe.proyecto.voluntariado.model.Categoria;
import java.util.List;

public interface CategoriaService {
    List<Categoria> listarTodos() throws Exception;
    Categoria buscarPorId(int id) throws Exception;
    void insertar(Categoria categoria) throws Exception;
    void modificar(Categoria categoria) throws Exception;
    List<Categoria> buscar(String texto) throws Exception;
}