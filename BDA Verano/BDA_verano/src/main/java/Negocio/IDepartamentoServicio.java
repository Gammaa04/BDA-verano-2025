package Negocio;

import DTO.DepartamentoDTO;
import Persistencia.PersistenciaException;
import java.sql.SQLException;
import java.util.List;

public interface IDepartamentoServicio {
    DepartamentoDTO actualizarDepartamento(DepartamentoDTO departamento) throws PersistenciaException;
    DepartamentoDTO obtenerDepartamentoPorId(int id) throws PersistenciaException;
    List<DepartamentoDTO> obtenerTodosLosDepartamentos() throws PersistenciaException;
}
