package Dominio;

import java.time.LocalDateTime;

/**
 * Representa la entidad de dominio para un Abono realizado a un préstamo.
 * Esta clase define las propiedades, el constructor por defecto y parametrizado,
 * así como los métodos de acceso (getters y setters) y una representación
 * en cadena del objeto (toString()).
 *
 * @author Angel Gabriel Beltran Duarte 244865
 */
public class AbonoDominio {

    /**
     * Identificador único del abono.
     */
    private int id;

    /**
     * El préstamo al que este abono está asociado.
     */
    private PrestamoDominio prestamo;

    /**
     * El monto monetario del abono realizado.
     */
    private double monto;

    /**
     * La fecha y hora exacta en que se realizó el abono.
     */
    private LocalDateTime fechaHora;

    /**
     * El jefe que autorizó o procesó este abono.
     */
    private JefeDominio jefeAutoriza;

    /**
     * Constructor por defecto de la clase AbonoDominio.
     * Inicializa un nuevo objeto AbonoDominio con valores predeterminados.
     */
    public AbonoDominio() {
    }

    /**
     * Constructor parametrizado de la clase AbonoDominio.
     * Inicializa un nuevo objeto AbonoDominio con todos sus atributos especificados.
     *
     * @param id El identificador único del abono.
     * @param prestamo El objeto PrestamoDominio al que este abono está vinculado.
     * @param monto El monto monetario del abono.
     * @param fechaHora La fecha y hora en que se realizó el abono.
     * @param jefeAutoriza El objeto JefeDominio que autorizó este abono.
     */
    public AbonoDominio(int id, PrestamoDominio prestamo, double monto, LocalDateTime fechaHora, JefeDominio jefeAutoriza) {
        this.id = id;
        this.prestamo = prestamo;
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.jefeAutoriza = jefeAutoriza;
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
     * Obtiene el objeto PrestamoDominio al que este abono está asociado.
     *
     * @return El préstamo asociado.
     */
    public PrestamoDominio getPrestamo() {
        return prestamo;
    }

    /**
     * Establece el objeto PrestamoDominio al que este abono estará asociado.
     *
     * @param prestamo El nuevo préstamo asociado.
     */
    public void setPrestamo(PrestamoDominio prestamo) {
        this.prestamo = prestamo;
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
     * Obtiene el objeto JefeDominio que autorizó o procesó este abono.
     *
     * @return El jefe que autorizó el abono.
     */
    public JefeDominio getJefeAutoriza() {
        return jefeAutoriza;
    }

    /**
     * Establece el objeto JefeDominio que autorizó o procesó este abono.
     *
     * @param jefeAutoriza El nuevo jefe que autorizó el abono.
     */
    public void setJefeAutoriza(JefeDominio jefeAutoriza) {
        this.jefeAutoriza = jefeAutoriza;
    }

    /**
     * Retorna una representación en cadena del objeto AbonoDominio.
     * Incluye los valores de todos los atributos para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto AbonoDominio.
     */
    @Override
    public String toString() {
        return "AbonoDominio{" + "id=" + id + ", prestamo=" + prestamo + ", monto=" + monto + ", fechaHora=" + fechaHora + ", jefeAutoriza=" + jefeAutoriza + "}";
    }
}