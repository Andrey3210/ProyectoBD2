package pe.proyecto.voluntariado.service;

import java.util.List;
import pe.proyecto.voluntariado.model.ReporteActividadDTO;
import pe.proyecto.voluntariado.model.ReporteDashboard;
import pe.proyecto.voluntariado.model.ReporteTopDonante;

public interface ReporteService {

    List<ReporteDashboard> getDashboard() throws Exception;

    List<ReporteTopDonante> getTopDonantes() throws Exception;

    List<ReporteActividadDTO> getReporteActividades() throws Exception;
}
