package DTO;

import Dominio.EstatusPrestamo;
import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) que representa un **Préstamo**.
 * Esta clase se usa para transferir la información de un préstamo entre las capas
 * de la aplicación, como la capa de presentación y la capa de negocio o persistencia.
 * Contiene los identificadores de las entidades relacionadas (empleado, departamento,
 * tipo de préstamo y jefe autorizador) en lugar de los objetos completos, lo que
 * permite una transferencia de datos más eficiente y evita problemas de serialización
 * o dependencias cíclicas. También incluye detalles clave como el monto, la fecha
 * y hora, y el estatus actual del préstamo.
 *
 * @author Angel Gabriel Beltran Duarte
 */
public class PrestamoDTO {
    /**
     * El **identificador único** del préstamo.
     */
    private int id;

    /**
     * El **identificador del empleado** que solicitó el préstamo.
     */
    private int empleadoId;

    /**
     * El **identificador del departamento** al que pertenece el empleado y desde donde se originó el préstamo.
     */
    private int departamentoId;

    /**
     * El **identificador del tipo de préstamo** (ej. "Préstamo de nómina", "Préstamo hipotecario").
     */
    private int tipoPrestamoId;

    /**
     * El **monto total** del préstamo otorgado.
     */
    private double monto;

    /**
     * La **fecha y hora exacta** en que el préstamo fue realizado o registrado.
     */
    private LocalDateTime fechaHora;

    /**
     * El **estatus actual** del préstamo (ej. Creado, Autorizado, Pagado).
     * Se asume que 'EstatusPrestamo' es una enumeración (enum) o una clase definida en el paquete Dominio.
     */
    private EstatusPrestamo estatus;

    /**
     * El **identificador del jefe** que autorizó el otorgamiento de este préstamo.
     */
    private int jefeAutorizaId;

    /**
     * Constructor por defecto de la clase PrestamoDTO.
     * Permite crear una instancia de PrestamoDTO sin inicializar sus atributos,
     * los cuales pueden ser establecidos posteriormente mediante los métodos setters.
     */
    public PrestamoDTO() {}

    /**
     * Constructor parametrizado de la clase PrestamoDTO.
     * Inicializa una nueva instancia de PrestamoDTO con todos sus atributos especificados.
     *
     * @param id El **identificador único** del préstamo.
     * @param empleadoId El **ID del empleado** solicitante del préstamo.
     * @param departamentoId El **ID del departamento** de origen del préstamo.
     * @param tipoPrestamoId El **ID del tipo de préstamo**.
     * @param monto El **monto total** del préstamo.
     * @param fechaHora La **fecha y hora** de realización del préstamo.
     * @param estatus El **estatus actual** del préstamo.
     * @param jefeAutorizaId El **ID del jefe** que autorizó el préstamo.
     */
    public PrestamoDTO(int id, int empleadoId, int departamentoId, int tipoPrestamoId, double monto, LocalDateTime fechaHora, EstatusPrestamo estatus, int jefeAutorizaId) {
        this.id = id;
        this.empleadoId = empleadoId;
        this.departamentoId = departamentoId;
        this.tipoPrestamoId = tipoPrestamoId;
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.estatus = estatus;
        this.jefeAutorizaId = jefeAutorizaId;
    }

    /**
     * Obtiene el **identificador único** del préstamo.
     *
     * @return El **ID del préstamo**.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el **identificador único** del préstamo.
     *
     * @param id El nuevo **ID del préstamo**.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el **identificador del empleado** que solicitó el préstamo.
     *
     * @return El **ID del empleado** solicitante.
     */
    public int getEmpleadoId() {
        return empleadoId;
    }

    /**
     * Establece el **identificador del empleado** que solicitó el préstamo.
     *
     * @param empleadoId El nuevo **ID del empleado** solicitante.
     */
    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    /**
     * Obtiene el **identificador del departamento** de origen del préstamo.
     *
     * @return El **ID del departamento** de origen.
     */
    public int getDepartamentoId() {
        return departamentoId;
    }

    /**
     * Establece el **identificador del departamento** de origen del préstamo.
     *
     * @param departamentoId El nuevo **ID del departamento** de origen.
     */
    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    /**
     * Obtiene el **identificador del tipo de préstamo**.
     *
     * @return El **ID del tipo de préstamo**.
     */
    public int getTipoPrestamoId() {
        return tipoPrestamoId;
    }

    /**
     * Establece el **identificador del tipo de préstamo**.
     *
     * @param tipoPrestamoId El nuevo **ID del tipo de préstamo**.
     */
    public void setTipoPrestamoId(int tipoPrestamoId) {
        this.tipoPrestamoId = tipoPrestamoId;
    }

    /**
     * Obtiene el **monto total** del préstamo.
     *
     * @return El **monto** del préstamo.
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Establece el **monto total** del préstamo.
     *
     * @param monto El nuevo **monto** del préstamo.
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Obtiene la **fecha y hora exacta** en que el préstamo fue realizado.
     *
     * @return La **fecha y hora** del préstamo.
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la **fecha y hora exacta** en que el préstamo fue realizado.
     *
     * @param fechaHora La nueva **fecha y hora** del préstamo.
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el **estatus actual** del préstamo.
     *
     * @return El **estatus** del préstamo.
     */
    public EstatusPrestamo getEstatus() {
        return estatus;
    }

    /**
     * Establece el **estatus actual** del préstamo.
     *
     * @param estatus El nuevo **estatus** del préstamo.
     */
    public void setEstatus(EstatusPrestamo estatus) {
        this.estatus = estatus;
    }

    /**
     * Obtiene el **identificador del jefe** que autorizó el otorgamiento de este préstamo.
     *
     * @return El **ID del jefe** que autorizó el préstamo.
     */
    public int getJefeAutorizaId() {
        return jefeAutorizaId;
    }

    /**
     * Establece el **identificador del jefe** que autorizó el otorgamiento de este préstamo.
     *
     * @param jefeAutorizaId El nuevo **ID del jefe** que autorizó el préstamo.
     */
    public void setJefeAutorizaId(int jefeAutorizaId) {
        this.jefeAutorizaId = jefeAutorizaId;
    }

    /**
     * Retorna una representación en cadena (String) del objeto PrestamoDTO.
     * Incluye los valores de todos los atributos para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto PrestamoDTO.
     */
    @Override
    public String toString() {
        return "PrestamoDTO{" +
               "id=" + id +
               ", empleadoId=" + empleadoId +
               ", departamentoId=" + departamentoId +
               ", tipoPrestamoId=" + tipoPrestamoId +
               ", monto=" + monto +
               ", fechaHora=" + fechaHora +
               ", estatus=" + estatus +
               ", jefeAutorizaId=" + jefeAutorizaId +
               '}';
    }
}
