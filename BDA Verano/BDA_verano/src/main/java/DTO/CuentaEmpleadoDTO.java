package DTO;

import Dominio.EstadoCuenta;

/**
 * Data Transfer Object (DTO) que representa una Cuenta Bancaria Personal de un Empleado.
 * Esta clase se utiliza para transferir datos relacionados con la cuenta bancaria personal de un empleado
 * entre las diferentes capas de la aplicación. A diferencia de la entidad de dominio,
 * este DTO representa al empleado asociado mediante su identificador (ID) para simplificar
 * la serialización y deserialización de datos, y para evitar grafos de objetos innecesarios.
 *
 * @author Angel Gabriel Beltran Duarte
 */
public class CuentaEmpleadoDTO {
    /**
     * El **identificador único** de la cuenta del empleado.
     */
    private int id;

    /**
     * El **identificador del empleado** al que pertenece esta cuenta bancaria.
     */
    private int empleadoId;

    /**
     * La **Clave Bancaria Estandarizada (CLABE)** de la cuenta bancaria personal.
     */
    private String clabe;

    /**
     * El **nombre del banco** donde se encuentra esta cuenta.
     */
    private String banco;

    /**
     * El **estado actual de la cuenta** (por ejemplo, activa o inactiva).
     * Se asume que 'EstadoCuenta' es una enumeración (enum) o una clase
     * definida dentro del paquete Dominio.
     */
    private EstadoCuenta estado;

    /**
     * Constructor por defecto de la clase CuentaEmpleadoDTO.
     * Permite crear una instancia de CuentaEmpleadoDTO sin inicializar sus atributos,
     * los cuales pueden ser establecidos posteriormente mediante los métodos setters.
     */
    public CuentaEmpleadoDTO() {
    }

    /**
     * Constructor parametrizado de la clase CuentaEmpleadoDTO.
     * Inicializa una nueva instancia de CuentaEmpleadoDTO con todos los atributos especificados.
     *
     * @param id El **identificador único** de la cuenta.
     * @param empleadoId El **ID del empleado** asociado a esta cuenta.
     * @param clabe La **CLABE** de la cuenta bancaria.
     * @param banco El **nombre del banco**.
     * @param estado El **estado inicial** de la cuenta (activa/inactiva).
     */
    public CuentaEmpleadoDTO(int id, int empleadoId, String clabe, String banco, EstadoCuenta estado) {
        this.id = id;
        this.empleadoId = empleadoId;
        this.clabe = clabe;
        this.banco = banco;
        this.estado = estado;
    }

    /**
     * Obtiene el **identificador único** de la cuenta del empleado.
     *
     * @return El **ID de la cuenta**.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el **identificador único** para la cuenta del empleado.
     *
     * @param id El nuevo **ID para la cuenta**.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el **identificador del empleado** al que pertenece esta cuenta.
     *
     * @return El **ID del empleado** asociado.
     */
    public int getEmpleadoId() {
        return empleadoId;
    }

    /**
     * Establece el **identificador del empleado** al que pertenece esta cuenta.
     *
     * @param empleadoId El nuevo **ID del empleado** asociado.
     */
    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    /**
     * Obtiene la **CLABE** (Clave Bancaria Estandarizada) de la cuenta.
     *
     * @return La **CLABE de la cuenta**.
     */
    public String getClabe() {
        return clabe;
    }

    /**
     * Establece la **CLABE** (Clave Bancaria Estandarizada) de la cuenta.
     *
     * @param clabe La nueva **CLABE de la cuenta**.
     */
    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    /**
     * Obtiene el **nombre del banco** donde se encuentra esta cuenta.
     *
     * @return El **nombre del banco**.
     */
    public String getBanco() {
        return banco;
    }

    /**
     * Establece el **nombre del banco** donde se encuentra esta cuenta.
     *
     * @param banco El nuevo **nombre del banco**.
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * Obtiene el **estado actual** de la cuenta del empleado.
     *
     * @return El **estado de la cuenta**.
     */
    public EstadoCuenta getEstado() {
        return estado;
    }

    /**
     * Establece el **estado actual** de la cuenta del empleado.
     *
     * @param estado El nuevo **estado de la cuenta**.
     */
    public void setEstado(EstadoCuenta estado) {
        this.estado = estado;
    }

    /**
     * Retorna una representación en cadena (String) del objeto CuentaEmpleadoDTO.
     * Incluye los valores de todos los atributos para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto CuentaEmpleadoDTO.
     */
    @Override
    public String toString() {
        return "CuentaEmpleadoDTO{" +
               "id=" + id +
               ", empleadoId=" + empleadoId +
               ", clabe=" + clabe +
               ", banco=" + banco +
               ", estado=" + estado +
               '}';
    }
}