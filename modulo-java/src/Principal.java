
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        CitaDAO citaDAO = new CitaDAO();

        int opcion;

        do {
            System.out.println("\n================================");
            System.out.println(" SISTEMA DE CITAS");
            System.out.println(" SALON DE BELLEZA");
            System.out.println("================================");
            System.out.println("1. Registrar cita");
            System.out.println("2. Consultar citas");
            System.out.println("3. Actualizar cita");
            System.out.println("4. Eliminar cita");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("ID del cliente: ");
                    int cliente = teclado.nextInt();

                    System.out.print("ID del empleado: ");
                    int empleado = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Fecha (AAAA-MM-DD): ");
                    String fecha = teclado.nextLine();

                    System.out.print("Hora (HH:MM:SS): ");
                    String hora = teclado.nextLine();

                    System.out.print("Estado: ");
                    String estado = teclado.nextLine();

                    if (citaDAO.registrarCita(
                            cliente, empleado, fecha, hora, estado)) {
                        System.out.println("¡Cita registrada correctamente!");
                    } else {
                        System.out.println("No se pudo registrar la cita.");
                    }
                    break;

                case 2:
                    System.out.println("\nLISTA DE CITAS");
                    citaDAO.consultarCitas();
                    break;

                case 3:
                    System.out.print("ID de la cita que desea actualizar: ");
                    int idActualizar = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Nueva fecha (AAAA-MM-DD): ");
                    String nuevaFecha = teclado.nextLine();

                    System.out.print("Nueva hora (HH:MM:SS): ");
                    String nuevaHora = teclado.nextLine();

                    System.out.print("Nuevo estado: ");
                    String nuevoEstado = teclado.nextLine();

                    if (citaDAO.actualizarCita(
                            idActualizar, nuevaFecha,
                            nuevaHora, nuevoEstado)) {
                        System.out.println("¡Cita actualizada!");
                    } else {
                        System.out.println("No se pudo actualizar.");
                    }
                    break;

                case 4:
                    System.out.print("ID de la cita que desea eliminar: ");
                    int idEliminar = teclado.nextInt();

                    if (citaDAO.eliminarCita(idEliminar)) {
                        System.out.println("¡Cita eliminada!");
                    } else {
                        System.out.println("No se pudo eliminar.");
                    }
                    break;

                case 5:
                    System.out.println("Gracias por utilizar el sistema.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 5);

        teclado.close();
    }
}
