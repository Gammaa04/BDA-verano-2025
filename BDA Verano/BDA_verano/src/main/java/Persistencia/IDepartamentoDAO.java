package Persistencia;

import Dominio.DepartamentoDominio;
import java.sql.SQLException;
import java.util.List;

public interface IDepartamentoDAO {
    DepartamentoDominio actualizarDepartamento(DepartamentoDominio departamento) throws PersistenciaException;
    DepartamentoDominio obtenerDepartamentoPorId(int id) throws PersistenciaException;
    List<DepartamentoDominio> obtenerTodosLosDepartamentos() throws PersistenciaException;
}
