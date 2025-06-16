package DTO;

import Dominio.EstadoEmpleado;
import Dominio.TipoEmpleado;

public class EmpleadoDTO {
    private int id;
    private String nombreCompleto;
    private EstadoEmpleado estado;
    private String usuario;
    private int departamentoId;
    private TipoEmpleado tipo;

    public EmpleadoDTO() {}

    public EmpleadoDTO(int id, String nombreCompleto, EstadoEmpleado estado, String usuario, int departamentoId, TipoEmpleado tipo) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.estado = estado;
        this.usuario = usuario;
        this.departamentoId = departamentoId;
        this.tipo = tipo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    public EstadoEmpleado getEstado() { return estado; }
    public void setEstado(EstadoEmpleado estado) { this.estado = estado; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public int getDepartamentoId() { return departamentoId; }
    public void setDepartamentoId(int departamentoId) { this.departamentoId = departamentoId; }
    public TipoEmpleado getTipo() { return tipo; }
    public void setTipo(TipoEmpleado tipo) { this.tipo = tipo; }
}
