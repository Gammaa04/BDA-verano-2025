package Dominio;

import DTO.EmpleadoDTO;

/**
 * Representa la entidad de dominio para una Cuenta Bancaria Personal de un Empleado.
 * Esta clase encapsula la información de una cuenta bancaria asociada a un empleado,
 * incluyendo su identificador, el empleado al que pertenece, la CLABE, el banco
 * y su estado actual (activa o inactiva). Proporciona un constructor por defecto
 * y uno parametrizado para su inicialización, métodos de acceso (getters y setters)
 * para manipular sus atributos, y una representación en cadena para facilitar
 * la depuración y el registro.
 *
 * @author Angel Gabriel Beltran Duarte 244865
 */
public class CuentaEmpleadoDominio {
    /**
     * Identificador único de la cuenta bancaria del empleado.
     */
    private int id;

    /**
     * El objeto EmpleadoDominio al que pertenece esta cuenta bancaria.
     */
    private EmpleadoDTO empleado;

    /**
     * La Clave Bancaria Estandarizada (CLABE) de la cuenta bancaria personal.
     */
    private String clabe;

    /**
     * El nombre del banco al que pertenece esta cuenta.
     */
    private String banco;

    /**
     * El estado actual de la cuenta (por ejemplo, activa o inactiva).
     * Se asume que 'EstadoCuenta' es un tipo de enumeración (enum) o una clase definida en el proyecto.
     */
    private EstadoCuenta estado;

    /**
     * Constructor por defecto de la clase CuentaEmpleadoDominio.
     * Inicializa una nueva instancia de CuentaEmpleadoDominio con valores predeterminados.
     */
    public CuentaEmpleadoDominio() {
    }

    /**
     * Constructor parametrizado de la clase CuentaEmpleadoDominio.
     * Inicializa un nuevo objeto CuentaEmpleadoDominio con todos sus atributos especificados.
     *
     * @param id El identificador único de la cuenta.
     * @param empleado El objeto EmpleadoDominio asociado a esta cuenta.
     * @param clabe La CLABE de la cuenta bancaria.
     * @param banco El nombre del banco.
     * @param estado El estado inicial de la cuenta (activa/inactiva).
     */
    public CuentaEmpleadoDominio(int id, EmpleadoDTO empleado, String clabe, String banco, EstadoCuenta estado) {
        this.id = id;
        this.empleado = empleado;
        this.clabe = clabe;
        this.banco = banco;
        this.estado = estado;
    }

    /**
     * Obtiene el identificador único de la cuenta del empleado.
     *
     * @return El ID de la cuenta.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único de la cuenta del empleado.
     *
     * @param id El nuevo ID de la cuenta.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el objeto EmpleadoDominio al que esta cuenta está asociada.
     *
     * @return El empleado asociado a la cuenta.
     */
    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    /**
     * Establece el objeto EmpleadoDominio al que esta cuenta estará asociada.
     *
     * @param empleado El nuevo empleado asociado a la cuenta.
     */
    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    /**
     * Obtiene la Clave Bancaria Estandarizada (CLABE) de la cuenta del empleado.
     *
     * @return La CLABE de la cuenta.
     */
    public String getClabe() {
        return clabe;
    }

    /**
     * Establece la Clave Bancaria Estandarizada (CLABE) de la cuenta del empleado.
     *
     * @param clabe La nueva CLABE de la cuenta.
     */
    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    /**
     * Obtiene el nombre del banco al que pertenece esta cuenta.
     *
     * @return El nombre del banco.
     */
    public String getBanco() {
        return banco;
    }

    /**
     * Establece el nombre del banco al que pertenece esta cuenta.
     *
     * @param banco El nuevo nombre del banco.
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * Obtiene el estado actual de la cuenta del empleado (activa/inactiva).
     *
     * @return El estado de la cuenta.
     */
    public EstadoCuenta getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual de la cuenta del empleado (activa/inactiva).
     *
     * @param estado El nuevo estado de la cuenta.
     */
    public void setEstado(EstadoCuenta estado) {
        this.estado = estado;
    }

    /**
     * Retorna una representación en cadena (String) del objeto CuentaEmpleadoDominio.
     * Incluye los valores de todos los atributos para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto CuentaEmpleadoDominio.
     */
    @Override
    public String toString() {
        return "CuentaEmpleadoDominio{" + "id=" + id + ", empleado=" + empleado + ", clabe=" + clabe + ", banco=" + banco + ", estado=" + estado + "}";
    }
}
