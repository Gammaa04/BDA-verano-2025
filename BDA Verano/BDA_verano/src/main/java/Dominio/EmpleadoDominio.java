package Dominio;

/**
 * @author Angel
 * Esta clase es para definir la entidad empleado getters setter toString y el constructor
 */
public class EmpleadoDominio {
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String usuario;
    private String contraseña;
    private boolean estaActivo; // ¡Cambiado de String a boolean!


    // --- Constructor por defecto 
    public EmpleadoDominio() {
    }

    // --- Constructor 
    public EmpleadoDominio(
            int id,
            String nombre,
            String apellidoPaterno,
            String apellidoMaterno,
            String usuario,
            String contraseña,
            boolean estaActivo 
    ) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.estaActivo = estaActivo;
    }

    // Getters y setters
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

   
    public boolean isEstaActivo() { // ¡Cambiado a boolean y "is" como convención!
        return estaActivo;
    }

    
    public void setEstaActivo(boolean estaActivo) { // ¡Cambiado a boolean!
        this.estaActivo = estaActivo;
    }

    
    @Override
    public String toString() {
        return "EmpleadoDominio{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + ", estaActivo=" + estaActivo + '}';
    }
}
