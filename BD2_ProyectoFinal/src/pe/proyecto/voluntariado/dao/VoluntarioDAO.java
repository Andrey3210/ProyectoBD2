package pe.proyecto.voluntariado.dao;

import pe.proyecto.voluntariado.model.Voluntario;
import java.util.List;

public interface VoluntarioDAO {
    List<Voluntario> listarTodos() throws Exception;
    Voluntario buscarPorId(int id) throws Exception;
    Voluntario buscarPorDni(String dni) throws Exception;
    void insertar(Voluntario voluntario) throws Exception;
    void modificar(Voluntario voluntario) throws Exception;
    List<Voluntario> buscar(String texto) throws Exception;
}