package DTO;

public class SubordinadoDTO {
    private int id;
    private int empleadoId;
    private int jefeId;

    public SubordinadoDTO() {}

    public SubordinadoDTO(int id, int empleadoId, int jefeId) {
        this.id = id;
        this.empleadoId = empleadoId;
        this.jefeId = jefeId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getEmpleadoId() { return empleadoId; }
    public void setEmpleadoId(int empleadoId) { this.empleadoId = empleadoId; }
    public int getJefeId() { return jefeId; }
    public void setJefeId(int jefeId) { this.jefeId = jefeId; }
}
