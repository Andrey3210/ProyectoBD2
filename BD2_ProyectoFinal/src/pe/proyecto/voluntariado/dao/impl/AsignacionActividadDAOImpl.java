package pe.proyecto.voluntariado.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import pe.proyecto.voluntariado.config.ConexionBD;
import pe.proyecto.voluntariado.dao.AsignacionActividadDAO;
import pe.proyecto.voluntariado.model.AsignacionActividad;

public class AsignacionActividadDAOImpl implements AsignacionActividadDAO {

    @Override
    public List<AsignacionActividad> listarTodos() throws Exception {
        return ejecutarListado();
    }

    @Override
    public List<AsignacionActividad> buscar(String texto) throws Exception {
        // Como no hay filtro específico en BD, devolvemos todos para evitar error
        return ejecutarListado();
    }

    private List<AsignacionActividad> ejecutarListado() throws Exception {
        List<AsignacionActividad> lista = new ArrayList<>();
        String sql = "{call PKG_VOLUNTARIADO.Listar_Asignaciones(?)}";
        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.execute();
            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    lista.add(mapearAsignacion(rs));
                }
            }
        }
        return lista;
    }

    @Override
    public AsignacionActividad buscarPorId(int id) throws Exception {
        AsignacionActividad a = null;
        String sql = "{call PKG_VOLUNTARIADO.Buscar_Asignacion_Por_ID(?, ?)}";
        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, id);
            cs.registerOutParameter(2, Types.REF_CURSOR);
            cs.execute();
            try (ResultSet rs = (ResultSet) cs.getObject(2)) {
                if (rs.next()) {
                    a = mapearAsignacion(rs);
                }
            }
        }
        return a;
    }

    @Override
    public void insertar(AsignacionActividad a) throws Exception {
        String sql = "{call PKG_VOLUNTARIADO.Asignar_Voluntario(?, ?, ?)}";
        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, a.getVoluntarioId());
            cs.setInt(2, a.getActividadId());
            if (a.getCalificacion() > 0) {
                cs.setInt(3, a.getCalificacion()); 
            }else {
                cs.setNull(3, Types.INTEGER);
            }
            cs.execute();
        } catch (SQLException e) {
            if (e.getErrorCode() == 20062) {
                throw new Exception("Error: El voluntario ya está inscrito en esa actividad."); 
            }else {
                throw new Exception("Error al asignar: " + e.getMessage());
            }
        }
    }

    @Override
    public void modificar(AsignacionActividad a) throws Exception {
        String sql = "{call PKG_VOLUNTARIADO.Modificar_Asignacion(?, ?, ?, ?, ?)}";
        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, a.getId());
            cs.setInt(2, a.getVoluntarioId());
            cs.setInt(3, a.getActividadId());
            cs.setString(4, a.getEstado());
            if (a.getCalificacion() > 0) {
                cs.setInt(5, a.getCalificacion()); 
            }else {
                cs.setNull(5, Types.INTEGER);
            }
            cs.execute();
        }
    }

    private AsignacionActividad mapearAsignacion(ResultSet rs) throws SQLException {
        AsignacionActividad a = new AsignacionActividad();
        a.setId(rs.getInt("asignacion_id"));
        a.setFecha(rs.getDate("fecha"));
        a.setEstado(rs.getString("estado"));
        a.setCalificacion(rs.getInt("calificacion"));
        a.setVoluntarioId(rs.getInt("voluntario_id"));
        a.setActividadId(rs.getInt("actividad_id"));
        try {
            a.setNombreVoluntario(rs.getString("nombre_voluntario"));
            a.setNombreActividad(rs.getString("nombre_actividad"));
        } catch (SQLException e) {
        }
        return a;
    }
}
