package pe.proyecto.voluntariado.dao;

import pe.proyecto.voluntariado.model.Donacion;
import java.util.List;

public interface DonacionDAO {
    List<Donacion> listarTodos() throws Exception;
    Donacion buscarPorId(int id) throws Exception;
    void insertar(Donacion donacion) throws Exception;
    void modificar(Donacion donacion) throws Exception;
    List<Donacion> buscar(String texto) throws Exception;
}