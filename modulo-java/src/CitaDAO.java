
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CitaDAO {

    // REGISTRAR UNA CITA
    public boolean registrarCita(
            int idCliente, int idEmpleado,
            String fecha, String hora, String estado) {

        String sql = "INSERT INTO citas "
                + "(id_cliente, id_empleado, fecha, hora, estado) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {

            consulta.setInt(1, idCliente);
            consulta.setInt(2, idEmpleado);
            consulta.setString(3, fecha);
            consulta.setString(4, hora);
            consulta.setString(5, estado);

            return consulta.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar: " + e.getMessage());
            return false;
        }
    }

    // CONSULTAR LAS CITAS
    public void consultarCitas() {

        String sql = "SELECT * FROM citas";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement consulta = conexion.prepareStatement(sql);
             ResultSet resultado = consulta.executeQuery()) {

            while (resultado.next()) {
                System.out.println(
                    "ID: " + resultado.getInt("id_cita")
                    + " | Cliente: " + resultado.getInt("id_cliente")
                    + " | Empleado: " + resultado.getInt("id_empleado")
                    + " | Fecha: " + resultado.getDate("fecha")
                    + " | Hora: " + resultado.getTime("hora")
                    + " | Estado: " + resultado.getString("estado")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }

    // ACTUALIZAR UNA CITA
    public boolean actualizarCita(
            int idCita, String fecha, String hora, String estado) {

        String sql = "UPDATE citas SET fecha = ?, hora = ?, estado = ? "
                + "WHERE id_cita = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {

            consulta.setString(1, fecha);
            consulta.setString(2, hora);
            consulta.setString(3, estado);
            consulta.setInt(4, idCita);

            return consulta.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR UNA CITA
    public boolean eliminarCita(int idCita) {

        String sql = "DELETE FROM citas WHERE id_cita = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement consulta = conexion.prepareStatement(sql)) {

            consulta.setInt(1, idCita);

            return consulta.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
}
