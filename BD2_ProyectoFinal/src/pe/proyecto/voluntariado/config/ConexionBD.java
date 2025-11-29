package pe.proyecto.voluntariado.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    private static final String USUARIO = "proyectoFinal_user";
    private static final String PASSWORD = "proyectoFinal";

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error cargando el driver de Oracle");
            e.printStackTrace();
        }
    }

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
}

