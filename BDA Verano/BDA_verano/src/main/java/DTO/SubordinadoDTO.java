package DTO;

/**
 * Data Transfer Object (DTO) que representa una **relación de Subordinación**.
 * Esta clase se utiliza para transferir información sobre la jerarquía de un empleado
 * y su jefe directo entre las diferentes capas de la aplicación.
 * A diferencia de la entidad de dominio, este DTO simplifica la representación
 * usando únicamente los identificadores (IDs) del subordinado y de su jefe,
 * lo cual es ideal para la serialización y la comunicación ligera de datos.
 *
 * @author Angel Gabriel Beltran Duarte
 */
public class SubordinadoDTO {
    /**
     * El **identificador único** de esta relación de subordinación.
     */
    private int id;

    /**
     * El **identificador del empleado** que es el subordinado en esta relación.
     */
    private int empleadoId;

    /**
     * El **identificador del jefe** al que reporta directamente este subordinado.
     */
    private int jefeId;

    /**
     * Constructor por defecto de la clase SubordinadoDTO.
     * Permite crear una instancia de SubordinadoDTO sin inicializar sus atributos,
     * los cuales pueden ser establecidos posteriormente mediante los métodos setters.
     */
    public SubordinadoDTO() {}

    /**
     * Constructor parametrizado de la clase SubordinadoDTO.
     * Inicializa una nueva instancia de SubordinadoDTO con los identificadores especificados.
     *
     * @param id El **identificador único** de la relación de subordinación.
     * @param empleadoId El **ID del empleado** que es el subordinado.
     * @param jefeId El **ID del jefe** directo del subordinado.
     */
    public SubordinadoDTO(int id, int empleadoId, int jefeId) {
        this.id = id;
        this.empleadoId = empleadoId;
        this.jefeId = jefeId;
    }

    /**
     * Obtiene el **identificador único** de esta relación de subordinación.
     *
     * @return El **ID de la relación**.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el **identificador único** de esta relación de subordinación.
     *
     * @param id El nuevo **ID de la relación**.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el **identificador del empleado** que es el subordinado.
     *
     * @return El **ID del empleado** subordinado.
     */
    public int getEmpleadoId() {
        return empleadoId;
    }

    /**
     * Establece el **identificador del empleado** que es el subordinado.
     *
     * @param empleadoId El nuevo **ID del empleado** subordinado.
     */
    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    /**
     * Obtiene el **identificador del jefe** al que reporta directamente este subordinado.
     *
     * @return El **ID del jefe** asociado.
     */
    public int getJefeId() {
        return jefeId;
    }

    /**
     * Establece el **identificador del jefe** al que reporta directamente este subordinado.
     *
     * @param jefeId El nuevo **ID del jefe** asociado.
     */
    public void setJefeId(int jefeId) {
        this.jefeId = jefeId;
    }

    /**
     * Retorna una representación en cadena (String) del objeto SubordinadoDTO.
     * Incluye los valores de sus atributos para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto SubordinadoDTO.
     */
    @Override
    public String toString() {
        return "SubordinadoDTO{" +
               "id=" + id +
               ", empleadoId=" + empleadoId +
               ", jefeId=" + jefeId +
               '}';
    }
}
