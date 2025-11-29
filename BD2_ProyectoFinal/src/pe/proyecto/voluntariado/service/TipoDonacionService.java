package pe.proyecto.voluntariado.service;

import pe.proyecto.voluntariado.model.TipoDonacion;
import java.util.List;

public interface TipoDonacionService {
    List<TipoDonacion> listarTodos() throws Exception;
    TipoDonacion buscarPorId(int id) throws Exception;
    void insertar(TipoDonacion tipoDonacion) throws Exception;
    void modificar(TipoDonacion tipoDonacion) throws Exception;
    List<TipoDonacion> buscar(String texto) throws Exception;
}