package Dominio;

/* @author Angel
    Esta clase es para definir la entidad empleado getters setter toString y el constructor
*/

public class EmpleadoDominio {
    private int id;
    private String nombre;
    private String apellidoPaterno; 
    private String apellidoMaterno;
    private String usuario;
    private String contraseña;
    private String estaActivo;

    public EmpleadoDominio(int id, String nombre, String apellidoPaterno, String apellidoMaterno, String usuario, String contraseña, String estaActivo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.estaActivo = estaActivo;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(String estaActivo) {
        this.estaActivo = estaActivo;
    }

    @Override
    public String toString() {
        return "EmpleadoDominio{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + ", estaActivo=" + estaActivo + '}';
    }
    
}
