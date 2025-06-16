package DTO;

public class TipoPrestamoDTO {
    private int id;
    private String nombre;
    private int maxParcialidades;

    public TipoPrestamoDTO() {}

    public TipoPrestamoDTO(int id, String nombre, int maxParcialidades) {
        this.id = id;
        this.nombre = nombre;
        this.maxParcialidades = maxParcialidades;
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
    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }
    public int getMaxParcialidades() {
        return maxParcialidades; 
    }
    public void setMaxParcialidades(int maxParcialidades) {
        this.maxParcialidades = maxParcialidades; 
    }
}
