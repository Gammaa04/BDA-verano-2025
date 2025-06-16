package DTO;

/**
 * Data Transfer Object (DTO) que representa una Cuenta de Departamento.
 * Esta clase se utiliza para transferir datos de las cuentas bancarias asociadas a los
 * departamentos entre las diferentes capas de la aplicación.
 * A diferencia de la entidad de dominio, esta DTO utiliza el identificador (ID)
 * del departamento para establecer la relación, simplificando la serialización
 * y deserialización de datos.
 *
 * @author Angel Gabriel Beltran Duarte
 */
public class CuentaDepartamentoDTO {
    /**
     * El identificador único de la cuenta de departamento.
     */
    private int id;

    /**
     * El identificador del departamento al que esta cuenta está asociada.
     */
    private int departamentoId;

    /**
     * La Clave Bancaria Estandarizada (CLABE) de la cuenta bancaria.
     */
    private String clabe;

    /**
     * El nombre del banco al que pertenece esta cuenta.
     */
    private String banco;

    /**
     * El saldo actual de la cuenta del departamento.
     */
    private double saldo;

    /**
     * Constructor por defecto de la clase CuentaDepartamentoDTO.
     * Permite crear una instancia de CuentaDepartamentoDTO sin inicializar sus atributos,
     * los cuales pueden ser establecidos posteriormente mediante los métodos setters.
     */
    public CuentaDepartamentoDTO() {
    }

    /**
     * Constructor parametrizado de la clase CuentaDepartamentoDTO.
     * Inicializa una nueva instancia de CuentaDepartamentoDTO con todos los atributos especificados.
     *
     * @param id El identificador único de la cuenta.
     * @param departamentoId El ID del departamento al que esta cuenta está asociada.
     * @param clabe La CLABE de la cuenta.
     * @param banco El nombre del banco.
     * @param saldo El saldo actual de la cuenta.
     */
    public CuentaDepartamentoDTO(int id, int departamentoId, String clabe, String banco, double saldo) {
        this.id = id;
        this.departamentoId = departamentoId;
        this.clabe = clabe;
        this.banco = banco;
        this.saldo = saldo;
    }

    /**
     * Obtiene el identificador único de la cuenta de departamento.
     *
     * @return El ID de la cuenta.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único de la cuenta de departamento.
     *
     * @param id El nuevo ID de la cuenta.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador del departamento al que esta cuenta está asociada.
     *
     * @return El ID del departamento asociado a la cuenta.
     */
    public int getDepartamentoId() {
        return departamentoId;
    }

    /**
     * Establece el identificador del departamento al que esta cuenta estará asociada.
     *
     * @param departamentoId El nuevo ID del departamento asociado a la cuenta.
     */
    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    /**
     * Obtiene la Clave Bancaria Estandarizada (CLABE) de la cuenta.
     *
     * @return La CLABE de la cuenta.
     */
    public String getClabe() {
        return clabe;
    }

    /**
     * Establece la Clave Bancaria Estandarizada (CLABE) de la cuenta.
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
     * Obtiene el saldo actual de la cuenta del departamento.
     *
     * @return El saldo de la cuenta.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo actual de la cuenta del departamento.
     *
     * @param saldo El nuevo saldo de la cuenta.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Retorna una representación en cadena (String) del objeto CuentaDepartamentoDTO.
     * Incluye los valores de todos los atributos para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto CuentaDepartamentoDTO.
     */
    @Override
    public String toString() {
        return "CuentaDepartamentoDTO{" +
               "id=" + id +
               ", departamentoId=" + departamentoId +
               ", clabe=" + clabe +
               ", banco=" + banco +
               ", saldo=" + saldo +
               '}';
    }
}
