import java.time.LocalDate;

public class Equipo {
    private String nombreEquipo;
    private String localidad;
    private LocalDate fechaCreacion;

    public Equipo(String nombreEquipo, String localidad, LocalDate fechaCreacion) {
        this.nombreEquipo = nombreEquipo;
        this.localidad = localidad;
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombreEquipo='" + nombreEquipo + '\'' +
                ", localidad='" + localidad + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}