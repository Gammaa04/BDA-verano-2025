package DTO;

public class JefeDTO {
    private int id;
    private int empleadoId;

    public JefeDTO() {}

    public JefeDTO(int id, int empleadoId) {
        this.id = id;
        this.empleadoId = empleadoId;
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
}
