package pe.proyecto.voluntariado.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import pe.proyecto.voluntariado.config.ConexionBD;
import pe.proyecto.voluntariado.dao.ReporteDAO;
import pe.proyecto.voluntariado.model.ReporteActividadDTO;
import pe.proyecto.voluntariado.model.ReporteDashboard;
import pe.proyecto.voluntariado.model.ReporteTopDonante;

public class ReporteDAOImpl implements ReporteDAO {

    @Override
    public List<ReporteDashboard> obtenerDashboard() throws Exception {
        List<ReporteDashboard> lista = new ArrayList<>();
        // Llamamos al procedimiento del paquete Oracle
        String sql = "{call PKG_REPORTES.Obtener_Dashboard_Impacto(?)}";

        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.execute();

            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    ReporteDashboard r = new ReporteDashboard();
                    r.setOrganizacion(rs.getString("Organizacion"));
                    r.setTotalTransacciones(rs.getInt("Total_Transacciones"));
                    r.setTotalRecaudado(rs.getDouble("Total_Recaudado"));
                    r.setSatisfaccionPromedio(rs.getDouble("Satisfaccion_Promedio"));
                    lista.add(r);
                }
            }
        }
        return lista;
    }

    @Override
    public List<ReporteTopDonante> obtenerTopDonantes() throws Exception {
        List<ReporteTopDonante> lista = new ArrayList<>();
        String sql = "{call PKG_REPORTES.Obtener_Top_Donantes(?)}";

        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.execute();

            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    ReporteTopDonante r = new ReporteTopDonante();
                    r.setVoluntarioNombre(rs.getString("Voluntario"));
                    r.setNroDonaciones(rs.getInt("Nro_Donaciones"));
                    r.setTotalDonado(rs.getDouble("Total_Donado"));
                    lista.add(r);
                }
            }
        }
        return lista;
    }

    @Override
    public List<ReporteActividadDTO> obtenerReporteActividades() throws Exception {
        List<ReporteActividadDTO> lista = new ArrayList<>();
        String sql = "{call PKG_REPORTES.Reporte_Actividades(?)}";

        try (Connection conn = ConexionBD.obtenerConexion(); CallableStatement cs = conn.prepareCall(sql)) {

            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.execute();

            try (ResultSet rs = (ResultSet) cs.getObject(1)) {
                while (rs.next()) {
                    ReporteActividadDTO r = new ReporteActividadDTO();
                    r.setActividad(rs.getString("Actividad"));
                    r.setCategoria(rs.getString("Categoria"));
                    r.setOrganizadora(rs.getString("Organizadora"));
                    r.setEstado(rs.getString("Estado"));
                    r.setFechaInicio(rs.getString("Fecha_Inicio"));
                    lista.add(r);
                }
            }
        }
        return lista;
    }
}
