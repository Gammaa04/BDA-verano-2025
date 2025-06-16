package Negocio;

import DTO.DepartamentoDTO;
import java.sql.SQLException;
import java.util.List;

public interface IDepartamentoServicio {
    DepartamentoDTO actualizarDepartamento(DepartamentoDTO departamento) throws SQLException;
    DepartamentoDTO obtenerDepartamentoPorId(int id) throws SQLException;
    List<DepartamentoDTO> obtenerTodosLosDepartamentos() throws SQLException;
}
