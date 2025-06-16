package Dominio;
/**
 * En esta clase se hace la entidad de dominio de Tipo Prestamo, simplemente se defininen las variables, el constructor por defecto
 * y el constructor, getters, setters y strings.
 * @author Angel Gabriel Beltran Duarte 244865
 */
public class TipoPrestamoDominio {
    private int id;
    private String nombre;
    private int maxParcialidades;

    public TipoPrestamoDominio() {
    }

    public TipoPrestamoDominio(int id, String nombre, int maxParcialidades) {
        this.id = id;
        this.nombre = nombre;
        this.maxParcialidades = maxParcialidades;
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

    public int getMaxParcialidades() {
        return maxParcialidades;
    }

    public void setMaxParcialidades(int maxParcialidades) {
        this.maxParcialidades = maxParcialidades;
    }

    @Override
    public String toString() {
        return "TipoPrestamoDominio{" + "id=" + id + ", nombre=" + nombre + ", maxParcialidades=" + maxParcialidades + "}";
    }
}
