public class CitaTemporal {

    private int id;
    private String nombreCliente;
    private String servicio;
    private String fecha;
    private String hora;

    public CitaTemporal(int id, String nombreCliente, String servicio,
                String fecha, String hora) {

        this.id = id;
        this.nombreCliente = nombreCliente;
        this.servicio = servicio;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getServicio() {
        return servicio;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Servicio: " + servicio);
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);
    }
}