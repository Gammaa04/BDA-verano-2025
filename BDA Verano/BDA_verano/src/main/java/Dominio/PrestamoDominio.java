package Dominio;
/**
 * En esta clase se hace la entidad de dominio de Prestamo, simplemente se defininen las variables, el constructor por defecto
 * y el constructor, getters, setters y strings.
 * @author Angel Gabriel Beltran Duarte 244865
 */
import java.time.LocalDateTime;


/**
 *
 * @author Angel Gabriel Beltran Duarte 244865
 */

public class PrestamoDominio {
    private int id;
    private EmpleadoDominio empleado;
    private DepartamentoDominio departamento;
    private TipoPrestamoDominio tipoPrestamo;
    private double monto;
    private LocalDateTime fechaHora;
    private EstatusPrestamo estatus;
    private JefeDominio jefeAutoriza;

    public PrestamoDominio() {
    }

    public PrestamoDominio(int id, EmpleadoDominio empleado, DepartamentoDominio departamento, TipoPrestamoDominio tipoPrestamo, double monto, LocalDateTime fechaHora, EstatusPrestamo estatus, JefeDominio jefeAutoriza) {
        this.id = id;
        this.empleado = empleado;
        this.departamento = departamento;
        this.tipoPrestamo = tipoPrestamo;
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.estatus = estatus;
        this.jefeAutoriza = jefeAutoriza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmpleadoDominio getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoDominio empleado) {
        this.empleado = empleado;
    }

    public DepartamentoDominio getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDominio departamento) {
        this.departamento = departamento;
    }

    public TipoPrestamoDominio getTipoPrestamo() {
        return tipoPrestamo;
    }

    public void setTipoPrestamo(TipoPrestamoDominio tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
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

    public EstatusPrestamo getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusPrestamo estatus) {
        this.estatus = estatus;
    }

    public JefeDominio getJefeAutoriza() {
        return jefeAutoriza;
    }

    public void setJefeAutoriza(JefeDominio jefeAutoriza) {
        this.jefeAutoriza = jefeAutoriza;
    }

    @Override
    public String toString() {
        return "PrestamoDominio{" + "id=" + id + ", empleado=" + empleado + ", departamento=" + departamento + ", tipoPrestamo=" + tipoPrestamo + ", monto=" + monto + ", fechaHora=" + fechaHora + ", estatus=" + estatus + ", jefeAutoriza=" + jefeAutoriza + "}";
    }
}
