package Dominio;
/**
 * En esta clase se hace la entidad de dominio de Historial Estatus Prestamo, simplemente se defininen las variables, el constructor por defecto
 * y el constructor, getters, setters y strings.
 * @author Angel Gabriel Beltran Duarte 244865
 */
import java.time.LocalDateTime;

public class HistorialEstatusPrestamoDominio {
    private int id;
    private PrestamoDominio prestamo;
    private EstatusPrestamo estatusAnterior;
    private EstatusPrestamo estatusNuevo;
    private LocalDateTime fechaHora;

    public HistorialEstatusPrestamoDominio() {
    }

    public HistorialEstatusPrestamoDominio(int id, PrestamoDominio prestamo, EstatusPrestamo estatusAnterior, EstatusPrestamo estatusNuevo, LocalDateTime fechaHora) {
        this.id = id;
        this.prestamo = prestamo;
        this.estatusAnterior = estatusAnterior;
        this.estatusNuevo = estatusNuevo;
        this.fechaHora = fechaHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PrestamoDominio getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(PrestamoDominio prestamo) {
        this.prestamo = prestamo;
    }

    public EstatusPrestamo getEstatusAnterior() {
        return estatusAnterior;
    }

    public void setEstatusAnterior(EstatusPrestamo estatusAnterior) {
        this.estatusAnterior = estatusAnterior;
    }

    public EstatusPrestamo getEstatusNuevo() {
        return estatusNuevo;
    }

    public void setEstatusNuevo(EstatusPrestamo estatusNuevo) {
        this.estatusNuevo = estatusNuevo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "HistorialEstatusPrestamoDominio{" + "id=" + id + ", prestamo=" + prestamo + ", estatusAnterior=" + estatusAnterior + ", estatusNuevo=" + estatusNuevo + ", fechaHora=" + fechaHora + "}";
    }
}
