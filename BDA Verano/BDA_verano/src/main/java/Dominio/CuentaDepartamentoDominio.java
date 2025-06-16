package Dominio;
/**
 * En esta clase se hace la entidad de dominio de Cuenta departamento, simplemente se defininen las variables, el constructor por defecto
 * y el constructor, getters, setters y strings.
 * @author Angel Gabriel Beltran Duarte 
 */
public class CuentaDepartamentoDominio {
    private int id;
    private DepartamentoDominio departamento;
    private String clabe;
    private String banco;
    private double saldo;

    public CuentaDepartamentoDominio() {
    }

    public CuentaDepartamentoDominio(int id, DepartamentoDominio departamento, String clabe, String banco, double saldo) {
        this.id = id;
        this.departamento = departamento;
        this.clabe = clabe;
        this.banco = banco;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DepartamentoDominio getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDominio departamento) {
        this.departamento = departamento;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CuentaDepartamentoDominio{" + "id=" + id + ", departamento=" + departamento + ", clabe=" + clabe + ", banco=" + banco + ", saldo=" + saldo + "}";
    }
}
