package Persistencia;

import Dominio.CuentaEmpleadoDominio;
import java.sql.SQLException;
import java.util.List;

public interface ICuentaEmpleadoDAO {
    CuentaEmpleadoDominio crearCuentaEmpleado(CuentaEmpleadoDominio cuenta) throws PersistenciaException;
    CuentaEmpleadoDominio actualizarCuentaEmpleado(CuentaEmpleadoDominio cuenta) throws PersistenciaException;
    CuentaEmpleadoDominio obtenerCuentaEmpleadoPorId(int id) throws PersistenciaException;
    List<CuentaEmpleadoDominio> obtenerCuentasPorEmpleado(int idEmpleado) throws PersistenciaException;
}
