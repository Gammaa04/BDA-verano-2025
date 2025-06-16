package Persistencia;

import Dominio.CuentaEmpleadoDominio;
import java.sql.SQLException;
import java.util.List;

public interface ICuentaEmpleadoDAO {
    CuentaEmpleadoDominio crearCuentaEmpleado(CuentaEmpleadoDominio cuenta) throws SQLException;
    CuentaEmpleadoDominio actualizarCuentaEmpleado(CuentaEmpleadoDominio cuenta) throws SQLException;
    CuentaEmpleadoDominio obtenerCuentaEmpleadoPorId(int id) throws SQLException;
    List<CuentaEmpleadoDominio> obtenerCuentasPorEmpleado(int idEmpleado) throws SQLException;
}
