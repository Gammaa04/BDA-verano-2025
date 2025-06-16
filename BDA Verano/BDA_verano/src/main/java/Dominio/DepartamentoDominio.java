package Dominio;
/**
 * En esta clase se hace la entidad de dominio de Departamento, simplemente se defininen las variables, el constructor por defecto
 * y el constructor, getters, setters y strings.
 * @author Angel Gabriel Beltran Duarte 244865
 */
public class DepartamentoDominio {
    private int id;
    private String nombre;

    public DepartamentoDominio() {
    }

    public DepartamentoDominio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "DepartamentoDominio{" + "id=" + id + ", nombre=" + nombre + "}";
    }
}
