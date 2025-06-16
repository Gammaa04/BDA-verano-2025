package Persistencia;

import Dominio.CuentaDepartamentoDominio;
import java.sql.SQLException;
import java.util.List;

public interface ICuentaDepartamentoDAO {
    
    CuentaDepartamentoDominio obtenerCuentaDepartamentoPorId(int id) throws SQLException;
    List<CuentaDepartamentoDominio> obtenerCuentasPorDepartamento(int idDepartamento) throws SQLException;
}
