package Negocio;

import DTO.DepartamentoDTO;
import Dominio.DepartamentoDominio;
import Persistencia.DepartamentoDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class DepartamentoServicio implements IDepartamentoServicio {
    private final DepartamentoDAO departamentoDAO;

    public DepartamentoServicio(DepartamentoDAO departamentoDAO) {
        this.departamentoDAO = departamentoDAO;
    }

    @Override
    public DepartamentoDTO actualizarDepartamento(DepartamentoDTO departamento) throws SQLException {
        validarDepartamento(departamento);
        DepartamentoDominio dominio = new DepartamentoDominio(departamento.getId(), departamento.getNombre());
        dominio = departamentoDAO.actualizarDepartamento(dominio);
        return new DepartamentoDTO(dominio.getId(), dominio.getNombre());
    }

    @Override
    public DepartamentoDTO obtenerDepartamentoPorId(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor a cero");
        }
        DepartamentoDominio dominio = departamentoDAO.obtenerDepartamentoPorId(id);
        if (dominio == null) {
            throw new IllegalArgumentException("No se encontró un departamento con ID " + id);
        }
        return new DepartamentoDTO(dominio.getId(), dominio.getNombre());
    }

    @Override
    public List<DepartamentoDTO> obtenerTodosLosDepartamentos() throws SQLException {
        return departamentoDAO.obtenerTodosLosDepartamentos().stream()
                .map(d -> new DepartamentoDTO(d.getId(), d.getNombre()))
                .collect(Collectors.toList());
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
