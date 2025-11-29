package pe.proyecto.voluntariado.app;

import pe.proyecto.voluntariado.ui.MenuPrincipal;
import pe.proyecto.voluntariado.service.ActividadUpdater;

public class ProgramaPrincipal {

    public static void main(String[] args) {

        // Actualizar estados de las actividades según fechas
        ActividadUpdater.actualizarEstados();

        // Abrir el menu principal del sistema
        new MenuPrincipal().setVisible(true);
    }
}
