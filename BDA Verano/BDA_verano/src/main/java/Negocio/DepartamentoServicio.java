package Negocio;

import DTO.DepartamentoDTO;
import Dominio.DepartamentoDominio;
import Persistencia.DepartamentoDAO;
import Persistencia.PersistenciaException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DepartamentoServicio implements IDepartamentoServicio {
    private final DepartamentoDAO departamentoDAO;

    public DepartamentoServicio(DepartamentoDAO departamentoDAO) {
        this.departamentoDAO = departamentoDAO;
    }

    @Override
    public DepartamentoDTO actualizarDepartamento(DepartamentoDTO departamento) throws PersistenciaException {
        validarDepartamento(departamento);
        DepartamentoDominio dominio = new DepartamentoDominio(departamento.getId(), departamento.getNombre());
        try {
            dominio = departamentoDAO.actualizarDepartamento(dominio);
            return new DepartamentoDTO(dominio.getId(), dominio.getNombre());
        } catch (SQLException ex) {
            throw new PersistenciaException("");
        }    
    }

    @Override
    public DepartamentoDTO obtenerDepartamentoPorId(int id) throws PersistenciaException {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor a cero");
        }
        DepartamentoDominio dominio;
        try {
            dominio = departamentoDAO.obtenerDepartamentoPorId(id);
            return new DepartamentoDTO(dominio.getId(), dominio.getNombre());
        } catch (SQLException ex) {
            throw new PersistenciaException("");
        }
        
        
    }

    @Override
    public List<DepartamentoDTO> obtenerTodosLosDepartamentos() throws PersistenciaException {
        try {
            return departamentoDAO.obtenerTodosLosDepartamentos().stream()
                    .map(d -> new DepartamentoDTO(d.getId(), d.getNombre()))
                    .collect(Collectors.toList());
        } catch (SQLException ex) {
            throw new PersistenciaException("");
        }
    }

    private void validarDepartamento(DepartamentoDTO departamento) {
        if (departamento == null) {
            throw new IllegalArgumentException("El departamento no puede ser nulo");
        }
        if (departamento.getNombre() == null || departamento.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del departamento no puede estar vacío");
        }
    }
}
