package Persistencia;

import Dominio.DepartamentoDominio;
import java.sql.SQLException;
import java.util.List;

public interface IDepartamentoDAO {
    DepartamentoDominio actualizarDepartamento(DepartamentoDominio departamento) throws SQLException;
    DepartamentoDominio obtenerDepartamentoPorId(int id) throws SQLException;
    List<DepartamentoDominio> obtenerTodosLosDepartamentos() throws SQLException;
}
