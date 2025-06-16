package DTO;

/**
 * Data Transfer Object (DTO) que representa un Departamento.
 * Esta clase se utiliza para transferir datos básicos de un departamento
 * entre las diferentes capas de la aplicación. Su objetivo principal es
 * proporcionar una representación ligera y serializable de la información
 * esencial del departamento (ID y nombre) para la comunicación entre servicios
 * o la capa de presentación.
 *
 * @author Angel Gabriel Beltran Duarte
 */
public class DepartamentoDTO {
    /**
     * El **identificador único** del departamento.
     */
    private int id;

    /**
     * El **nombre descriptivo** del departamento.
     */
    private String nombre;

    /**
     * Constructor por defecto de la clase DepartamentoDTO.
     * Permite crear una instancia de DepartamentoDTO sin inicializar sus atributos,
     * los cuales pueden ser establecidos posteriormente mediante los métodos setters.
     */
    public DepartamentoDTO() {
    }

    /**
     * Constructor parametrizado de la clase DepartamentoDTO.
     * Inicializa una nueva instancia de DepartamentoDTO con todos los atributos especificados.
     *
     * @param id El **identificador único** del departamento.
     * @param nombre El **nombre** del departamento.
     */
    public DepartamentoDTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Obtiene el **identificador único** del departamento.
     *
     * @return El **ID del departamento**.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el **identificador único** del departamento.
     *
     * @param id El nuevo **ID del departamento**.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el **nombre** del departamento.
     *
     * @return El **nombre del departamento**.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el **nombre** del departamento.
     *
     * @param nombre El nuevo **nombre del departamento**.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna una representación en cadena (String) del objeto DepartamentoDTO.
     * Incluye los valores de sus atributos para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto DepartamentoDTO.
     */
    @Override
    public String toString() {
        return "DepartamentoDTO{" +
               "id=" + id +
               ", nombre=" + nombre +
               '}';
    }
}
