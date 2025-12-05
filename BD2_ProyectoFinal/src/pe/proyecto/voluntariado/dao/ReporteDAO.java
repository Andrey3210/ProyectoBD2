package pe.proyecto.voluntariado.dao;

import java.util.List;
import pe.proyecto.voluntariado.model.ReporteActividadDTO;
import pe.proyecto.voluntariado.model.ReporteDashboard;
import pe.proyecto.voluntariado.model.ReporteTopDonante;

public interface ReporteDAO {

    List<ReporteDashboard> obtenerDashboard() throws Exception;

    List<ReporteTopDonante> obtenerTopDonantes() throws Exception;

    List<ReporteActividadDTO> obtenerReporteActividades() throws Exception;
}
