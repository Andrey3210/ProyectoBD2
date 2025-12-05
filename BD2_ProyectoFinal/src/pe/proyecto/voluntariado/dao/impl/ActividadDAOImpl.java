package pe.proyecto.voluntariado.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import pe.proyecto.voluntariado.config.ConexionBD;
import pe.proyecto.voluntariado.dao.ActividadDAO;
import pe.proyecto.voluntariado.model.Actividad;

public class ActividadDAOImpl implements ActividadDAO {

    @Override
    public List<Actividad> listarTodos() throws Exception {
        return ejecutarConsulta("{call PKG_VOLUNTARIADO.Listar_Actividades(?)}", null);
    }

    @Override
    public List<Actividad> buscar(String texto) throws Exception {
        return ejecutarConsulta("{call PKG_VOLUNTARIADO.Buscar_Actividades_Filtro(?, ?)}", texto);
    }

    // Método auxiliar para no repetir código de conexión en listar y buscar
    private List<Actividad> ejecutarConsulta(String sql, String filtro) throws Exception {
        List<Actividad> lista = new ArrayList<>();
        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {

            if (filtro != null) {
                // Si es búsqueda con filtro
                cs.setString(1, filtro);
                cs.registerOutParameter(2, Types.REF_CURSOR);
                cs.execute();
                try (ResultSet rs = (ResultSet) cs.getObject(2)) {
                    while (rs.next()) {
                        lista.add(mapearActividad(rs));
                    }
                }
            } else {
                // Si es listar todos
                cs.registerOutParameter(1, Types.REF_CURSOR);
                cs.execute();
                try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                    while (rs.next()) {
                        lista.add(mapearActividad(rs));
                    }
                }
            }
        }
        return lista;
    }

    @Override
    public Actividad buscarPorId(int id) throws Exception {
        Actividad a = null;
        String sql = "{call PKG_VOLUNTARIADO.Buscar_Actividad_Por_ID(?, ?)}";
        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, id);
            cs.registerOutParameter(2, Types.REF_CURSOR);
            cs.execute();
            try (ResultSet rs = (ResultSet) cs.getObject(2)) {
                if (rs.next()) {
                    a = mapearActividad(rs);
                }
            }
        }
        return a;
    }

    @Override
    public void insertar(Actividad a) throws Exception {
        String sql = "{call PKG_VOLUNTARIADO.Registrar_Actividad(?, ?, ?, ?, ?, ?, ?)}";
        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, a.getOrganizacionId());
            cs.setInt(2, a.getCategoriaId());
            cs.setString(3, a.getNombre());
            cs.setString(4, a.getDescripcion());
            cs.setString(5, a.getUbicacion());
            cs.setDate(6, a.getFechaInicio() != null ? new java.sql.Date(a.getFechaInicio().getTime()) : null);
            cs.setDate(7, a.getFechaFin() != null ? new java.sql.Date(a.getFechaFin().getTime()) : null);
            cs.execute();
        }
    }

    @Override
    public void modificar(Actividad a) throws Exception {
        String sql = "{call PKG_VOLUNTARIADO.Modificar_Actividad(?, ?, ?, ?, ?, ?, ?, ?)}";
        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, a.getId());
            cs.setInt(2, a.getOrganizacionId());
            cs.setInt(3, a.getCategoriaId());
            cs.setString(4, a.getNombre());
            cs.setString(5, a.getDescripcion());
            cs.setString(6, a.getUbicacion());
            cs.setDate(7, a.getFechaInicio() != null ? new java.sql.Date(a.getFechaInicio().getTime()) : null);
            cs.setDate(8, a.getFechaFin() != null ? new java.sql.Date(a.getFechaFin().getTime()) : null);
            cs.execute();
        }
    }

    private Actividad mapearActividad(ResultSet rs) throws SQLException {
        Actividad a = new Actividad();
        a.setId(rs.getInt("actividad_id"));
        a.setNombre(rs.getString("nombre"));
        a.setDescripcion(rs.getString("descripcion"));
        a.setUbicacion(rs.getString("ubicacion"));
        a.setFechaInicio(rs.getDate("fecha_inicio"));
        a.setFechaFin(rs.getDate("fecha_fin"));
        a.setEstado(rs.getString("estado"));
        a.setOrganizacionId(rs.getInt("organizacion_id"));
        a.setCategoriaId(rs.getInt("categoria_id"));
        try {
            a.setNombreOrganizacion(rs.getString("nombre_organizacion"));
            a.setNombreCategoria(rs.getString("nombre_categoria"));
        } catch (SQLException e) {
        }
        return a;
    }
}
