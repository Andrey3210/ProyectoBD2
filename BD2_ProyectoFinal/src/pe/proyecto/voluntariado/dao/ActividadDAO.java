package pe.proyecto.voluntariado.dao;

import java.util.List;

import pe.proyecto.voluntariado.model.Actividad;

public interface ActividadDAO {

    List<Actividad> listarTodos() throws Exception;

    Actividad buscarPorId(int id) throws Exception;

    void insertar(Actividad actividad) throws Exception;

    void modificar(Actividad actividad) throws Exception;

    List<Actividad> buscar(String texto) throws Exception;
}
