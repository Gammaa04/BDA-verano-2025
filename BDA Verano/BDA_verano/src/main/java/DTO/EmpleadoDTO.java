package DTO;

import Dominio.EstadoEmpleado;
import Dominio.TipoEmpleado;

/**
 * Data Transfer Object (DTO) que representa la información de un **Empleado**.
 * Esta clase está diseñada para la transferencia de datos de empleados entre
 * las distintas capas de la aplicación. Contiene los atributos clave de un empleado,
 * incluyendo sus datos personales, credenciales de usuario, estado, y las referencias
 * a su departamento y tipo de empleado mediante sus respectivos identificadores
 * o enumeraciones. Su propósito es simplificar la comunicación de datos y evitar
 * la exposición de entidades de dominio completas.
 *
 * @author Angel Gabriel Beltran Duarte
 */
public class EmpleadoDTO {

    /**
     * El **identificador único** del empleado.
     */
    private int id;

    /**
     * El **nombre(s)** del empleado.
     */
    private String nombre;

    /**
     * El **apellido paterno** del empleado.
     */
    private String ap_paterno;

    /**
     * El **apellido materno** del empleado.
     */
    private String ap_materno;

    /**
     * El **estado actual** del empleado (por ejemplo, activo o inactivo).
     * Se asume que 'EstadoEmpleado' es una enumeración (enum) o una clase definida en el paquete Dominio.
     */
    private EstadoEmpleado estado;

    /**
     * El **nombre de usuario** del empleado para el acceso al sistema.
     */
    private String usuario;

    /**
     * El **identificador único del departamento** al que pertenece el empleado.
     */
    private int departamentoId;

    /**
     * El **tipo de empleado** (por ejemplo, regular o jefe).
     * Se asume que 'TipoEmpleado' es una enumeración (enum) o una clase definida en el paquete Dominio.
     */
    private TipoEmpleado tipo;

    /**
     * Constructor por defecto de la clase EmpleadoDTO.
     * Permite crear una instancia de EmpleadoDTO sin inicializar sus atributos,
     * los cuales pueden ser establecidos posteriormente mediante los métodos setters.
     */
    public EmpleadoDTO() {
    }

    /**
     * Constructor parametrizado de la clase EmpleadoDTO.
     * Inicializa una nueva instancia de EmpleadoDTO con todos los atributos especificados.
     *
     * @param id El **identificador único** del empleado.
     * @param nombre El **nombre(s)** del empleado.
     * @param ap_paterno El **apellido paterno** del empleado.
     * @param ap_materno El **apellido materno** del empleado.
     * @param estado El **estado actual** del empleado (activo/inactivo).
     * @param usuario El **nombre de usuario** para el acceso.
     * @param departamentoId El **ID del departamento** al que pertenece.
     * @param tipo El **tipo** de empleado (ej. regular, jefe).
     */
    public EmpleadoDTO(int id, String nombre, String ap_paterno, String ap_materno, EstadoEmpleado estado, String usuario, int departamentoId, TipoEmpleado tipo) {
        this.id = id;
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.estado = estado;
        this.usuario = usuario;
        this.departamentoId = departamentoId;
        this.tipo = tipo;
    }

    /**
     * Obtiene el **apellido paterno** del empleado.
     *
     * @return El apellido paterno.
     */
    public String getAp_paterno() {
        return ap_paterno;
    }

    /**
     * Establece el **apellido paterno** del empleado.
     *
     * @param ap_paterno El nuevo apellido paterno.
     */
    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    /**
     * Obtiene el **apellido materno** del empleado.
     *
     * @return El apellido materno.
     */
    public String getAp_materno() {
        return ap_materno;
    }

    /**
     * Establece el **apellido materno** del empleado.
     *
     * @param ap_materno El nuevo apellido materno.
     */
    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    /**
     * Obtiene el **identificador único** del empleado.
     *
     * @return El ID del empleado.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el **identificador único** del empleado.
     *
     * @param id El nuevo ID del empleado.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el **nombre(s)** del empleado.
     *
     * @return El nombre(s) del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el **nombre(s)** del empleado.
     *
     * @param nombre El nuevo nombre(s) del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el **estado** actual del empleado.
     *
     * @return El estado del empleado.
     */
    public EstadoEmpleado getEstado() {
        return estado;
    }

    /**
     * Establece el **estado** del empleado.
     *
     * @param estado El nuevo estado del empleado.
     */
    public void setEstado(EstadoEmpleado estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el **nombre de usuario** del empleado.
     *
     * @return El nombre de usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el **nombre de usuario** del empleado.
     *
     * @param usuario El nuevo nombre de usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el **identificador del departamento** al que pertenece el empleado.
     *
     * @return El ID del departamento.
     */
    public int getDepartamentoId() {
        return departamentoId;
    }

    /**
     * Establece el **identificador del departamento** al que pertenece el empleado.
     *
     * @param departamentoId El nuevo ID del departamento.
     */
    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    /**
     * Obtiene el **tipo de empleado**.
     *
     * @return El tipo de empleado.
     */
    public TipoEmpleado getTipo() {
        return tipo;
    }

    /**
     * Establece el **tipo de empleado**.
     *
     * @param tipo El nuevo tipo de empleado.
     */
    public void setTipo(TipoEmpleado tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna una representación en cadena (String) del objeto EmpleadoDTO.
     * Incluye los valores de sus atributos clave para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto EmpleadoDTO.
     */
    @Override
    public String toString() {
        return "EmpleadoDTO{" +
               "id=" + id +
               ", nombre='" + nombre + '\'' +
               ", ap_paterno='" + ap_paterno + '\'' +
               ", ap_materno='" + ap_materno + '\'' +
               ", estado=" + estado +
               ", usuario='" + usuario + '\'' +
               ", departamentoId=" + departamentoId +
               ", tipo=" + tipo +
               '}';
    }
}
