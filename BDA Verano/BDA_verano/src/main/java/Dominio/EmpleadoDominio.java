package Dominio;

/**
 * Representa la entidad "Empleado" dentro del sistema, con atributos que permiten su identificación y gestión.
 * Incluye métodos de acceso (getters y setters), un constructor y una representación en cadena (toString).
 * @author Jesus Gammael Soto Escalante 248336
 * @author Angel Gabriel Beltran Duarte 244865
 */
public class EmpleadoDominio {
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String usuario;
    private String contraseña;
    private boolean estaActivo;
    
    /**
     * Constructor que inicializa todos los atributos de un EmpleadoDominio.
     * @param id Identificador único del empleado.
     * @param nombre Nombre del empleado.
     * @param apellidoPaterno Apellido paterno del empleado.
     * @param apellidoMaterno Apellido materno del empleado.
     * @param usuario Nombre de usuario del empleado.
     * @param contraseña Clave de acceso del empleado.
     * @param estaActivo Estado del empleado (activo/inactivo).
     */
    public EmpleadoDominio(int id, String nombre, String apellidoPaterno, String apellidoMaterno, String usuario, String contraseña, boolean estaActivo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.estaActivo = estaActivo;
    }

    /**
     * Obtiene el identificador del empleado.
     * @return ID del empleado.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del empleado.
     * @param id Nuevo identificador.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del empleado.
     * @return Nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del empleado.
     * @return Apellido paterno.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del empleado.
     * @param apellidoPaterno Nuevo apellido paterno.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del empleado.
     * @return Apellido materno.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del empleado.
     * @param apellidoMaterno Nuevo apellido materno.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el nombre de usuario del empleado.
     * @return Nombre de usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario del empleado.
     * @param usuario Nuevo nombre de usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la contraseña del empleado.
     * @return Contraseña del empleado.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del empleado.
     * @param contraseña Nueva contraseña.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Verifica si el empleado está activo.
     * @return `true` si está activo, `false` en caso contrario.
     */
    public boolean isEstaActivo() {
        return estaActivo;
    }

    /**
     * Establece el estado del empleado.
     * @param estaActivo Nuevo estado (`true` si activo, `false` si inactivo).
     */
    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    /**
     * Representación en cadena del objeto `EmpleadoDominio`.
     * @return Cadena con información detallada del empleado.
     */
    @Override
    public String toString() {
        return "EmpleadoDominio{" +
               "id=" + id +
               ", nombre='" + nombre + '\'' +
               ", apellidoPaterno='" + apellidoPaterno + '\'' +
               ", apellidoMaterno='" + apellidoMaterno + '\'' +
               ", usuario='" + usuario + '\'' +
               ", contraseña='" + contraseña + '\'' +
               ", estaActivo=" + estaActivo +
               '}';
    }
}
