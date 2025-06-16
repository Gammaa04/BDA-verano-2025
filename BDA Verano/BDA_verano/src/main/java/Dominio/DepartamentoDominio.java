package Dominio;

/**
 * Representa la entidad de dominio para un Departamento dentro de la organización.
 * Esta clase encapsula la información fundamental de un departamento, incluyendo
 * su identificador único y su nombre. Proporciona un constructor por defecto
 * y uno parametrizado para su inicialización, métodos de acceso (getters y setters)
 * para manipular sus atributos, y una representación en cadena para facilitar
 * la depuración y el registro.
 *
 * @author Angel Gabriel Beltran Duarte 244865
 */
public class DepartamentoDominio {
    /**
     * Identificador único del departamento.
     */
    private int id;

    /**
     * Nombre descriptivo del departamento.
     */
    private String nombre;

    /**
     * Constructor por defecto de la clase DepartamentoDominio.
     * Inicializa una nueva instancia de DepartamentoDominio con valores predeterminados.
     */
    public DepartamentoDominio() {
    }

    /**
     * Constructor parametrizado de la clase DepartamentoDominio.
     * Inicializa un nuevo objeto DepartamentoDominio con todos sus atributos especificados.
     *
     * @param id El identificador único del departamento.
     * @param nombre El nombre del departamento.
     */
    public DepartamentoDominio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador único del departamento.
     *
     * @return El ID del departamento.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del departamento.
     *
     * @param id El nuevo ID del departamento.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del departamento.
     *
     * @return El nombre del departamento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del departamento.
     *
     * @param nombre El nuevo nombre del departamento.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna una representación en cadena (String) del objeto DepartamentoDominio.
     * Incluye los valores de todos los atributos para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto DepartamentoDominio.
     */
    @Override
    public String toString() {
        return "DepartamentoDominio{" + "id=" + id + ", nombre=" + nombre + "}";
    }
}
