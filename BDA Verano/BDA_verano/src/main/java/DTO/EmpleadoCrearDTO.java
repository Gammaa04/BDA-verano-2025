package DTO;

import Dominio.EstadoEmpleado;
import Dominio.TipoEmpleado;

/**
 * Data Transfer Object (DTO) diseñado específicamente para la **creación de un nuevo Empleado**.
 * Esta clase se utiliza para encapsular y transferir los datos necesarios desde la capa
 * de presentación o la solicitud de entrada hacia la capa de negocio o de persistencia
 * cuando se registra un nuevo empleado en el sistema. Contiene los atributos requeridos
 * para la creación, representando las relaciones con otras entidades (como el departamento)
 * mediante sus identificadores (IDs) para mantener la ligereza del DTO.
 *
 * @author Angel Gabriel Beltran Duarte 244865
 */
public class EmpleadoCrearDTO {

    /**
     * El **nombre completo** del empleado que se va a crear.
     * Este campo puede concatenar nombre(s) y apellidos según el formato deseado.
     */
    private String nombreCompleto;

    /**
     * El **estado inicial** del empleado (por ejemplo, activo o inactivo) al momento de su creación.
     * Se asume que 'EstadoEmpleado' es una enumeración (enum) o una clase definida en el paquete Dominio.
     */
    private EstadoEmpleado estado;

    /**
     * El **nombre de usuario** que el empleado utilizará para iniciar sesión en el sistema.
     * Debe ser único.
     */
    private String usuario;

    /**
     * El **identificador único del departamento** al que pertenecerá el nuevo empleado.
     */
    private int departamentoId;

    /**
     * La **contraseña** inicial para el nuevo usuario.
     * Es crucial manejar esta información de forma segura (ej. cifrado) en el flujo de la aplicación.
     */
    private String contrasena;

    /**
     * El **tipo de empleado** (por ejemplo, regular o jefe) que se asignará al nuevo registro.
     * Se asume que 'TipoEmpleado' es una enumeración (enum) o una clase definida en el paquete Dominio.
     */
    private TipoEmpleado tipo;

    /**
     * Constructor por defecto de la clase EmpleadoCrearDTO.
     * Permite crear una instancia vacía de EmpleadoCrearDTO. Los atributos
     * pueden ser establecidos posteriormente utilizando sus respectivos métodos `set`.
     */
    public EmpleadoCrearDTO() {
    }

    /**
     * Constructor parametrizado de la clase EmpleadoCrearDTO.
     * Inicializa una nueva instancia de EmpleadoCrearDTO con todos los atributos necesarios
     * para la creación de un empleado.
     *
     * @param nombreCompleto El **nombre completo** del empleado.
     * @param estado El **estado inicial** del empleado (activo/inactivo).
     * @param usuario El **nombre de usuario** para el acceso.
     * @param departamentoId El **ID del departamento** al que pertenecerá.
     * @param contrasena La **contraseña inicial** del empleado.
     * @param tipo El **tipo** de empleado (ej. regular, jefe).
     */
    public EmpleadoCrearDTO(String nombreCompleto, EstadoEmpleado estado, String usuario, int departamentoId, String contrasena, TipoEmpleado tipo) {
        this.nombreCompleto = nombreCompleto;
        this.estado = estado;
        this.usuario = usuario;
        this.contrasena = contrasena; // La contraseña se asigna aquí
        this.departamentoId = departamentoId;
        this.tipo = tipo;
    }

    /**
     * Obtiene el **nombre completo** del empleado.
     *
     * @return El nombre completo del empleado.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el **nombre completo** del empleado.
     *
     * @param nombreCompleto El nuevo nombre completo del empleado.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
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
     * Obtiene la **contraseña** del empleado.
     *
     * @return La contraseña del empleado.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la **contraseña** del empleado.
     *
     * @param contrasena La nueva contraseña del empleado.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Retorna una representación en cadena (String) del objeto EmpleadoCrearDTO.
     * Incluye los valores de sus atributos para facilitar la depuración y el registro,
     * excluyendo la contraseña por razones de seguridad.
     *
     * @return Una cadena que representa el estado del objeto EmpleadoCrearDTO.
     */
    @Override
    public String toString() {
        return "EmpleadoCrearDTO{" +
               "nombreCompleto='" + nombreCompleto + '\'' +
               ", estado=" + estado +
               ", usuario='" + usuario + '\'' +
               ", departamentoId=" + departamentoId +
               ", tipo=" + tipo +
               '}';
    }
}
