package pe.proyecto.voluntariado.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import pe.proyecto.voluntariado.config.ConexionBD;

public class ActividadUpdater {

    public static void actualizarEstados() {
        try (Connection conn = ConexionBD.obtenerConexion()) {
            CallableStatement cs = conn.prepareCall("{call ActualizarEstadosActividades}");
            cs.execute();
        } catch (Exception e) {
            System.out.println("Error actualizando los estados de las actividades");
            e.printStackTrace();
        }
    }
}
