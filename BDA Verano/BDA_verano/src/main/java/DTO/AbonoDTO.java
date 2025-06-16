package DTO;

import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) que representa un Abono.
 * Esta clase se utiliza para transferir datos de abono entre las capas de la aplicación,
 * especialmente entre la capa de presentación y la capa de negocio o persistencia.
 * A diferencia de la clase de dominio, los objetos relacionados se representan aquí
 * por sus identificadores (IDs) para simplificar la transferencia de datos y evitar
 * cargas de datos innecesarias.
 *
 * @author Angel Gabriel Beltran Duarte
 */
public class AbonoDTO {
    /**
     * El identificador único del abono.
     */
    private int id;

    /**
     * El identificador del préstamo al que este abono está asociado.
     */
    private int prestamoId;

    /**
     * El monto monetario del abono realizado.
     */
    private double monto;

    /**
     * La fecha y hora exacta en que se realizó el abono.
     */
    private LocalDateTime fechaHora;

    /**
     * El identificador del jefe que autorizó o procesó este abono.
     */
    private int jefeAutorizaId;

    /**
     * Constructor por defecto de la clase AbonoDTO.
     * Permite crear una instancia de AbonoDTO sin inicializar sus atributos,
     * los cuales pueden ser establecidos posteriormente mediante los métodos setters.
     */
    public AbonoDTO() {
    }

    /**
     * Constructor parametrizado de la clase AbonoDTO.
     * Inicializa una nueva instancia de AbonoDTO con todos los atributos especificados.
     *
     * @param id El identificador único del abono.
     * @param prestamoId El ID del préstamo asociado a este abono.
     * @param monto El monto monetario del abono.
     * @param fechaHora La fecha y hora en que se realizó el abono.
     * @param jefeAutorizaId El ID del jefe que autorizó el abono.
     */
    public AbonoDTO(int id, int prestamoId, double monto, LocalDateTime fechaHora, int jefeAutorizaId) {
        this.id = id;
        this.prestamoId = prestamoId;
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.jefeAutorizaId = jefeAutorizaId;
    }

    /**
     * Obtiene el identificador único del abono.
     *
     * @return El ID del abono.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del abono.
     *
     * @param id El nuevo ID del abono.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador del préstamo al que este abono está asociado.
     *
     * @return El ID del préstamo asociado.
     */
    public int getPrestamoId() {
        return prestamoId;
    }

    /**
     * Establece el identificador del préstamo al que este abono estará asociado.
     *
     * @param prestamoId El nuevo ID del préstamo asociado.
     */
    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    /**
     * Obtiene el monto monetario del abono.
     *
     * @return El monto del abono.
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Establece el monto monetario del abono.
     *
     * @param monto El nuevo monto del abono.
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Obtiene la fecha y hora en que se realizó el abono.
     *
     * @return La fecha y hora del abono.
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora en que se realizó el abono.
     *
     * @param fechaHora La nueva fecha y hora del abono.
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el identificador del jefe que autorizó o procesó este abono.
     *
     * @return El ID del jefe que autorizó el abono.
     */
    public int getJefeAutorizaId() {
        return jefeAutorizaId;
    }

    /**
     * Establece el identificador del jefe que autorizó o procesó este abono.
     *
     * @param jefeAutorizaId El nuevo ID del jefe que autorizó el abono.
     */
    public void setJefeAutorizaId(int jefeAutorizaId) {
        this.jefeAutorizaId = jefeAutorizaId;
    }

    /**
     * Retorna una representación en cadena (String) del objeto AbonoDTO.
     * Incluye los valores de todos los atributos para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto AbonoDTO.
     */
    @Override
    public String toString() {
        return "AbonoDTO{" +
               "id=" + id +
               ", prestamoId=" + prestamoId +
               ", monto=" + monto +
               ", fechaHora=" + fechaHora +
               ", jefeAutorizaId=" + jefeAutorizaId +
               '}';
    }
}
