package DTO;

import Dominio.EstatusPrestamo;
import java.time.LocalDateTime;

public class HistorialEstatusPrestamoDTO {
    private int id;
    private int prestamoId;
    private EstatusPrestamo estatusAnterior;
    private EstatusPrestamo estatusNuevo;
    private LocalDateTime fechaHora;

    public HistorialEstatusPrestamoDTO() {}

    public HistorialEstatusPrestamoDTO(int id, int prestamoId, EstatusPrestamo estatusAnterior, EstatusPrestamo estatusNuevo, LocalDateTime fechaHora) {
        this.id = id;
        this.prestamoId = prestamoId;
        this.estatusAnterior = estatusAnterior;
        this.estatusNuevo = estatusNuevo;
        this.fechaHora = fechaHora;
    }

    public int getId() {
        return id; 
    }
    public void setId(int id) {
        this.id = id; 
    }
    public int getPrestamoId() {
        return prestamoId; 
    }
    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId; 
    }
    public EstatusPrestamo getEstatusAnterior() {
        return estatusAnterior; 
    }
    public void setEstatusAnterior(EstatusPrestamo estatusAnterior) {
        this.estatusAnterior = estatusAnterior; 
    }
    public EstatusPrestamo getEstatusNuevo() {
        return estatusNuevo; 
    }
    public void setEstatusNuevo(EstatusPrestamo estatusNuevo) {
        this.estatusNuevo = estatusNuevo; 
    }
    public LocalDateTime getFechaHora() {
        return fechaHora; 
    }
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora; 
    }
}
