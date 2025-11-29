package pe.proyecto.voluntariado.dao.impl;

import pe.proyecto.voluntariado.config.ConexionBD;
import pe.proyecto.voluntariado.dao.CategoriaDAO;
import pe.proyecto.voluntariado.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOImpl implements CategoriaDAO {
    
    @Override
    public List<Categoria> listarTodos() throws Exception {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM Categoria ORDER BY nombre";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Categoria c = mapearCategoria(rs);
                lista.add(c);
            }
        }
        return lista;
    }
    
    @Override
    public Categoria buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM Categoria WHERE categoria_id = ?";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return mapearCategoria(rs);
            }
        }
        return null;
    }
    
    @Override
    public void insertar(Categoria categoria) throws Exception {
        String sql = "{CALL RegistrarCategoria(?, ?, ?)}";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             CallableStatement cs = conn.prepareCall(sql)) {
            
            cs.setString(1, categoria.getNombre());
            cs.setString(2, categoria.getDescripcion());
            
            if (categoria.getCalificacionMax() != null) {
                cs.setInt(3, categoria.getCalificacionMax());
            } else {
                cs.setNull(3, java.sql.Types.INTEGER);
            }
            
            cs.execute();
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 20020) {
                throw new Exception("Ya existe una categoría con este nombre.");
            } else if (e.getErrorCode() == 20021) {
                throw new Exception("La calificación máxima debe estar entre 0 y 100.");
            } else {
                throw new Exception("Error al registrar la categoría: " + e.getMessage());
            }
        }
    }
    
    @Override
    public void modificar(Categoria categoria) throws Exception {
        String sql = "{CALL ModificarCategoria(?, ?, ?, ?)}";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             CallableStatement cs = conn.prepareCall(sql)) {
            
            cs.setInt(1, categoria.getId());
            cs.setString(2, categoria.getNombre());
            cs.setString(3, categoria.getDescripcion());
            
            if (categoria.getCalificacionMax() != null) {
                cs.setInt(4, categoria.getCalificacionMax());
            } else {
                cs.setNull(4, java.sql.Types.INTEGER);
            }
            
            cs.execute();
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 20022) {
                throw new Exception("La categoría no existe.");
            } else if (e.getErrorCode() == 20020) {
                throw new Exception("Ya existe otra categoría con este nombre.");
            } else if (e.getErrorCode() == 20021) {
                throw new Exception("La calificación máxima debe estar entre 0 y 100.");
            } else {
                throw new Exception("Error al modificar la categoría: " + e.getMessage());
            }
        }
    }
    
    @Override
    public List<Categoria> buscar(String texto) throws Exception {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM Categoria WHERE " +
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
                Categoria c = mapearCategoria(rs);
                lista.add(c);
            }
        }
        return lista;
    }
    
    private Categoria mapearCategoria(ResultSet rs) throws SQLException {
        Categoria c = new Categoria();
        c.setId(rs.getInt("categoria_id"));
        c.setNombre(rs.getString("nombre"));
        c.setDescripcion(rs.getString("descripcion"));
        
        int calMax = rs.getInt("calificacion_max");
        if (!rs.wasNull()) {
            c.setCalificacionMax(calMax);
        }
        
        return c;
    }
}