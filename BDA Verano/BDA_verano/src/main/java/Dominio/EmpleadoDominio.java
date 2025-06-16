package Dominio;
/**
 * En esta clase se hace la entidad de dominio de EmpleadoDominio, simplemente se defininen las variables, el constructor por defecto
 * y el constructor, getters, setters y strings.
 * @author Angel Gabriel Beltran Duarte 244865
 */
public class EmpleadoDominio {
    private int id;
    private String nombreCompleto;
    private EstadoEmpleado estado;
    private String usuario;
    private String contrasena;
    private DepartamentoDominio departamento;
    private TipoEmpleado tipo;

    public EmpleadoDominio() {
    }

    public EmpleadoDominio(int id, String nombreCompleto, EstadoEmpleado estado, String usuario, String contrasena, DepartamentoDominio departamento, TipoEmpleado tipo) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.estado = estado;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.departamento = departamento;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public EstadoEmpleado getEstado() {
        return estado;
    }

    public void setEstado(EstadoEmpleado estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public DepartamentoDominio getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDominio departamento) {
        this.departamento = departamento;
    }

    public TipoEmpleado getTipo() {
        return tipo;
    }

    public void setTipo(TipoEmpleado tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "EmpleadoDominio{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", estado=" + estado + ", usuario=" + usuario + ", contrasena=" + contrasena + ", departamento=" + departamento + ", tipo=" + tipo + "}";
    }
}
