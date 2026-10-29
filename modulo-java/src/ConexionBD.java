
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/salon_belleza";

    private static final String USUARIO = "root";

    // Escribe aquí tu contraseña real de MySQL Workbench
    private static final String CONTRASENA = "12022023";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(
                URL, USUARIO, CONTRASENA
        );
    }

    public static void main(String[] args) {
       try (Connection conexion = conectar()) {
    if (conexion != null && conexion.isValid(2)) {
        System.out.println(
                "¡Conexión exitosa con salon_belleza!"
        );
    }
        } catch (SQLException e) {
            System.out.println(
                    "No se pudo conectar a MySQL: " + e.getMessage()
            );
        }
    }
}

