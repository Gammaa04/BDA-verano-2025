package DTO;

/**
 * Data Transfer Object (DTO) que representa un **Tipo de Préstamo**.
 * Esta clase está diseñada para la transferencia de información sobre los distintos
 * tipos de préstamos disponibles entre las capas de la aplicación.
 * Encapsula los atributos esenciales de un tipo de préstamo, como su identificador,
 * nombre descriptivo y el número máximo de parcialidades permitidas, lo que la hace
 * ideal para una comunicación de datos eficiente y ligera.
 *
 * @author Angel Gabriel Beltran Duarte
 */
public class TipoPrestamoDTO {
    /**
     * El **identificador único** del tipo de préstamo.
     */
    private int id;

    /**
     * El **nombre descriptivo** del tipo de préstamo (ej., "Préstamo Personal", "Adelanto de Nómina").
     */
    private String nombre;

    /**
     * El **número máximo de parcialidades** o plazos permitidos para este tipo de préstamo.
     * Un valor de 1 podría indicar un préstamo de pago único.
     */
    private int maxParcialidades;

    /**
     * Constructor por defecto de la clase TipoPrestamoDTO.
     * Permite crear una instancia de TipoPrestamoDTO sin inicializar sus atributos,
     * los cuales pueden ser establecidos posteriormente mediante los métodos setters.
     */
    public TipoPrestamoDTO() {}

    /**
     * Constructor parametrizado de la clase TipoPrestamoDTO.
     * Inicializa una nueva instancia de TipoPrestamoDTO con todos sus atributos especificados.
     *
     * @param id El **identificador único** del tipo de préstamo.
     * @param nombre El **nombre** descriptivo del tipo de préstamo.
     * @param maxParcialidades El **número máximo de parcialidades** permitidas para este tipo.
     */
    public TipoPrestamoDTO(int id, String nombre, int maxParcialidades) {
        this.id = id;
        this.nombre = nombre;
        this.maxParcialidades = maxParcialidades;
    }

    /**
     * Obtiene el **identificador único** del tipo de préstamo.
     *
     * @return El **ID del tipo de préstamo**.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el **identificador único** del tipo de préstamo.
     *
     * @param id El nuevo **ID del tipo de préstamo**.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el **nombre descriptivo** del tipo de préstamo.
     *
     * @return El **nombre del tipo de préstamo**.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el **nombre descriptivo** del tipo de préstamo.
     *
     * @param nombre El nuevo **nombre del tipo de préstamo**.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el **número máximo de parcialidades** permitidas para este tipo de préstamo.
     *
     * @return El **número máximo de parcialidades**.
     */
    public int getMaxParcialidades() {
        return maxParcialidades;
    }

    /**
     * Establece el **número máximo de parcialidades** permitidas para este tipo de préstamo.
     *
     * @param maxParcialidades El nuevo **número máximo de parcialidades**.
     */
    public void setMaxParcialidades(int maxParcialidades) {
        this.maxParcialidades = maxParcialidades;
    }

    /**
     * Retorna una representación en cadena (String) del objeto TipoPrestamoDTO.
     * Incluye los valores de todos los atributos para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto TipoPrestamoDTO.
     */
    @Override
    public String toString() {
        return "TipoPrestamoDTO{" +
               "id=" + id +
               ", nombre='" + nombre + '\'' +
               ", maxParcialidades=" + maxParcialidades +
               '}';
    }
}
