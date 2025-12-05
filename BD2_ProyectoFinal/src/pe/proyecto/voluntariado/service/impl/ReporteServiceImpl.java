package pe.proyecto.voluntariado.service.impl;

import java.util.List;
import pe.proyecto.voluntariado.dao.ReporteDAO;
import pe.proyecto.voluntariado.dao.impl.ReporteDAOImpl;
import pe.proyecto.voluntariado.model.ReporteActividadDTO;
import pe.proyecto.voluntariado.model.ReporteDashboard;
import pe.proyecto.voluntariado.model.ReporteTopDonante;
import pe.proyecto.voluntariado.service.ReporteService;

public class ReporteServiceImpl implements ReporteService {

    private final ReporteDAO dao = new ReporteDAOImpl();

    @Override
    public List<ReporteDashboard> getDashboard() throws Exception {
        return dao.obtenerDashboard();
    }

    @Override
    public List<ReporteTopDonante> getTopDonantes() throws Exception {
        return dao.obtenerTopDonantes();
    }

    @Override
    public List<ReporteActividadDTO> getReporteActividades() throws Exception {
        return dao.obtenerReporteActividades();
    }
}
