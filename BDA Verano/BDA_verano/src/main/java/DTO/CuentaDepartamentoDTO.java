package DTO;

public class CuentaDepartamentoDTO {
    private int id;
    private int departamentoId;
    private String clabe;
    private String banco;
    private double saldo;

    public CuentaDepartamentoDTO() {}

    public CuentaDepartamentoDTO(int id, int departamentoId, String clabe, String banco, double saldo) {
        this.id = id;
        this.departamentoId = departamentoId;
        this.clabe = clabe;
        this.banco = banco;
        this.saldo = saldo;
    }

    public int getId() {
        return id; 
    }
    public void setId(int id) {
        this.id = id; 
    }
    public int getDepartamentoId() {
        return departamentoId; 
    }
    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId; 
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
    public double getSaldo() {
        return saldo; 
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo; 
    }
}
