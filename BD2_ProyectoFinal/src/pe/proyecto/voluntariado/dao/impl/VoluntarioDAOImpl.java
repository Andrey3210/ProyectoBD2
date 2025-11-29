package pe.proyecto.voluntariado.dao.impl;

import pe.proyecto.voluntariado.config.ConexionBD;
import pe.proyecto.voluntariado.dao.VoluntarioDAO;
import pe.proyecto.voluntariado.model.Voluntario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VoluntarioDAOImpl implements VoluntarioDAO {
    
    @Override
    public List<Voluntario> listarTodos() throws Exception {
        List<Voluntario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Voluntario";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Voluntario v = mapearVoluntario(rs);
                lista.add(v);
            }
        }
        return lista;
    }
    
    @Override
    public Voluntario buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM Voluntario WHERE voluntario_id = ?";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return mapearVoluntario(rs);
            }
        }
        return null;
    }
    
    @Override
    public Voluntario buscarPorDni(String dni) throws Exception {
        String sql = "SELECT * FROM Voluntario WHERE dni = ?";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return mapearVoluntario(rs);
            }
        }
        return null;
    }
    
    @Override
    public void insertar(Voluntario voluntario) throws Exception {
        String sql = "{CALL RegistrarVoluntario(?, ?, ?, ?, ?, ?, ?, ?)}";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             CallableStatement cs = conn.prepareCall(sql)) {
            
            cs.setString(1, voluntario.getDni());
            cs.setString(2, voluntario.getNombres());
            cs.setString(3, voluntario.getApellidos());
            cs.setDate(4, voluntario.getFechaNacimiento() != null ? 
                new java.sql.Date(voluntario.getFechaNacimiento().getTime()) : null);
            cs.setString(5, voluntario.getEmail());
            cs.setString(6, voluntario.getTelefono());
            cs.setString(7, voluntario.getDireccion());
            cs.setString(8, voluntario.getEstadoCivil());
            
            cs.execute();
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 20010) {
                throw new Exception("Ya existe un voluntario con este DNI.");
            } else if (e.getErrorCode() == 20011) {
                throw new Exception("Ya existe un voluntario con este email.");
            } else {
                throw new Exception("Error al registrar el voluntario: " + e.getMessage());
            }
        }
    }
    
    @Override
    public void modificar(Voluntario voluntario) throws Exception {
        String sql = "{CALL ModificarVoluntario(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             CallableStatement cs = conn.prepareCall(sql)) {
            
            cs.setInt(1, voluntario.getId());
            cs.setString(2, voluntario.getDni());
            cs.setString(3, voluntario.getNombres());
            cs.setString(4, voluntario.getApellidos());
            cs.setDate(5, voluntario.getFechaNacimiento() != null ? 
                new java.sql.Date(voluntario.getFechaNacimiento().getTime()) : null);
            cs.setString(6, voluntario.getEmail());
            cs.setString(7, voluntario.getTelefono());
            cs.setString(8, voluntario.getDireccion());
            cs.setString(9, voluntario.getEstadoCivil());
            
            cs.execute();
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 20012) {
                throw new Exception("El voluntario no existe.");
            } else if (e.getErrorCode() == 20010) {
                throw new Exception("Ya existe otro voluntario con este DNI.");
            } else if (e.getErrorCode() == 20011) {
                throw new Exception("Ya existe otro voluntario con este email.");
            } else {
                throw new Exception("Error al modificar el voluntario: " + e.getMessage());
            }
        }
    }
    
    @Override
    public List<Voluntario> buscar(String texto) throws Exception {
        List<Voluntario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Voluntario WHERE " +
                     "UPPER(dni) LIKE UPPER(?) OR " +
                     "UPPER(nombres) LIKE UPPER(?) OR " +
                     "UPPER(apellidos) LIKE UPPER(?) OR " +
                     "UPPER(email) LIKE UPPER(?) OR " +
                     "UPPER(telefono) LIKE UPPER(?) " +
                     "ORDER BY fecha_registro DESC";
        
        String patron = "%" + texto + "%";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, patron);
            ps.setString(2, patron);
            ps.setString(3, patron);
            ps.setString(4, patron);
            ps.setString(5, patron);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Voluntario v = mapearVoluntario(rs);
                lista.add(v);
            }
        }
        return lista;
    }
    
    private Voluntario mapearVoluntario(ResultSet rs) throws SQLException {
        Voluntario v = new Voluntario();
        v.setId(rs.getInt("voluntario_id"));
        v.setDni(rs.getString("dni"));
        v.setNombres(rs.getString("nombres"));
        v.setApellidos(rs.getString("apellidos"));
        v.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
        v.setEmail(rs.getString("email"));
        v.setTelefono(rs.getString("telefono"));
        v.setDireccion(rs.getString("direccion"));
        v.setEstadoCivil(rs.getString("estado_civil"));
        v.setFechaRegistro(rs.getDate("fecha_registro"));
        return v;
    }
}