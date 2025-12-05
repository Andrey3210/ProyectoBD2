package pe.proyecto.voluntariado.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import pe.proyecto.voluntariado.config.ConexionBD;
import pe.proyecto.voluntariado.dao.VoluntarioDAO;
import pe.proyecto.voluntariado.model.Voluntario;

public class VoluntarioDAOImpl implements VoluntarioDAO {

    @Override
    public List<Voluntario> listarTodos() throws Exception {
        List<Voluntario> lista = new ArrayList<>();
        String sql = "{call PKG_VOLUNTARIADO.Listar_Voluntarios(?)}";

        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {

            // --- CAMBIO AQUÍ ---
            // Usamos el estándar de Java (Types.REF_CURSOR) en lugar de OracleTypes
            cs.registerOutParameter(1, Types.REF_CURSOR);

            cs.execute();

            // El resto sigue igual
            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    lista.add(mapearVoluntario(rs));
                }
            }
        }
        return lista;
    }

    @Override
    public Voluntario buscarPorId(int id) throws Exception {
        String sql = "{call PKG_VOLUNTARIADO.Buscar_Voluntario_Por_ID(?, ?)}";
        Voluntario v = null;
        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, id);
            cs.registerOutParameter(2, Types.OTHER);
            cs.execute();
            try (ResultSet rs = (ResultSet) cs.getObject(2)) {
                if (rs.next()) {
                    v = mapearVoluntario(rs);
                }
            }
        }
        return v;
    }

    @Override
    public Voluntario buscarPorDni(String dni) throws Exception {
        String sql = "SELECT * FROM Voluntario WHERE dni = ?";

        try (Connection conn = ConexionBD.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapearVoluntario(rs);
            }
        }
        return null;
    }

    @Override
    public void insertar(Voluntario v) throws Exception {
        // Llamada al paquete para escritura
        String sql = "{call PKG_VOLUNTARIADO.Registrar_Voluntario(?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, v.getDni());
            cs.setString(2, v.getNombres());
            cs.setString(3, v.getApellidos());
            cs.setDate(4, v.getFechaNacimiento() != null ? new java.sql.Date(v.getFechaNacimiento().getTime()) : null);
            cs.setString(5, v.getEmail());
            cs.setString(6, v.getTelefono());
            cs.setString(7, v.getDireccion());
            cs.setString(8, v.getEstadoCivil());

            cs.execute();
        } catch (SQLException e) {
            throw new Exception("Error BD: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Voluntario voluntario) throws Exception {
        String sql = "{CALL ModificarVoluntario(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, voluntario.getId());
            cs.setString(2, voluntario.getDni());
            cs.setString(3, voluntario.getNombres());
            cs.setString(4, voluntario.getApellidos());
            cs.setDate(5, voluntario.getFechaNacimiento() != null
                    ? new java.sql.Date(voluntario.getFechaNacimiento().getTime()) : null);
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
        String sql = "SELECT * FROM Voluntario WHERE "
                + "UPPER(dni) LIKE UPPER(?) OR "
                + "UPPER(nombres) LIKE UPPER(?) OR "
                + "UPPER(apellidos) LIKE UPPER(?) OR "
                + "UPPER(email) LIKE UPPER(?) OR "
                + "UPPER(telefono) LIKE UPPER(?) "
                + "ORDER BY fecha_registro DESC";

        String patron = "%" + texto + "%";

        try (Connection conn = ConexionBD.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

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
