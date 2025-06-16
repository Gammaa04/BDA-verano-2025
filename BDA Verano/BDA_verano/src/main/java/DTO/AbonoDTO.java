package DTO;

import java.time.LocalDateTime;

public class AbonoDTO {
    private int id;
    private int prestamoId;
    private double monto;
    private LocalDateTime fechaHora;
    private int jefeAutorizaId;

    public AbonoDTO() {}

    public AbonoDTO(int id, int prestamoId, double monto, LocalDateTime fechaHora, int jefeAutorizaId) {
        this.id = id;
        this.prestamoId = prestamoId;
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.jefeAutorizaId = jefeAutorizaId;
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
    public int getJefeAutorizaId() {
        return jefeAutorizaId; 
    }
    public void setJefeAutorizaId(int jefeAutorizaId) {
        this.jefeAutorizaId = jefeAutorizaId; 
    }
}
