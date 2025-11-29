package pe.proyecto.voluntariado.dao;

import pe.proyecto.voluntariado.model.AsignacionActividad;
import java.util.List;

public interface AsignacionActividadDAO {
    List<AsignacionActividad> listarTodos() throws Exception;
    AsignacionActividad buscarPorId(int id) throws Exception;
    void insertar(AsignacionActividad asignacion) throws Exception;
    void modificar(AsignacionActividad asignacion) throws Exception;
    List<AsignacionActividad> buscar(String texto) throws Exception;
}