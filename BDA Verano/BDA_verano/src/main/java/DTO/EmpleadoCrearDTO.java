package DTO;

import Dominio.EstadoEmpleado;
import Dominio.TipoEmpleado;

public class EmpleadoCrearDTO {
    
    private String nombreCompleto;
    private EstadoEmpleado estado;
    private String usuario;
    private int departamentoId;
    private String contrasena;
    private TipoEmpleado tipo;

    public EmpleadoCrearDTO() {}

    public EmpleadoCrearDTO( String nombreCompleto, EstadoEmpleado estado, String usuario, int departamentoId,String contrasena, TipoEmpleado tipo) {
      
        this.nombreCompleto = nombreCompleto;
        this.estado = estado;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.departamentoId = departamentoId;
        this.tipo = tipo;
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
    public int getDepartamentoId() {
        return departamentoId; 
    }
    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId; 
    }
    public TipoEmpleado getTipo() {
        return tipo; 
    }
    public void setTipo(TipoEmpleado tipo) {
        this.tipo = tipo; 
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
