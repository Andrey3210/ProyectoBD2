package pe.proyecto.voluntariado.dao;

import pe.proyecto.voluntariado.model.Actividad;
import java.util.List;

public interface ActividadDAO {
    List<Actividad> listarTodos() throws Exception;
    Actividad buscarPorId(int id) throws Exception;
    void insertar(Actividad actividad) throws Exception;
    void modificar(Actividad actividad) throws Exception;
    List<Actividad> buscar(String texto) throws Exception;
}