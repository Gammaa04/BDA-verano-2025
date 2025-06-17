/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Dominio.EstadoEmpleado;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class EmpleadoCuentaBancoDTO {
    
    /**
     * Identificador único del empleado.
     */
    private int id;

    /**
     * Nombre(s) del empleado.
     */
    private String nombre;

    /**
     * Apellido paterno del empleado.
     */
    private String ap_paterno;

    /**
     * Apellido materno del empleado.
     */
    private String ap_materno;

    /**
     * El estado actual del empleado (por ejemplo, activo o inactivo).
     * Se asume que 'EstadoEmpleado' es un tipo de enumeración (enum) o una clase definida en el proyecto.
     */
    private EstadoEmpleado estado;


    /**
     * Constructor por defecto de la clase EmpleadoDominio.
     * Inicializa una nueva instancia de EmpleadoDominio con valores predeterminados.
     */
    public EmpleadoCuentaBancoDTO() {
    }

    /**
     * Constructor parametrizado de la clase EmpleadoDominio.
     * Inicializa un nuevo objeto EmpleadoDominio con todos sus atributos especificados.
     *
     * @param id El identificador único del empleado.
     * @param nombre El(los) nombre(s) del empleado.
     * @param ap_paterno El apellido paterno del empleado.
     * @param ap_materno El apellido materno del empleado.
     * @param estado El estado actual del empleado (activo/inactivo).
     */
    public EmpleadoCuentaBancoDTO(int id, String nombre, String ap_paterno, String ap_materno, EstadoEmpleado estado) {
        this.id = id;
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.estado = estado;
    }

    
    

    /**
     * Obtiene el apellido paterno del empleado.
     *
     * @return El apellido paterno.
     */
    public String getAp_paterno() {
        return ap_paterno;
    }

    /**
     * Establece el apellido paterno del empleado.
     *
     * @param ap_paterno El nuevo apellido paterno.
     */
    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    /**
     * Obtiene el apellido materno del empleado.
     *
     * @return El apellido materno.
     */
    public String getAp_materno() {
        return ap_materno;
    }

    /**
     * Establece el apellido materno del empleado.
     *
     * @param ap_materno El nuevo apellido materno.
     */
    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    /**
     * Obtiene el identificador único del empleado.
     *
     * @return El ID del empleado.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del empleado.
     *
     * @param id El nuevo ID del empleado.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre El nuevo nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el estado actual del empleado.
     *
     * @return El estado del empleado.
     */
    public EstadoEmpleado getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual del empleado.
     *
     * @param estado El nuevo estado del empleado.
     */
    public void setEstado(EstadoEmpleado estado) {
        this.estado = estado;
    }

    



    /**
     * Retorna una representación en cadena (String) del objeto EmpleadoDominio.
     * Incluye los valores de sus atributos clave para facilitar la depuración y el registro.
     * No incluye apellidos paterno y materno en el `toString` por defecto, pero se pueden añadir si es necesario para una depuración más exhaustiva.
     *
     * @return Una cadena que representa el estado del objeto EmpleadoDominio.
     */
    @Override
    public String toString() {
        return "EmpleadoCuentaBancoDTO{" + "id=" + id + ", nombre=" + nombre + ", ap_paterno=" + ap_paterno + ", ap_materno=" + ap_materno + ", estado=" + estado + '}';
    }

    
    
}
