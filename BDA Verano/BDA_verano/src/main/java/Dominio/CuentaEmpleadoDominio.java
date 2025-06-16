package Dominio;
/**
 * En esta clase se hace la entidad de dominio de Cuenta empleado, simplemente se defininen las variables, el constructor por defecto
 * y el constructor, getters, setters y strings.
 * @author Angel Gabriel Beltran Duarte 244865
 */
public class CuentaEmpleadoDominio {
    private int id;
    private EmpleadoDominio empleado;
    private String clabe;
    private String banco;
    private EstadoCuenta estado;

    public CuentaEmpleadoDominio() {
    }

    public CuentaEmpleadoDominio(int id, EmpleadoDominio empleado, String clabe, String banco, EstadoCuenta estado) {
        this.id = id;
        this.empleado = empleado;
        this.clabe = clabe;
        this.banco = banco;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmpleadoDominio getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoDominio empleado) {
        this.empleado = empleado;
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

    public EstadoCuenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoCuenta estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "CuentaEmpleadoDominio{" + "id=" + id + ", empleado=" + empleado + ", clabe=" + clabe + ", banco=" + banco + ", estado=" + estado + "}";
    }
}
