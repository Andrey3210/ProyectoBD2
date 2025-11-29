package pe.proyecto.voluntariado.dao.impl;

import pe.proyecto.voluntariado.config.ConexionBD;
import pe.proyecto.voluntariado.dao.DonacionDAO;
import pe.proyecto.voluntariado.model.Donacion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonacionDAOImpl implements DonacionDAO {
    
    @Override
    public List<Donacion> listarTodos() throws Exception {
        List<Donacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vista_Donaciones";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Donacion d = mapearDonacion(rs);
                lista.add(d);
            }
        }
        return lista;
    }
    
    @Override
    public Donacion buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM Vista_Donaciones WHERE ID = ?";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return mapearDonacion(rs);
            }
        }
        return null;
    }
    
    @Override
    public void insertar(Donacion donacion) throws Exception {
        String sql = "{CALL RegistrarDonacion(?, ?, ?, ?, ?)}";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             CallableStatement cs = conn.prepareCall(sql)) {
            
            cs.setInt(1, donacion.getVoluntarioId());
            cs.setInt(2, donacion.getOrganizacionId());
            cs.setInt(3, donacion.getTipoDonacionId());
            
            if (donacion.getCantidad() != null) {
                cs.setDouble(4, donacion.getCantidad());
            } else {
                cs.setNull(4, Types.DECIMAL);
            }
            
            if (donacion.getCalificacion() != null) {
                cs.setInt(5, donacion.getCalificacion());
            } else {
                cs.setNull(5, Types.INTEGER);
            }
            
            cs.execute();
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 20050) {
                throw new Exception("El voluntario no existe.");
            } else if (e.getErrorCode() == 20051) {
                throw new Exception("La organización no existe o no está activa.");
            } else if (e.getErrorCode() == 20052) {
                throw new Exception("El tipo de donación no existe.");
            } else if (e.getErrorCode() == 20053) {
                throw new Exception("La cantidad debe ser mayor a cero.");
            } else if (e.getErrorCode() == 20054) {
                throw new Exception(e.getMessage().substring(e.getMessage().indexOf(":") + 1).trim());
            } else {
                throw new Exception("Error al registrar la donación: " + e.getMessage());
            }
        }
    }
    
    @Override
    public void modificar(Donacion donacion) throws Exception {
        String sql = "{CALL ModificarDonacion(?, ?, ?, ?, ?, ?)}";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             CallableStatement cs = conn.prepareCall(sql)) {
            
            cs.setInt(1, donacion.getId());
            cs.setInt(2, donacion.getVoluntarioId());
            cs.setInt(3, donacion.getOrganizacionId());
            cs.setInt(4, donacion.getTipoDonacionId());
            
            if (donacion.getCantidad() != null) {
                cs.setDouble(5, donacion.getCantidad());
            } else {
                cs.setNull(5, Types.DECIMAL);
            }
            
            if (donacion.getCalificacion() != null) {
                cs.setInt(6, donacion.getCalificacion());
            } else {
                cs.setNull(6, Types.INTEGER);
            }
            
            cs.execute();
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 20055) {
                throw new Exception("La donación no existe.");
            } else if (e.getErrorCode() == 20050) {
                throw new Exception("El voluntario no existe.");
            } else if (e.getErrorCode() == 20051) {
                throw new Exception("La organización no existe o no está activa.");
            } else if (e.getErrorCode() == 20052) {
                throw new Exception("El tipo de donación no existe.");
            } else if (e.getErrorCode() == 20053) {
                throw new Exception("La cantidad debe ser mayor a cero.");
            } else if (e.getErrorCode() == 20054) {
                throw new Exception(e.getMessage().substring(e.getMessage().indexOf(":") + 1).trim());
            } else {
                throw new Exception("Error al modificar la donación: " + e.getMessage());
            }
        }
    }
    
    @Override
    public List<Donacion> buscar(String texto) throws Exception {
        List<Donacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vista_Donaciones WHERE " +
                     "UPPER(nombre_voluntario) LIKE UPPER(?) OR " +
                     "UPPER(nombre_organizacion) LIKE UPPER(?) OR " +
                     "UPPER(tipo_donacion) LIKE UPPER(?)";
        
        String patron = "%" + texto + "%";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, patron);
            ps.setString(2, patron);
            ps.setString(3, patron);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Donacion d = mapearDonacion(rs);
                lista.add(d);
            }
        }
        return lista;
    }
    
    private Donacion mapearDonacion(ResultSet rs) throws SQLException {
        Donacion d = new Donacion();
        d.setId(rs.getInt("ID"));
        d.setVoluntarioId(rs.getInt("voluntario_id"));
        d.setNombreVoluntario(rs.getString("nombre_voluntario"));
        d.setOrganizacionId(rs.getInt("organizacion_id"));
        d.setNombreOrganizacion(rs.getString("nombre_organizacion"));
        d.setTipoDonacionId(rs.getInt("tipo_donacion_id"));
        d.setNombreTipoDonacion(rs.getString("tipo_donacion"));
        
        double cant = rs.getDouble("cantidad");
        if (!rs.wasNull()) {
            d.setCantidad(cant);
        }
        
        d.setFecha(rs.getDate("fecha"));
        
        int cal = rs.getInt("calificacion");
        if (!rs.wasNull()) {
            d.setCalificacion(cal);
        }
        
        return d;
    }
}