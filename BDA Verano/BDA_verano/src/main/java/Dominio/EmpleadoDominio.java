package Dominio;

/**
 * En esta clase se hace la entidad de dominio de Empleado, simplemente se
 * defininen las variables, el constructor por defecto y el constructor,
 * getters, setters y strings.
 *
 * @author Angel Gabriel Beltran Duarte 244865
 */
public class EmpleadoDominio {

    private int id;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private EstadoEmpleado estado;
    private String usuario;
    private String contrasena;
    private DepartamentoDominio departamento;
    private TipoEmpleado tipo;

    public EmpleadoDominio() {
    }

    public EmpleadoDominio(int id, String nombre, String ap_paterno, String ap_materno, EstadoEmpleado estado, String usuario, String contrasena, DepartamentoDominio departamento, TipoEmpleado tipo) {
        this.id = id;
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.estado = estado;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.departamento = departamento;
        this.tipo = tipo;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
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
        return "EmpleadoDominio{" + "id=" + id + ", nombre=" + nombre + ", estado=" + estado + ", usuario=" + usuario + ", contrasena=" + contrasena + ", departamento=" + departamento + ", tipo=" + tipo + "}";
    }
}
