package DTO;

import Dominio.EstatusPrestamo;
import java.time.LocalDateTime;

public class PrestamoDTO {
    private int id;
    private int empleadoId;
    private int departamentoId;
    private int tipoPrestamoId;
    private double monto;
    private LocalDateTime fechaHora;
    private EstatusPrestamo estatus;
    private int jefeAutorizaId;

    public PrestamoDTO() {}

    public PrestamoDTO(int id, int empleadoId, int departamentoId, int tipoPrestamoId, double monto, LocalDateTime fechaHora, EstatusPrestamo estatus, int jefeAutorizaId) {
        this.id = id;
        this.empleadoId = empleadoId;
        this.departamentoId = departamentoId;
        this.tipoPrestamoId = tipoPrestamoId;
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.estatus = estatus;
        this.jefeAutorizaId = jefeAutorizaId;
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
    public int getDepartamentoId() {
        return departamentoId; 
    }
    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId; 
    }
    public int getTipoPrestamoId() {
        return tipoPrestamoId; 
    }
    public void setTipoPrestamoId(int tipoPrestamoId) {
        this.tipoPrestamoId = tipoPrestamoId; 
    }
    public double getMonto() {
        return monto; 
    }
    public void setMonto(double monto) {
        this.monto = monto; 
    }
    public LocalDateTime getFechaHora() {
        return fechaHora; 
    }
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora; 
    }
    public EstatusPrestamo getEstatus() {
        return estatus;
    }
    public void setEstatus(EstatusPrestamo estatus) {
        this.estatus = estatus; 
    }
    public int getJefeAutorizaId() {
        return jefeAutorizaId; 
    }
    public void setJefeAutorizaId(int jefeAutorizaId) {
        this.jefeAutorizaId = jefeAutorizaId; 
    }
}
