package pe.proyecto.voluntariado.dao.impl;

import pe.proyecto.voluntariado.config.ConexionBD;
import pe.proyecto.voluntariado.model.Actividad;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import pe.proyecto.voluntariado.dao.ActividadDAO;

public class ActividadDAOImpl implements ActividadDAO {
    
    @Override
    public List<Actividad> listarTodos() throws Exception {
        List<Actividad> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vista_Actividades";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Actividad a = mapearActividad(rs);
                lista.add(a);
            }
        }
        return lista;
    }
    
    @Override
    public Actividad buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM Vista_Actividades WHERE ID = ?";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return mapearActividad(rs);
            }
        }
        return null;
    }
    
    @Override
    public void insertar(Actividad actividad) throws Exception {
        String sql = "{CALL RegistrarActividad(?, ?, ?, ?, ?, ?, ?)}";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             CallableStatement cs = conn.prepareCall(sql)) {
            
            cs.setInt(1, actividad.getOrganizacionId());
            cs.setInt(2, actividad.getCategoriaId());
            cs.setString(3, actividad.getNombre());
            cs.setString(4, actividad.getDescripcion());
            cs.setString(5, actividad.getUbicacion());
            cs.setDate(6, actividad.getFechaInicio() != null ? 
                new java.sql.Date(actividad.getFechaInicio().getTime()) : null);
            cs.setDate(7, actividad.getFechaFin() != null ? 
                new java.sql.Date(actividad.getFechaFin().getTime()) : null);
            
            cs.execute();
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 20040) {
                throw new Exception("La organización no existe.");
            } else if (e.getErrorCode() == 20041) {
                throw new Exception("La categoría no existe.");
            } else if (e.getErrorCode() == 20042) {
                throw new Exception("La fecha de inicio no puede ser posterior a la fecha de fin.");
            } else {
                throw new Exception("Error al registrar la actividad: " + e.getMessage());
            }
        }
    }
    
    @Override
    public void modificar(Actividad actividad) throws Exception {
        String sql = "{CALL ModificarActividad(?, ?, ?, ?, ?, ?, ?, ?)}";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             CallableStatement cs = conn.prepareCall(sql)) {
            
            cs.setInt(1, actividad.getId());
            cs.setInt(2, actividad.getOrganizacionId());
            cs.setInt(3, actividad.getCategoriaId());
            cs.setString(4, actividad.getNombre());
            cs.setString(5, actividad.getDescripcion());
            cs.setString(6, actividad.getUbicacion());
            cs.setDate(7, actividad.getFechaInicio() != null ? 
                new java.sql.Date(actividad.getFechaInicio().getTime()) : null);
            cs.setDate(8, actividad.getFechaFin() != null ? 
                new java.sql.Date(actividad.getFechaFin().getTime()) : null);
            
            cs.execute();
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 20043) {
                throw new Exception("La actividad no existe.");
            } else if (e.getErrorCode() == 20040) {
                throw new Exception("La organización no existe.");
            } else if (e.getErrorCode() == 20041) {
                throw new Exception("La categoría no existe.");
            } else if (e.getErrorCode() == 20042) {
                throw new Exception("La fecha de inicio no puede ser posterior a la fecha de fin.");
            } else {
                throw new Exception("Error al modificar la actividad: " + e.getMessage());
            }
        }
    }
    
    @Override
    public List<Actividad> buscar(String texto) throws Exception {
        List<Actividad> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vista_Actividades WHERE " +
                     "UPPER(nombre_actividad) LIKE UPPER(?) OR " +
                     "UPPER(nombre_organizacion) LIKE UPPER(?) OR " +
                     "UPPER(nombre_categoria) LIKE UPPER(?) OR " +
                     "UPPER(ubicacion) LIKE UPPER(?) OR " +
                     "UPPER(estado) LIKE UPPER(?)";
        
        String patron = "%" + texto + "%";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            for (int i = 1; i <= 5; i++) {
                ps.setString(i, patron);
            }
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Actividad a = mapearActividad(rs);
                lista.add(a);
            }
        }
        return lista;
    }
    
    private Actividad mapearActividad(ResultSet rs) throws SQLException {
        Actividad a = new Actividad();
        a.setId(rs.getInt("ID"));
        a.setOrganizacionId(rs.getInt("organizacion_id"));
        a.setNombreOrganizacion(rs.getString("nombre_organizacion"));
        a.setCategoriaId(rs.getInt("categoria_id"));
        a.setNombreCategoria(rs.getString("nombre_categoria"));
        a.setNombre(rs.getString("nombre_actividad"));
        a.setDescripcion(rs.getString("descripcion"));
        a.setUbicacion(rs.getString("ubicacion"));
        a.setFechaInicio(rs.getDate("fecha_inicio"));
        a.setFechaFin(rs.getDate("fecha_fin"));
        a.setEstado(rs.getString("estado"));
        return a;
    }
}
