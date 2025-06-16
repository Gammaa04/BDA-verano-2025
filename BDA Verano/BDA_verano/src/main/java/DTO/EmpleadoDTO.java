package DTO;

import Dominio.EstadoEmpleado;
import Dominio.TipoEmpleado;

public class EmpleadoDTO {

    private int id;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private EstadoEmpleado estado;
    private String usuario;
    private int departamentoId;
    private TipoEmpleado tipo;

    public EmpleadoDTO() {
    }

    public EmpleadoDTO(int id, String nombre, String ap_paterno, String ap_materno, EstadoEmpleado estado, String usuario, int departamentoId, TipoEmpleado tipo) {
        this.id = id;
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.estado = estado;
        this.usuario = usuario;
        this.departamentoId = departamentoId;
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

    public void setNombre(String nombreCompleto) {
        this.nombre = nombreCompleto;
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
}
