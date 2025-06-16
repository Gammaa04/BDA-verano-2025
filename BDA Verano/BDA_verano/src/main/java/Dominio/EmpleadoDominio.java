package Dominio;

/**
 * Representa la entidad de dominio para un Empleado dentro del sistema.
 * Esta clase encapsula la información detallada de un empleado, incluyendo
 * su identificador, nombre completo, estado (activo/inactivo), credenciales de acceso,
 * departamento al que pertenece y su tipo (por ejemplo, si es un jefe o un empleado regular).
 * Proporciona un constructor por defecto y uno parametrizado para su inicialización,
 * métodos de acceso (getters y setters) para manipular sus atributos, y una
 * representación en cadena para facilitar la depuración y el registro.
 *
 * @author Angel Gabriel Beltran Duarte 244865
 */
public class EmpleadoDominio {

    /**
     * Identificador único del empleado.
     */
    private int id;

    /**
     * Nombre(s) del empleado.
     */
    private String nombre;

    /**
     * Apellido paterno del empleado.
     */
    private String ap_paterno;

    /**
     * Apellido materno del empleado.
     */
    private String ap_materno;

    /**
     * El estado actual del empleado (por ejemplo, activo o inactivo).
     * Se asume que 'EstadoEmpleado' es un tipo de enumeración (enum) o una clase definida en el proyecto.
     */
    private EstadoEmpleado estado;

    /**
     * Nombre de usuario del empleado para el acceso al sistema.
     */
    private String usuario;

    /**
     * Contraseña del empleado para el acceso al sistema.
     */
    private String contrasena;

    /**
     * El objeto DepartamentoDominio al que el empleado pertenece.
     */
    private DepartamentoDominio departamento;

    /**
     * El tipo de empleado (por ejemplo, empleado regular, jefe).
     * Se asume que 'TipoEmpleado' es un tipo de enumeración (enum) o una clase definida en el proyecto.
     */
    private TipoEmpleado tipo;

    /**
     * Constructor por defecto de la clase EmpleadoDominio.
     * Inicializa una nueva instancia de EmpleadoDominio con valores predeterminados.
     */
    public EmpleadoDominio() {
    }

    /**
     * Constructor parametrizado de la clase EmpleadoDominio.
     * Inicializa un nuevo objeto EmpleadoDominio con todos sus atributos especificados.
     *
     * @param id El identificador único del empleado.
     * @param nombre El(los) nombre(s) del empleado.
     * @param ap_paterno El apellido paterno del empleado.
     * @param ap_materno El apellido materno del empleado.
     * @param estado El estado actual del empleado (activo/inactivo).
     * @param usuario El nombre de usuario para el acceso.
     * @param contrasena La contraseña del usuario.
     * @param departamento El departamento al que pertenece el empleado.
     * @param tipo El tipo de empleado (e.g., regular, jefe).
     */
    public EmpleadoDominio(int id, String nombre, String ap_paterno, String ap_materno, EstadoEmpleado estado, String usuario, String contrasena, DepartamentoDominio departamento, TipoEmpleado tipo) {
        this.id = id;
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.estado = estado;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.departamento = departamento;
        this.tipo = tipo;
    }

    /**
     * Obtiene el apellido paterno del empleado.
     *
     * @return El apellido paterno.
     */
    public String getAp_paterno() {
        return ap_paterno;
    }

    /**
     * Establece el apellido paterno del empleado.
     *
     * @param ap_paterno El nuevo apellido paterno.
     */
    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    /**
     * Obtiene el apellido materno del empleado.
     *
     * @return El apellido materno.
     */
    public String getAp_materno() {
        return ap_materno;
    }

    /**
     * Establece el apellido materno del empleado.
     *
     * @param ap_materno El nuevo apellido materno.
     */
    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    /**
     * Obtiene el identificador único del empleado.
     *
     * @return El ID del empleado.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del empleado.
     *
     * @param id El nuevo ID del empleado.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre El nuevo nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el estado actual del empleado.
     *
     * @return El estado del empleado.
     */
    public EstadoEmpleado getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual del empleado.
     *
     * @param estado El nuevo estado del empleado.
     */
    public void setEstado(EstadoEmpleado estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el nombre de usuario del empleado para el acceso al sistema.
     *
     * @return El nombre de usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario del empleado para el acceso al sistema.
     *
     * @param usuario El nuevo nombre de usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la contraseña del empleado para el acceso al sistema.
     *
     * @return La contraseña.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del empleado para el acceso al sistema.
     *
     * @param contrasena La nueva contraseña.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el objeto DepartamentoDominio al que el empleado pertenece.
     *
     * @return El departamento del empleado.
     */
    public DepartamentoDominio getDepartamento() {
        return departamento;
    }

    /**
     * Establece el objeto DepartamentoDominio al que el empleado pertenece.
     *
     * @param departamento El nuevo departamento del empleado.
     */
    public void setDepartamento(DepartamentoDominio departamento) {
        this.departamento = departamento;
    }

    /**
     * Obtiene el tipo de empleado (por ejemplo, empleado regular, jefe).
     *
     * @return El tipo de empleado.
     */
    public TipoEmpleado getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de empleado (por ejemplo, empleado regular, jefe).
     *
     * @param tipo El nuevo tipo de empleado.
     */
    public void setTipo(TipoEmpleado tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna una representación en cadena (String) del objeto EmpleadoDominio.
     * Incluye los valores de sus atributos clave para facilitar la depuración y el registro.
     * No incluye apellidos paterno y materno en el `toString` por defecto, pero se pueden añadir si es necesario para una depuración más exhaustiva.
     *
     * @return Una cadena que representa el estado del objeto EmpleadoDominio.
     */
    @Override
    public String toString() {
        return "EmpleadoDominio{" + "id=" + id + ", nombre=" + nombre + ", estado=" + estado + ", usuario=" + usuario + ", contrasena=" + contrasena + ", departamento=" + departamento + ", tipo=" + tipo + "}";
    }
}