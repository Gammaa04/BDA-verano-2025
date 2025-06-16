package DTO;

import Dominio.EstatusPrestamo;
import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) que representa un registro en el **historial de cambios de estatus de un Préstamo**.
 * Esta clase se utiliza para transferir información sobre las transiciones de estado de un préstamo
 * entre las diferentes capas de la aplicación. Captura el ID del préstamo involucrado,
 * los estatus anterior y nuevo, y la marca de tiempo del cambio, lo que permite un seguimiento
 * detallado sin la necesidad de cargar los objetos de dominio completos del préstamo.
 *
 * @author Angel Gabriel Beltran Duarte
 */
public class HistorialEstatusPrestamoDTO {
    /**
     * El **identificador único** del registro en el historial de estatus.
     */
    private int id;

    /**
     * El **identificador del préstamo** al que se refiere este cambio de estatus.
     */
    private int prestamoId;

    /**
     * El **estatus del préstamo antes** de que ocurriera el cambio.
     * Se asume que 'EstatusPrestamo' es una enumeración (enum) o una clase definida en el paquete Dominio.
     */
    private EstatusPrestamo estatusAnterior;

    /**
     * El **nuevo estatus del préstamo** después de que se realizó el cambio.
     * Se asume que 'EstatusPrestamo' es una enumeración (enum) o una clase definida en el paquete Dominio.
     */
    private EstatusPrestamo estatusNuevo;

    /**
     * La **fecha y hora exacta** en que se registró el cambio de estatus.
     */
    private LocalDateTime fechaHora;

    /**
     * Constructor por defecto de la clase HistorialEstatusPrestamoDTO.
     * Permite crear una instancia de HistorialEstatusPrestamoDTO sin inicializar sus atributos,
     * los cuales pueden ser establecidos posteriormente mediante los métodos setters.
     */
    public HistorialEstatusPrestamoDTO() {}

    /**
     * Constructor parametrizado de la clase HistorialEstatusPrestamoDTO.
     * Inicializa una nueva instancia con todos sus atributos especificados.
     *
     * @param id El **identificador único** del registro.
     * @param prestamoId El **ID del préstamo** asociado a este registro de historial.
     * @param estatusAnterior El **estatus anterior** del préstamo.
     * @param estatusNuevo El **nuevo estatus** del préstamo.
     * @param fechaHora La **fecha y hora** en que se registró el cambio de estatus.
     */
    public HistorialEstatusPrestamoDTO(int id, int prestamoId, EstatusPrestamo estatusAnterior, EstatusPrestamo estatusNuevo, LocalDateTime fechaHora) {
        this.id = id;
        this.prestamoId = prestamoId;
        this.estatusAnterior = estatusAnterior;
        this.estatusNuevo = estatusNuevo;
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el **identificador único** del registro en el historial de estatus.
     *
     * @return El **ID del registro**.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el **identificador único** del registro en el historial de estatus.
     *
     * @param id El nuevo **ID del registro**.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el **identificador del préstamo** al que se refiere este cambio de estatus.
     *
     * @return El **ID del préstamo** asociado.
     */
    public int getPrestamoId() {
        return prestamoId;
    }

    /**
     * Establece el **identificador del préstamo** al que se refiere este cambio de estatus.
     *
     * @param prestamoId El nuevo **ID del préstamo** asociado.
     */
    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    /**
     * Obtiene el **estatus del préstamo antes** de que ocurriera el cambio.
     *
     * @return El **estatus anterior** del préstamo.
     */
    public EstatusPrestamo getEstatusAnterior() {
        return estatusAnterior;
    }

    /**
     * Establece el **estatus del préstamo antes** de que ocurriera el cambio.
     *
     * @param estatusAnterior El nuevo **estatus anterior** del préstamo.
     */
    public void setEstatusAnterior(EstatusPrestamo estatusAnterior) {
        this.estatusAnterior = estatusAnterior;
    }

    /**
     * Obtiene el **nuevo estatus del préstamo** después de que se realizó el cambio.
     *
     * @return El **nuevo estatus** del préstamo.
     */
    public EstatusPrestamo getEstatusNuevo() {
        return estatusNuevo;
    }

    /**
     * Establece el **nuevo estatus del préstamo** después de que se realizó el cambio.
     *
     * @param estatusNuevo El nuevo **estatus** del préstamo.
     */
    public void setEstatusNuevo(EstatusPrestamo estatusNuevo) {
        this.estatusNuevo = estatusNuevo;
    }

    /**
     * Obtiene la **fecha y hora exacta** en que se registró el cambio de estatus.
     *
     * @return La **fecha y hora** del cambio de estatus.
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la **fecha y hora exacta** en que se registró el cambio de estatus.
     *
     * @param fechaHora La nueva **fecha y hora** del cambio de estatus.
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Retorna una representación en cadena (String) del objeto HistorialEstatusPrestamoDTO.
     * Incluye los valores de todos los atributos para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto HistorialEstatusPrestamoDTO.
     */
    @Override
    public String toString() {
        return "HistorialEstatusPrestamoDTO{" +
               "id=" + id +
               ", prestamoId=" + prestamoId +
               ", estatusAnterior=" + estatusAnterior +
               ", estatusNuevo=" + estatusNuevo +
               ", fechaHora=" + fechaHora +
               '}';
    }
}
