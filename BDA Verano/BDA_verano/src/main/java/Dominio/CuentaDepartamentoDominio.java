package Dominio;

/**
 * Representa la entidad de dominio para una Cuenta de Departamento.
 * Esta clase define las propiedades clave de una cuenta bancaria asociada a un departamento,
 * incluyendo su identificador, el departamento al que pertenece, la CLABE, el banco
 * y el saldo actual. Provee constructores para su inicialización, métodos de acceso
 * (getters y setters) para manipular sus atributos, y una representación en cadena
 * para facilitar la depuración y el registro.
 *
 * @author Angel Gabriel Beltran Duarte
 */
public class CuentaDepartamentoDominio {
    /**
     * Identificador único de la cuenta de departamento.
     */
    private int id;
    
    /**
     * El objeto DepartamentoDominio al que pertenece esta cuenta.
     */
    private DepartamentoDominio departamento;
    
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
     * Constructor por defecto de la clase CuentaDepartamentoDominio.
     * Inicializa una nueva instancia de CuentaDepartamentoDominio con valores predeterminados.
     */
    public CuentaDepartamentoDominio() {
    }

    /**
     * Constructor parametrizado de la clase CuentaDepartamentoDominio.
     * Inicializa un nuevo objeto CuentaDepartamentoDominio con todos sus atributos especificados.
     *
     * @param id El identificador único de la cuenta.
     * @param departamento El departamento al que esta cuenta está asociada.
     * @param clabe La CLABE de la cuenta.
     * @param banco El nombre del banco.
     * @param saldo El saldo inicial de la cuenta.
     */
    public CuentaDepartamentoDominio(int id, DepartamentoDominio departamento, String clabe, String banco, double saldo) {
        this.id = id;
        this.departamento = departamento;
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
     * Obtiene el objeto DepartamentoDominio al que esta cuenta está asociada.
     *
     * @return El departamento asociado a la cuenta.
     */
    public DepartamentoDominio getDepartamento() {
        return departamento;
    }

    /**
     * Establece el objeto DepartamentoDominio al que esta cuenta estará asociada.
     *
     * @param departamento El nuevo departamento asociado a la cuenta.
     */
    public void setDepartamento(DepartamentoDominio departamento) {
        this.departamento = departamento;
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
     * Retorna una representación en cadena (String) del objeto CuentaDepartamentoDominio.
     * Incluye los valores de todos los atributos para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto CuentaDepartamentoDominio.
     */
    @Override
    public String toString() {
        return "CuentaDepartamentoDominio{" + "id=" + id + ", departamento=" + departamento + ", clabe=" + clabe + ", banco=" + banco + ", saldo=" + saldo + "}";
    }
}
