package Dominio;
/**
 * En esta clase se hace la entidad de dominio de Jefe, simplemente se defininen las variables, el constructor por defecto
 * y el constructor, getters, setters y strings.
 * @author Angel Gabriel Beltran Duarte 244865
 */
public class JefeDominio {
    private int id;
    private EmpleadoDominio empleado;

    public JefeDominio() {
    }

    public JefeDominio(int id, EmpleadoDominio empleado) {
        this.id = id;
        this.empleado = empleado;
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

    @Override
    public String toString() {
        return "JefeDominio{" + "id=" + id + ", empleado=" + empleado + "}";
    }
}
