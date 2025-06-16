package Dominio;
/**
 * En esta clase se hace el dominio de la entidad Abono 
 * @author Angel Gabriel Beltran Duarte 244865
 */
import java.time.LocalDateTime;

public class AbonoDominio {
    private int id;
    private PrestamoDominio prestamo;
    private double monto;
    private LocalDateTime fechaHora;
   /* private JefeDominio jefeAutoriza;

    public AbonoDominio() {
    }

    public AbonoDominio(int id, PrestamoDominio prestamo, double monto, LocalDateTime fechaHora, JefeDominio jefeAutoriza) {
        this.id = id;
        this.prestamo = prestamo;
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.jefeAutoriza = jefeAutoriza;
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public JefeDominio getJefeAutoriza() {
        return jefeAutoriza;
    }

    public void setJefeAutoriza(JefeDominio jefeAutoriza) {
        this.jefeAutoriza = jefeAutoriza;
    }

    @Override
    public String toString() {
        return "AbonoDominio{" + "id=" + id + ", prestamo=" + prestamo + ", monto=" + monto + ", fechaHora=" + fechaHora + ", jefeAutoriza=" + jefeAutoriza + "}";
    }*/
}