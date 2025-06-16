package Dominio;

import java.time.LocalDateTime;

/**
 * Representa la entidad de dominio para un registro en el historial de cambios de estatus de un préstamo.
 * Esta clase captura el momento y los detalles de una transición de estatus para un préstamo,
 * incluyendo el estatus anterior y el nuevo, así como la fecha y hora del cambio.
 * Proporciona un constructor por defecto y uno parametrizado para su inicialización,
 * métodos de acceso (getters y setters) para manipular sus atributos, y una
 * representación en cadena para facilitar la depuración y el registro.
 *
 * @author Angel Gabriel Beltran Duarte 244865
 */
public class HistorialEstatusPrestamoDominio {
    /**
     * Identificador único del registro en el historial de estatus del préstamo.
     */
    private int id;

    /**
     * El objeto PrestamoDominio al que se refiere este cambio de estatus.
     */
    private PrestamoDominio prestamo;

    /**
     * El estatus del préstamo antes de que ocurriera el cambio.
     * Se asume que 'EstatusPrestamo' es un tipo de enumeración (enum) o una clase definida en el proyecto.
     */
    private EstatusPrestamo estatusAnterior;

    /**
     * El nuevo estatus del préstamo después de que se realizó el cambio.
     * Se asume que 'EstatusPrestamo' es un tipo de enumeración (enum) o una clase definida en el proyecto.
     */
    private EstatusPrestamo estatusNuevo;

    /**
     * La fecha y hora exacta en que se registró el cambio de estatus.
     */
    private LocalDateTime fechaHora;

    /**
     * Constructor por defecto de la clase HistorialEstatusPrestamoDominio.
     * Inicializa una nueva instancia con valores predeterminados.
     */
    public HistorialEstatusPrestamoDominio() {
    }

    /**
     * Constructor parametrizado de la clase HistorialEstatusPrestamoDominio.
     * Inicializa un nuevo objeto con todos sus atributos especificados.
     *
     * @param id El identificador único del registro.
     * @param prestamo El préstamo asociado a este registro de historial.
     * @param estatusAnterior El estatus del préstamo antes del cambio.
     * @param estatusNuevo El nuevo estatus del préstamo después del cambio.
     * @param fechaHora La fecha y hora en que se registró el cambio de estatus.
     */
    public HistorialEstatusPrestamoDominio(int id, PrestamoDominio prestamo, EstatusPrestamo estatusAnterior, EstatusPrestamo estatusNuevo, LocalDateTime fechaHora) {
        this.id = id;
        this.prestamo = prestamo;
        this.estatusAnterior = estatusAnterior;
        this.estatusNuevo = estatusNuevo;
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el identificador único del registro en el historial de estatus.
     *
     * @return El ID del registro.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del registro en el historial de estatus.
     *
     * @param id El nuevo ID del registro.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el objeto PrestamoDominio al que se refiere este cambio de estatus.
     *
     * @return El préstamo asociado.
     */
    public PrestamoDominio getPrestamo() {
        return prestamo;
    }

    /**
     * Establece el objeto PrestamoDominio al que se refiere este cambio de estatus.
     *
     * @param prestamo El nuevo préstamo asociado.
     */
    public void setPrestamo(PrestamoDominio prestamo) {
        this.prestamo = prestamo;
    }

    /**
     * Obtiene el estatus del préstamo antes de que ocurriera el cambio.
     *
     * @return El estatus anterior del préstamo.
     */
    public EstatusPrestamo getEstatusAnterior() {
        return estatusAnterior;
    }

    /**
     * Establece el estatus del préstamo antes de que ocurriera el cambio.
     *
     * @param estatusAnterior El nuevo estatus anterior del préstamo.
     */
    public void setEstatusAnterior(EstatusPrestamo estatusAnterior) {
        this.estatusAnterior = estatusAnterior;
    }

    /**
     * Obtiene el nuevo estatus del préstamo después de que se realizó el cambio.
     *
     * @return El nuevo estatus del préstamo.
     */
    public EstatusPrestamo getEstatusNuevo() {
        return estatusNuevo;
    }

    /**
     * Establece el nuevo estatus del préstamo después de que se realizó el cambio.
     *
     * @param estatusNuevo El nuevo estatus del préstamo.
     */
    public void setEstatusNuevo(EstatusPrestamo estatusNuevo) {
        this.estatusNuevo = estatusNuevo;
    }

    /**
     * Obtiene la fecha y hora exacta en que se registró el cambio de estatus.
     *
     * @return La fecha y hora del cambio de estatus.
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora exacta en que se registró el cambio de estatus.
     *
     * @param fechaHora La nueva fecha y hora del cambio de estatus.
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Retorna una representación en cadena (String) del objeto HistorialEstatusPrestamoDominio.
     * Incluye los valores de todos los atributos para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto HistorialEstatusPrestamoDominio.
     */
    @Override
    public String toString() {
        return "HistorialEstatusPrestamoDominio{" + "id=" + id + ", prestamo=" + prestamo + ", estatusAnterior=" + estatusAnterior + ", estatusNuevo=" + estatusNuevo + ", fechaHora=" + fechaHora + "}";
    }
}