package pe.proyecto.voluntariado.dao.impl;

import pe.proyecto.voluntariado.config.ConexionBD;
import pe.proyecto.voluntariado.dao.AsignacionActividadDAO;
import pe.proyecto.voluntariado.model.AsignacionActividad;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AsignacionActividadDAOImpl implements AsignacionActividadDAO {
    
    @Override
    public List<AsignacionActividad> listarTodos() throws Exception {
        List<AsignacionActividad> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vista_Asignaciones";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                AsignacionActividad aa = mapearAsignacion(rs);
                lista.add(aa);
            }
        }
        return lista;
    }
    
    @Override
    public AsignacionActividad buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM Vista_Asignaciones WHERE ID = ?";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return mapearAsignacion(rs);
            }
        }
        return null;
    }
    
    @Override
    public void insertar(AsignacionActividad asignacion) throws Exception {
        String sql = "{CALL RegistrarAsignacion(?, ?, ?)}";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             CallableStatement cs = conn.prepareCall(sql)) {
            
            cs.setInt(1, asignacion.getVoluntarioId());
            cs.setInt(2, asignacion.getActividadId());
            
            if (asignacion.getCalificacion() != null) {
                cs.setInt(3, asignacion.getCalificacion());
            } else {
                cs.setNull(3, Types.INTEGER);
            }
            
            cs.execute();
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 20060) {
                throw new Exception("El voluntario no existe.");
            } else if (e.getErrorCode() == 20061) {
                throw new Exception("La actividad no existe.");
            } else if (e.getErrorCode() == 20062) {
                throw new Exception("El voluntario ya está asignado a esta actividad.");
            } else if (e.getErrorCode() == 20063) {
                throw new Exception(e.getMessage().substring(e.getMessage().indexOf(":") + 1).trim());
            } else {
                throw new Exception("Error al registrar la asignación: " + e.getMessage());
            }
        }
    }
    
    @Override
    public void modificar(AsignacionActividad asignacion) throws Exception {
        String sql = "{CALL ModificarAsignacion(?, ?, ?, ?, ?)}";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             CallableStatement cs = conn.prepareCall(sql)) {
            
            cs.setInt(1, asignacion.getId());
            cs.setInt(2, asignacion.getVoluntarioId());
            cs.setInt(3, asignacion.getActividadId());
            cs.setString(4, asignacion.getEstado());
            
            if (asignacion.getCalificacion() != null) {
                cs.setInt(5, asignacion.getCalificacion());
            } else {
                cs.setNull(5, Types.INTEGER);
            }
            
            cs.execute();
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 20064) {
                throw new Exception("La asignación no existe.");
            } else if (e.getErrorCode() == 20060) {
                throw new Exception("El voluntario no existe.");
            } else if (e.getErrorCode() == 20061) {
                throw new Exception("La actividad no existe.");
            } else if (e.getErrorCode() == 20062) {
                throw new Exception("El voluntario ya está asignado a esta actividad.");
            } else if (e.getErrorCode() == 20063) {
                throw new Exception(e.getMessage().substring(e.getMessage().indexOf(":") + 1).trim());
            } else {
                throw new Exception("Error al modificar la asignación: " + e.getMessage());
            }
        }
    }
    
    @Override
    public List<AsignacionActividad> buscar(String texto) throws Exception {
        List<AsignacionActividad> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vista_Asignaciones WHERE " +
                     "UPPER(nombre_voluntario) LIKE UPPER(?) OR " +
                     "UPPER(nombre_actividad) LIKE UPPER(?) OR " +
                     "UPPER(estado) LIKE UPPER(?)";
        
        String patron = "%" + texto + "%";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, patron);
            ps.setString(2, patron);
            ps.setString(3, patron);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                AsignacionActividad aa = mapearAsignacion(rs);
                lista.add(aa);
            }
        }
        return lista;
    }
    
    private AsignacionActividad mapearAsignacion(ResultSet rs) throws SQLException {
        AsignacionActividad aa = new AsignacionActividad();
        aa.setId(rs.getInt("ID"));
        aa.setVoluntarioId(rs.getInt("voluntario_id"));
        aa.setNombreVoluntario(rs.getString("nombre_voluntario"));
        aa.setActividadId(rs.getInt("actividad_id"));
        aa.setNombreActividad(rs.getString("nombre_actividad"));
        aa.setFecha(rs.getDate("fecha"));
        aa.setEstado(rs.getString("estado"));
        
        int cal = rs.getInt("calificacion");
        if (!rs.wasNull()) {
            aa.setCalificacion(cal);
        }
        
        int calMax = rs.getInt("calificacion_max");
        if (!rs.wasNull()) {
            aa.setCalificacionMax(calMax);
        }
        
        return aa;
    }
}