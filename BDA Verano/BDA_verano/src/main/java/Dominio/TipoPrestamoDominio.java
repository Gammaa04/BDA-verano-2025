package Dominio;

/**
 * Representa la entidad de dominio para un Tipo de Préstamo.
 * Esta clase define las características específicas de los diferentes tipos de préstamos
 * que la empresa Finanzas Globales puede otorgar, incluyendo su identificador único,
 * un nombre descriptivo y la cantidad máxima de parcialidades permitidas para ese tipo.
 * Proporciona un constructor por defecto y uno parametrizado para su inicialización,
 * métodos de acceso (getters y setters) para manipular sus atributos, y una
 * representación en cadena para facilitar la depuración y el registro.
 *
 * @author Angel Gabriel Beltran Duarte 244865
 */
public class TipoPrestamoDominio {
    /**
     * Identificador único del tipo de préstamo.
     */
    private int id;

    /**
     * Nombre descriptivo del tipo de préstamo (ej. "Préstamo de nómina", "Préstamo hipotecario").
     */
    private String nombre;

    /**
     * Cantidad máxima de parcialidades permitidas para este tipo de préstamo.
     * Si el préstamo es de un solo pago, este valor podría ser 1.
     */
    private int maxParcialidades;

    /**
     * Constructor por defecto de la clase TipoPrestamoDominio.
     * Inicializa una nueva instancia de TipoPrestamoDominio con valores predeterminados.
     */
    public TipoPrestamoDominio() {
    }

    /**
     * Constructor parametrizado de la clase TipoPrestamoDominio.
     * Inicializa un nuevo objeto TipoPrestamoDominio con todos sus atributos especificados.
     *
     * @param id El identificador único del tipo de préstamo.
     * @param nombre El nombre descriptivo del tipo de préstamo.
     * @param maxParcialidades La cantidad máxima de parcialidades permitidas.
     */
    public TipoPrestamoDominio(int id, String nombre, int maxParcialidades) {
        this.id = id;
        this.nombre = nombre;
        this.maxParcialidades = maxParcialidades;
    }

    /**
     * Obtiene el identificador único del tipo de préstamo.
     *
     * @return El ID del tipo de préstamo.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del tipo de préstamo.
     *
     * @param id El nuevo ID del tipo de préstamo.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre descriptivo del tipo de préstamo.
     *
     * @return El nombre del tipo de préstamo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre descriptivo del tipo de préstamo.
     *
     * @param nombre El nuevo nombre del tipo de préstamo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la cantidad máxima de parcialidades permitidas para este tipo de préstamo.
     *
     * @return El número máximo de parcialidades.
     */
    public int getMaxParcialidades() {
        return maxParcialidades;
    }

    /**
     * Establece la cantidad máxima de parcialidades permitidas para este tipo de préstamo.
     *
     * @param maxParcialidades La nueva cantidad máxima de parcialidades.
     */
    public void setMaxParcialidades(int maxParcialidades) {
        this.maxParcialidades = maxParcialidades;
    }

    /**
     * Retorna una representación en cadena (String) del objeto TipoPrestamoDominio.
     * Incluye los valores de todos los atributos para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto TipoPrestamoDominio.
     */
    @Override
    public String toString() {
        return "TipoPrestamoDominio{" + "id=" + id + ", nombre=" + nombre + ", maxParcialidades=" + maxParcialidades + "}";
    }
}
