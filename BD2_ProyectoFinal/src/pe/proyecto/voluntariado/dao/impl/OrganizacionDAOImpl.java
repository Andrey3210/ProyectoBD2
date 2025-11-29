package pe.proyecto.voluntariado.dao.impl;

import pe.proyecto.voluntariado.config.ConexionBD;
import pe.proyecto.voluntariado.dao.OrganizacionDAO;
import pe.proyecto.voluntariado.model.Organizacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class OrganizacionDAOImpl implements OrganizacionDAO {

    @Override
    public void insertar(Organizacion organizacion) throws Exception {
        String sql = "{CALL RegistrarOrganizacion(?, ?, ?, ?)}";

        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, organizacion.getNombre());
            cs.setString(2, organizacion.getDireccion());
            cs.setString(3, organizacion.getTelefono());
            cs.setString(4, organizacion.getEmail());

            cs.execute();

        } catch (SQLException e) {
            // Manejar errores específicos del procedimiento almacenado
            if (e.getErrorCode() == 20003) {
                throw new Exception("Ya existe una organización con este email.");
            } else if (e.getErrorCode() == 20004) {
                throw new Exception("Ya existe una organización con este nombre.");
            } else {
                throw new Exception("Error al registrar la organización: " + e.getMessage());
            }
        }
    }

    @Override
    public List<Organizacion> listarActivas() throws Exception {
        return listarDesdeVista("Organizaciones_Activas");
    }

    @Override
    public List<Organizacion> listarInactivas() throws Exception {
        return listarDesdeVista("Organizaciones_Inactivas");
    }

    @Override
    public void desactivarOrganizacion(int organizacionId) throws Exception {
        String sql = "{CALL DesactivarOrganizacion(?)}";
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = ConexionBD.obtenerConexion();
            cs = conn.prepareCall(sql);
            cs.setInt(1, organizacionId);
            cs.execute();
        } catch (SQLException e) {
            if (e.getErrorCode() == 20001) {
                throw new Exception("La organización no existe.");
            }
            throw new Exception("Error al desactivar la organización: " + e.getMessage());
        } finally {
            if (cs != null) try {
                cs.close();
            } catch (SQLException e) {
            }
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public void activarOrganizacion(int organizacionId) throws Exception {
        String sql = "{CALL ActivarOrganizacion(?)}";
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = ConexionBD.obtenerConexion();
            cs = conn.prepareCall(sql);
            cs.setInt(1, organizacionId);
            cs.execute();
        } catch (SQLException e) {
            if (e.getErrorCode() == 20002) {
                throw new Exception("La organización no existe.");
            }
            throw new Exception("Error al activar la organización: " + e.getMessage());
        } finally {
            if (cs != null) try {
                cs.close();
            } catch (SQLException e) {
            }
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    private List<Organizacion> listarDesdeVista(String vista) throws Exception {

        List<Organizacion> lista = new ArrayList<>();

        String sql = "SELECT * FROM " + vista;

        try (Connection conn = ConexionBD.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Organizacion o = new Organizacion();
                o.setId(rs.getInt("organizacion_id"));
                o.setNombre(rs.getString("nombre"));
                o.setDireccion(rs.getString("direccion"));
                o.setTelefono(rs.getString("telefono"));
                o.setEmail(rs.getString("email"));
                o.setFechaRegistro(rs.getDate("fecha_registro"));
                lista.add(o);
            }
        }
        return lista;
    }

    @Override
    public void modificar(Organizacion organizacion) throws Exception {
        String sql = "{CALL ModificarOrganizacion(?, ?, ?, ?, ?)}";

        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, organizacion.getId());
            cs.setString(2, organizacion.getNombre());
            cs.setString(3, organizacion.getDireccion());
            cs.setString(4, organizacion.getTelefono());
            cs.setString(5, organizacion.getEmail());

            cs.execute();

        } catch (SQLException e) {
            if (e.getErrorCode() == 20005) {
                throw new Exception("La organización no existe.");
            } else if (e.getErrorCode() == 20003) {
                throw new Exception("Ya existe otra organización con este email.");
            } else if (e.getErrorCode() == 20004) {
                throw new Exception("Ya existe otra organización con este nombre.");
            } else {
                throw new Exception("Error al modificar la organización: " + e.getMessage());
            }
        }
    }
}
