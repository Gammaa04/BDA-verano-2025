package Dominio;
/**
 * En esta clase se hace la entidad de dominio de Subordinado, simplemente se defininen las variables, el constructor por defecto
 * y el constructor, getters, setters y strings.
 * @author Angel Gabriel Beltran Duarte 244865
 */
public class SubordinadoDominio {
    private int id;
    private EmpleadoDominio empleado;
    private JefeDominio jefe;

    public SubordinadoDominio() {
    }

    public SubordinadoDominio(int id, EmpleadoDominio empleado, JefeDominio jefe) {
        this.id = id;
        this.empleado = empleado;
        this.jefe = jefe;
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

    public JefeDominio getJefe() {
        return jefe;
    }

    public void setJefe(JefeDominio jefe) {
        this.jefe = jefe;
    }

    @Override
    public String toString() {
        return "SubordinadoDominio{" + "id=" + id + ", empleado=" + empleado + ", jefe=" + jefe + "}";
    }
}
