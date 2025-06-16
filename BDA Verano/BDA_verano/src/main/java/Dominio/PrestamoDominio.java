package Dominio;

import java.time.LocalDateTime;

/**
 * Representa la entidad de dominio para un Préstamo.
 * Esta clase encapsula toda la información relevante de un préstamo otorgado,
 * incluyendo detalles del solicitante, el departamento de origen, el tipo de préstamo,
 * el monto, la fecha y hora de emisión, su estatus actual y el jefe que lo autorizó.
 * Proporciona un constructor por defecto y uno parametrizado para su inicialización,
 * métodos de acceso (getters y setters) para manipular sus atributos, y una
 * representación en cadena para facilitar la depuración y el registro.
 *
 * @author Angel Gabriel Beltran Duarte 244865
 */
public class PrestamoDominio {
    /**
     * Identificador único del préstamo.
     */
    private int id;

    /**
     * El empleado que solicitó el préstamo.
     */
    private EmpleadoDominio empleado;

    /**
     * El departamento al que pertenece el empleado y desde cuya cuenta se origina el préstamo.
     */
    private DepartamentoDominio departamento;

    /**
     * El tipo específico de préstamo (ej. pago único, parcialidades).
     */
    private TipoPrestamoDominio tipoPrestamo;

    /**
     * El monto total del préstamo otorgado.
     */
    private double monto;

    /**
     * La fecha y hora exacta en que el préstamo fue realizado o registrado.
     */
    private LocalDateTime fechaHora;

    /**
     * El estatus actual del préstamo (ej. Creado, Autorizado, Pagado).
     * Se asume que 'EstatusPrestamo' es un tipo de enumeración (enum) o una clase definida en el proyecto.
     */
    private EstatusPrestamo estatus;

    /**
     * El jefe que autorizó el otorgamiento de este préstamo.
     */
    private JefeDominio jefeAutoriza;

    /**
     * Constructor por defecto de la clase PrestamoDominio.
     * Inicializa una nueva instancia de PrestamoDominio con valores predeterminados.
     */
    public PrestamoDominio() {
    }

    /**
     * Constructor parametrizado de la clase PrestamoDominio.
     * Inicializa un nuevo objeto PrestamoDominio con todos sus atributos especificados.
     *
     * @param id El identificador único del préstamo.
     * @param empleado El empleado solicitante del préstamo.
     * @param departamento El departamento de origen del préstamo.
     * @param tipoPrestamo El tipo de préstamo.
     * @param monto El monto total del préstamo.
     * @param fechaHora La fecha y hora de realización del préstamo.
     * @param estatus El estatus actual del préstamo.
     * @param jefeAutoriza El jefe que autorizó el préstamo.
     */
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

    /**
     * Obtiene el identificador único del préstamo.
     *
     * @return El ID del préstamo.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del préstamo.
     *
     * @param id El nuevo ID del préstamo.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el empleado que solicitó el préstamo.
     *
     * @return El objeto EmpleadoDominio del solicitante.
     */
    public EmpleadoDominio getEmpleado() {
        return empleado;
    }

    /**
     * Establece el empleado que solicitó el préstamo.
     *
     * @param empleado El nuevo objeto EmpleadoDominio del solicitante.
     */
    public void setEmpleado(EmpleadoDominio empleado) {
        this.empleado = empleado;
    }

    /**
     * Obtiene el departamento de origen del préstamo.
     *
     * @return El objeto DepartamentoDominio de origen.
     */
    public DepartamentoDominio getDepartamento() {
        return departamento;
    }

    /**
     * Establece el departamento de origen del préstamo.
     *
     * @param departamento El nuevo objeto DepartamentoDominio de origen.
     */
    public void setDepartamento(DepartamentoDominio departamento) {
        this.departamento = departamento;
    }

    /**
     * Obtiene el tipo específico de préstamo.
     *
     * @return El objeto TipoPrestamoDominio del préstamo.
     */
    public TipoPrestamoDominio getTipoPrestamo() {
        return tipoPrestamo;
    }

    /**
     * Establece el tipo específico de préstamo.
     *
     * @param tipoPrestamo El nuevo objeto TipoPrestamoDominio del préstamo.
     */
    public void setTipoPrestamo(TipoPrestamoDominio tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }

    /**
     * Obtiene el monto total del préstamo.
     *
     * @return El monto del préstamo.
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Establece el monto total del préstamo.
     *
     * @param monto El nuevo monto del préstamo.
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Obtiene la fecha y hora exacta en que el préstamo fue realizado.
     *
     * @return La fecha y hora del préstamo.
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora exacta en que el préstamo fue realizado.
     *
     * @param fechaHora La nueva fecha y hora del préstamo.
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el estatus actual del préstamo.
     *
     * @return El estatus del préstamo.
     */
    public EstatusPrestamo getEstatus() {
        return estatus;
    }

    /**
     * Establece el estatus actual del préstamo.
     *
     * @param estatus El nuevo estatus del préstamo.
     */
    public void setEstatus(EstatusPrestamo estatus) {
        this.estatus = estatus;
    }

    /**
     * Obtiene el jefe que autorizó el otorgamiento de este préstamo.
     *
     * @return El objeto JefeDominio que autorizó el préstamo.
     */
    public JefeDominio getJefeAutoriza() {
        return jefeAutoriza;
    }

    /**
     * Establece el jefe que autorizó el otorgamiento de este préstamo.
     *
     * @param jefeAutoriza El nuevo objeto JefeDominio que autorizó el préstamo.
     */
    public void setJefeAutoriza(JefeDominio jefeAutoriza) {
        this.jefeAutoriza = jefeAutoriza;
    }

    /**
     * Retorna una representación en cadena (String) del objeto PrestamoDominio.
     * Incluye los valores de todos los atributos para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto PrestamoDominio.
     */
    @Override
    public String toString() {
        return "PrestamoDominio{" + "id=" + id + ", empleado=" + empleado + ", departamento=" + departamento + ", tipoPrestamo=" + tipoPrestamo + ", monto=" + monto + ", fechaHora=" + fechaHora + ", estatus=" + estatus + ", jefeAutoriza=" + jefeAutoriza + "}";
    }
}