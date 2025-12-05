package pe.proyecto.voluntariado.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException; // IMPORTANTE
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import pe.proyecto.voluntariado.config.ConexionBD;
import pe.proyecto.voluntariado.dao.OrganizacionDAO;
import pe.proyecto.voluntariado.model.Organizacion;

public class OrganizacionDAOImpl implements OrganizacionDAO {

    @Override
    public List<Organizacion> listarActivas() throws Exception {
        return listarPorEstado("ACTIVA");
    }

    @Override
    public List<Organizacion> listarInactivas() throws Exception {
        return listarPorEstado("INACTIVO");
    }

    // Método privado auxiliar para reutilizar código y no repetir el JDBC dos veces
    private List<Organizacion> listarPorEstado(String estadoFiltro) throws Exception {
        List<Organizacion> lista = new ArrayList<>();
        // Llamamos al paquete que trae TODAS
        String sql = "{call PKG_ADMIN_CORE.Listar_Organizaciones(?)}";

        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.execute();

            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    // AQUÍ ESTÁ EL TRUCO:
                    // Obtenemos el estado de la fila actual
                    String estadoBD = rs.getString("estado");

                    // Solo agregamos a la lista si coincide con lo que pedimos (ACTIVA o INACTIVO)
                    if (estadoBD != null && estadoBD.equalsIgnoreCase(estadoFiltro)) {
                        lista.add(mapearOrganizacion(rs));
                    }
                }
            }
        }
        return lista;
    }

    @Override
    public void desactivarOrganizacion(int organizacionId) throws Exception {
        // Reutilizamos el procedimiento genérico del paquete
        cambiarEstado(organizacionId, "INACTIVO");
    }

    @Override
    public void activarOrganizacion(int organizacionId) throws Exception {
        // Reutilizamos el procedimiento genérico del paquete
        cambiarEstado(organizacionId, "ACTIVA");
    }

    // Método privado para no repetir la llamada SQL de cambio de estado
    private void cambiarEstado(int id, String nuevoEstado) throws Exception {
        String sql = "{call PKG_ADMIN_CORE.Cambiar_Estado_Organizacion(?, ?)}";
        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, id);
            cs.setString(2, nuevoEstado);
            cs.execute();
        }
    }

    @Override
    public void insertar(Organizacion org) throws Exception {
        String sql = "{call PKG_ADMIN_CORE.Registrar_Organizacion(?, ?, ?, ?)}";

        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, org.getNombre());
            cs.setString(2, org.getDireccion());
            cs.setString(3, org.getTelefono());
            cs.setString(4, org.getEmail());

            cs.execute();

        } catch (SQLException e) {
            if (e.getErrorCode() == 20003) {
                throw new Exception("Error: El nombre o email ya existe.");
            } else {
                throw new Exception("Error al registrar: " + e.getMessage());
            }
        }
    }

    @Override
    public void modificar(Organizacion org) throws Exception {
        String sql = "{call PKG_ADMIN_CORE.Modificar_Organizacion(?, ?, ?, ?, ?)}";

        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, org.getId());
            cs.setString(2, org.getNombre());
            cs.setString(3, org.getDireccion());
            cs.setString(4, org.getTelefono());
            cs.setString(5, org.getEmail());

            cs.execute();

        } catch (SQLException e) {
            if (e.getErrorCode() == 20003) {
                throw new Exception("Error: El nombre o email ya pertenece a otra organización.");
            } else {
                throw e;
            }
        }
    }

    @Override
    public Organizacion buscarPorId(int id) throws Exception {
        Organizacion org = null;
        String sql = "{call PKG_ADMIN_CORE.Buscar_Organizacion_ID(?, ?)}";

        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, id);
            cs.registerOutParameter(2, Types.REF_CURSOR);
            cs.execute();

            try (ResultSet rs = (ResultSet) cs.getObject(2)) {
                if (rs.next()) {
                    org = mapearOrganizacion(rs);
                }
            }
        }
        return org;
    }

    // Helper de mapeo
    private Organizacion mapearOrganizacion(ResultSet rs) throws SQLException {
        Organizacion org = new Organizacion();
        org.setId(rs.getInt("organizacion_id"));
        org.setNombre(rs.getString("nombre"));
        org.setDireccion(rs.getString("direccion"));
        org.setTelefono(rs.getString("telefono"));
        org.setEmail(rs.getString("email"));
        org.setEstado(rs.getString("estado"));
        // org.setFechaRegistro(rs.getDate("fecha_registro")); // Descomenta si lo usas
        return org;
    }
}
