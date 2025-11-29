package pe.proyecto.voluntariado.dao.impl;

import pe.proyecto.voluntariado.config.ConexionBD;
import pe.proyecto.voluntariado.dao.TipoDonacionDAO;
import pe.proyecto.voluntariado.model.TipoDonacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoDonacionDAOImpl implements TipoDonacionDAO {
    
    @Override
    public List<TipoDonacion> listarTodos() throws Exception {
        List<TipoDonacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Tipo_donacion ORDER BY nombre";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                TipoDonacion td = mapearTipoDonacion(rs);
                lista.add(td);
            }
        }
        return lista;
    }
    
    @Override
    public TipoDonacion buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM Tipo_donacion WHERE tipo_donacion_id = ?";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return mapearTipoDonacion(rs);
            }
        }
        return null;
    }
    
    @Override
    public void insertar(TipoDonacion tipoDonacion) throws Exception {
        String sql = "{CALL RegistrarTipoDonacion(?, ?, ?)}";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             CallableStatement cs = conn.prepareCall(sql)) {
            
            cs.setString(1, tipoDonacion.getNombre());
            cs.setString(2, tipoDonacion.getDescripcion());
            
            if (tipoDonacion.getCalificacionMax() != null) {
                cs.setInt(3, tipoDonacion.getCalificacionMax());
            } else {
                cs.setNull(3, java.sql.Types.INTEGER);
            }
            
            cs.execute();
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 20030) {
                throw new Exception("Ya existe un tipo de donación con este nombre.");
            } else if (e.getErrorCode() == 20031) {
                throw new Exception("La calificación máxima debe estar entre 0 y 100.");
            } else {
                throw new Exception("Error al registrar el tipo de donación: " + e.getMessage());
            }
        }
    }
    
    @Override
    public void modificar(TipoDonacion tipoDonacion) throws Exception {
        String sql = "{CALL ModificarTipoDonacion(?, ?, ?, ?)}";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             CallableStatement cs = conn.prepareCall(sql)) {
            
            cs.setInt(1, tipoDonacion.getId());
            cs.setString(2, tipoDonacion.getNombre());
            cs.setString(3, tipoDonacion.getDescripcion());
            
            if (tipoDonacion.getCalificacionMax() != null) {
                cs.setInt(4, tipoDonacion.getCalificacionMax());
            } else {
                cs.setNull(4, java.sql.Types.INTEGER);
            }
            
            cs.execute();
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 20032) {
                throw new Exception("El tipo de donación no existe.");
            } else if (e.getErrorCode() == 20030) {
                throw new Exception("Ya existe otro tipo de donación con este nombre.");
            } else if (e.getErrorCode() == 20031) {
                throw new Exception("La calificación máxima debe estar entre 0 y 100.");
            } else {
                throw new Exception("Error al modificar el tipo de donación: " + e.getMessage());
            }
        }
    }
    
    @Override
    public List<TipoDonacion> buscar(String texto) throws Exception {
        List<TipoDonacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Tipo_donacion WHERE " +
                     "UPPER(nombre) LIKE UPPER(?) OR " +
                     "UPPER(descripcion) LIKE UPPER(?) " +
                     "ORDER BY nombre";
        
        String patron = "%" + texto + "%";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, patron);
            ps.setString(2, patron);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                TipoDonacion td = mapearTipoDonacion(rs);
                lista.add(td);
            }
        }
        return lista;
    }
    
    private TipoDonacion mapearTipoDonacion(ResultSet rs) throws SQLException {
        TipoDonacion td = new TipoDonacion();
        td.setId(rs.getInt("tipo_donacion_id"));
        td.setNombre(rs.getString("nombre"));
        td.setDescripcion(rs.getString("descripcion"));
        
        int calMax = rs.getInt("calificacion_max");
        if (!rs.wasNull()) {
            td.setCalificacionMax(calMax);
        }
        
        return td;
    }
}