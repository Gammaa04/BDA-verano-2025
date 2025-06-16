package Dominio;

/**
 * Representa la entidad de dominio para un Subordinado, estableciendo la relación
 * jerárquica entre un empleado y su jefe directo. Esta clase encapsula el identificador
 * de la relación, el objeto EmpleadoDominio que actúa como subordinado, y el
 * objeto JefeDominio al que reporta.
 * Proporciona un constructor por defecto y uno parametrizado para su inicialización,
 * métodos de acceso (getters y setters) para manipular sus atributos, y una
 * representación en cadena para facilitar la depuración y el registro.
 *
 * @author Angel Gabriel Beltran Duarte 244865
 */
public class SubordinadoDominio {
    /**
     * Identificador único de la relación de subordinación.
     */
    private int id;

    /**
     * El objeto EmpleadoDominio que representa al empleado en el rol de subordinado.
     * Según las reglas de negocio, "cada empleado solo debe tener un jefe directo".
     */
    private EmpleadoDominio empleado;

    /**
     * El objeto JefeDominio al que este empleado subordinado reporta directamente.
     * Según las reglas de negocio, "cada empleado solo debe tener un jefe directo".
     */
    private JefeDominio jefe;

    /**
     * Constructor por defecto de la clase SubordinadoDominio.
     * Inicializa una nueva instancia de SubordinadoDominio con valores predeterminados.
     */
    public SubordinadoDominio() {
    }

    /**
     * Constructor parametrizado de la clase SubordinadoDominio.
     * Inicializa un nuevo objeto SubordinadoDominio con sus atributos especificados.
     *
     * @param id El identificador único de la relación de subordinación.
     * @param empleado El objeto EmpleadoDominio que es el subordinado.
     * @param jefe El objeto JefeDominio que es el jefe directo del subordinado.
     */
    public SubordinadoDominio(int id, EmpleadoDominio empleado, JefeDominio jefe) {
        this.id = id;
        this.empleado = empleado;
        this.jefe = jefe;
    }

    /**
     * Obtiene el identificador único de la relación de subordinación.
     *
     * @return El ID de la relación de subordinación.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único de la relación de subordinación.
     *
     * @param id El nuevo ID de la relación de subordinación.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el objeto EmpleadoDominio que representa al subordinado.
     *
     * @return El objeto EmpleadoDominio que es el subordinado.
     */
    public EmpleadoDominio getEmpleado() {
        return empleado;
    }

    /**
     * Establece el objeto EmpleadoDominio que representa al subordinado.
     *
     * @param empleado El nuevo objeto EmpleadoDominio que es el subordinado.
     */
    public void setEmpleado(EmpleadoDominio empleado) {
        this.empleado = empleado;
    }

    /**
     * Obtiene el objeto JefeDominio al que este empleado subordinado reporta directamente.
     *
     * @return El objeto JefeDominio que es el jefe directo.
     */
    public JefeDominio getJefe() {
        return jefe;
    }

    /**
     * Establece el objeto JefeDominio al que este empleado subordinado reporta directamente.
     *
     * @param jefe El nuevo objeto JefeDominio que es el jefe directo.
     */
    public void setJefe(JefeDominio jefe) {
        this.jefe = jefe;
    }

    /**
     * Retorna una representación en cadena (String) del objeto SubordinadoDominio.
     * Incluye los valores de sus atributos para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto SubordinadoDominio.
     */
    @Override
    public String toString() {
        return "SubordinadoDominio{" + "id=" + id + ", empleado=" + empleado + ", jefe=" + jefe + "}";
    }
}
