package Dominio;

/**
 * Representa la entidad de dominio para un Jefe dentro de la organización.
 * Esta clase encapsula la relación entre un ID de jefe y el objeto EmpleadoDominio
 * correspondiente, ya que, según las reglas de negocio, un jefe siempre debe ser un empleado.
 * Proporciona un constructor por defecto y uno parametrizado para su inicialización,
 * métodos de acceso (getters y setters) para manipular sus atributos, y una
 * representación en cadena para facilitar la depuración y el registro.
 *
 * @author Angel Gabriel Beltran Duarte 244865
 */
public class JefeDominio {
    /**
     * Identificador único del jefe. Este ID podría ser el mismo que el ID del empleado
     * si se considera que la entidad Jefe es simplemente un rol adicional de un Empleado.
     */
    private int id;

    /**
     * El objeto EmpleadoDominio que representa a la persona que ocupa el rol de jefe.
     * Según las reglas de negocio, "todos los jefes deben ser empleados".
     */
    private EmpleadoDominio empleado;

    /**
     * Constructor por defecto de la clase JefeDominio.
     * Inicializa una nueva instancia de JefeDominio con valores predeterminados.
     */
    public JefeDominio() {
    }

    /**
     * Constructor parametrizado de la clase JefeDominio.
     * Inicializa un nuevo objeto JefeDominio con sus atributos especificados.
     *
     * @param id El identificador único del jefe.
     * @param empleado El objeto EmpleadoDominio asociado a este jefe.
     */
    public JefeDominio(int id, EmpleadoDominio empleado) {
        this.id = id;
        this.empleado = empleado;
    }

    /**
     * Obtiene el identificador único del jefe.
     *
     * @return El ID del jefe.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del jefe.
     *
     * @param id El nuevo ID del jefe.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el objeto EmpleadoDominio asociado a este jefe.
     *
     * @return El objeto EmpleadoDominio del jefe.
     */
    public EmpleadoDominio getEmpleado() {
        return empleado;
    }

    /**
     * Establece el objeto EmpleadoDominio asociado a este jefe.
     *
     * @param empleado El nuevo objeto EmpleadoDominio del jefe.
     */
    public void setEmpleado(EmpleadoDominio empleado) {
        this.empleado = empleado;
    }

    /**
     * Retorna una representación en cadena (String) del objeto JefeDominio.
     * Incluye los valores de sus atributos para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto JefeDominio.
     */
    @Override
    public String toString() {
        return "JefeDominio{" + "id=" + id + ", empleado=" + empleado + "}";
    }
}
