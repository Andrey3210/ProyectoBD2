package pe.proyecto.voluntariado.service;

import pe.proyecto.voluntariado.model.Actividad;
import java.util.List;

public interface ActividadService {
    List<Actividad> listarTodos() throws Exception;
    Actividad buscarPorId(int id) throws Exception;
    void insertar(Actividad actividad) throws Exception;
    void modificar(Actividad actividad) throws Exception;
    List<Actividad> buscar(String texto) throws Exception;
}