package DTO;

import Dominio.EstadoCuenta;

public class CuentaEmpleadoDTO {
    private int id;
    private int empleadoId;
    private String clabe;
    private String banco;
    private EstadoCuenta estado;

    public CuentaEmpleadoDTO() {}

    public CuentaEmpleadoDTO(int id, int empleadoId, String clabe, String banco, EstadoCuenta estado) {
        this.id = id;
        this.empleadoId = empleadoId;
        this.clabe = clabe;
        this.banco = banco;
        this.estado = estado;
    }

    public int getId() {
        return id; 
    }
    public void setId(int id) {
        this.id = id; 
    }
    public int getEmpleadoId() {
        return empleadoId; 
    }
    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId; 
    }
    public String getClabe() {
        return clabe; 
    }
    public void setClabe(String clabe) {
        this.clabe = clabe; 
    }
    public String getBanco() {
        return banco; 
    }
    public void setBanco(String banco) {
        this.banco = banco; 
    }
    public EstadoCuenta getEstado() {
        return estado; 
    }
    public void setEstado(EstadoCuenta estado) {
        this.estado = estado; 
    }
}