package pe.proyecto.voluntariado.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import pe.proyecto.voluntariado.config.ConexionBD;
import pe.proyecto.voluntariado.dao.DonacionDAO;
import pe.proyecto.voluntariado.model.Donacion;

public class DonacionDAOImpl implements DonacionDAO {

    @Override
    public List<Donacion> listarTodos() throws Exception {
        List<Donacion> lista = new ArrayList<>();
        // Llamamos al procedimiento del paquete
        String sql = "{call PKG_DONACIONES.Listar_Todas(?)}";

        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {

            // --- CORRECCIÓN AQUÍ: Usar Types.REF_CURSOR ---
            cs.registerOutParameter(1, Types.REF_CURSOR);

            cs.execute();

            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    lista.add(mapearDonacion(rs));
                }
            }
        }
        return lista;
    }

    @Override
    public Donacion buscarPorId(int id) throws Exception {
        Donacion d = null;
        String sql = "{call PKG_DONACIONES.Buscar_Por_ID(?, ?)}";

        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, id); // ID Entrada

            // --- CORRECCIÓN AQUÍ: Usar Types.REF_CURSOR ---
            cs.registerOutParameter(2, Types.REF_CURSOR);

            cs.execute();

            try (ResultSet rs = (ResultSet) cs.getObject(2)) {
                if (rs.next()) {
                    d = mapearDonacion(rs);
                }
            }
        }
        return d;
    }

    @Override
    public void insertar(Donacion d) throws Exception {
        String sql = "{call PKG_DONACIONES.Registrar_Donacion(?, ?, ?, ?, ?)}";

        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, d.getVoluntarioId());
            cs.setInt(2, d.getOrganizacionId());
            cs.setInt(3, d.getTipoDonacionId());
            cs.setDouble(4, d.getCantidad());

            // Manejo de nulos para calificación
            if (d.getCalificacion() > 0) {
                cs.setInt(5, d.getCalificacion());
            } else {
                cs.setNull(5, Types.INTEGER);
            }

            cs.execute();

        } catch (SQLException e) {
            manejarErrores(e);
        }
    }

    @Override
    public void modificar(Donacion d) throws Exception {
        String sql = "{call PKG_DONACIONES.Modificar_Donacion(?, ?, ?, ?, ?, ?)}";

        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, d.getId()); // ID Donacion a editar
            cs.setInt(2, d.getVoluntarioId());
            cs.setInt(3, d.getOrganizacionId());
            cs.setInt(4, d.getTipoDonacionId());
            cs.setDouble(5, d.getCantidad());

            if (d.getCalificacion() > 0) {
                cs.setInt(6, d.getCalificacion());
            } else {
                cs.setNull(6, Types.INTEGER);
            }

            cs.execute();

        } catch (SQLException e) {
            manejarErrores(e);
        }
    }

    @Override
    public List<Donacion> buscar(String texto) throws Exception {
        List<Donacion> lista = new ArrayList<>();
        // Usa el filtro por nombre de voluntario u ONG
        String sql = "{call PKG_DONACIONES.Buscar_Filtro(?, ?)}";

        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, texto);

            // --- CORRECCIÓN AQUÍ: Usar Types.REF_CURSOR ---
            cs.registerOutParameter(2, Types.REF_CURSOR);

            cs.execute();

            try (ResultSet rs = (ResultSet) cs.getObject(2)) {
                while (rs.next()) {
                    lista.add(mapearDonacion(rs));
                }
            }
        }
        return lista;
    }

    // --- MÉTODOS PRIVADOS ---
    private Donacion mapearDonacion(ResultSet rs) throws SQLException {
        Donacion d = new Donacion();
        d.setId(rs.getInt("donacion_id"));
        d.setCantidad(rs.getDouble("cantidad"));
        d.setFecha(rs.getDate("fecha"));
        d.setCalificacion(rs.getInt("calificacion"));

        // Mapeamos los IDs foráneos
        d.setVoluntarioId(rs.getInt("voluntario_id"));
        d.setOrganizacionId(rs.getInt("organizacion_id"));
        d.setTipoDonacionId(rs.getInt("tipo_donacion_id"));

        try {
            // Estos nombres vienen del JOIN en el paquete SQL
            d.setNombreVoluntario(rs.getString("nombre_voluntario"));
            d.setNombreOrganizacion(rs.getString("nombre_organizacion"));
            d.setNombreTipoDonacion(rs.getString("nombre_tipo"));
        } catch (SQLException e) {
            // Ignorar si el modelo no tiene estos campos o la consulta cambia
        }

        return d;
    }

    private void manejarErrores(SQLException e) throws Exception {
        // Capturamos el error personalizado definido en el Paquete (-20051)
        if (e.getErrorCode() == 20051) {
            throw new Exception("Error: La organización seleccionada está INACTIVA y no acepta donaciones.");
        } else {
            throw new Exception("Error en Base de Datos: " + e.getMessage());
        }
    }
}
