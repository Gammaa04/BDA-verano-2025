package Negocio;

import DTO.PrestamoDTO;
import Dominio.PrestamoDominio;
import Dominio.EmpleadoDominio;
import Dominio.DepartamentoDominio;
import Dominio.TipoPrestamoDominio;
import Dominio.JefeDominio;
import Dominio.EstatusPrestamo;
import Dominio.HistorialEstatusPrestamoDominio;
import Persistencia.PrestamoDAO;
import Persistencia.IHistorialEstatusPrestamoDAO;
import Persistencia.IEmpleadoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import Persistencia.IConexionBD;

public class PrestamoServicio implements IPrestamoServicio {
    private final PrestamoDAO prestamoDAO;
    private final IHistorialEstatusPrestamoDAO historialDAO;
    private final IEmpleadoDAO empleadoDAO;
    private final IConexionBD conexionBD;

    public PrestamoServicio(PrestamoDAO prestamoDAO, IHistorialEstatusPrestamoDAO historialDAO, 
                              IEmpleadoDAO empleadoDAO,  IConexionBD conexionBD) {
        this.prestamoDAO = prestamoDAO;
        this.historialDAO = historialDAO;
        this.empleadoDAO = empleadoDAO;
        this.conexionBD = conexionBD;
    }

    @Override
    public PrestamoDTO solicitarPrestamo(PrestamoDTO prestamo) throws SQLException {
        validarSolicitudPrestamo(prestamo);
        try (Connection conn = conexionBD.crearConexion()) {
            conn.setAutoCommit(false);
            try {
                EmpleadoDominio empleado = empleadoDAO.obtenerEmpleadoPorId(prestamo.getEmpleadoId());
                if (empleado == null) {
                    throw new IllegalArgumentException("El empleado no existe");
                }
                PrestamoDominio dominio = new PrestamoDominio(
                    0, // ID se genera en la BD
                    new EmpleadoDominio(prestamo.getEmpleadoId(), null, null, null, null, null, null),
                    new DepartamentoDominio(prestamo.getDepartamentoId(), null),
                    new TipoPrestamoDominio(prestamo.getTipoPrestamoId(), null, 0),
                    prestamo.getMonto(),
                    LocalDateTime.now(),
                    EstatusPrestamo.CREADO,
                    null // Sin jefe autorizante aún
                );
                dominio = prestamoDAO.crearPrestamo(dominio);
                registrarHistorialEstatus(conn, dominio, null, EstatusPrestamo.CREADO);
                conn.commit();
                return mapToDTO(dominio);
            } catch (SQLException | IllegalArgumentException e) {
                conn.rollback();
                throw new SQLException("Error al solicitar el préstamo: " + e.getMessage(), e);
            }
        }
    }

    @Override
    public PrestamoDTO autorizarPrestamo(int id, int idJefeAutoriza, boolean autorizado) throws SQLException {
        if (id <= 0 || idJefeAutoriza <= 0) {
            throw new IllegalArgumentException("IDs inválidos");
        }
        try (Connection conn = conexionBD.crearConexion()) {
            conn.setAutoCommit(false);
            try {
                PrestamoDominio prestamo = prestamoDAO.obtenerPrestamoPorId(id);
                if (prestamo == null) {
                    throw new IllegalArgumentException("El préstamo no existe");
                }
                if (prestamo.getEstatus() != EstatusPrestamo.CREADO) {
                    throw new IllegalArgumentException("El préstamo no está en estado CREADO");
                }
                JefeDominio jefe = jefeDAO.obtenerJefePorId(idJefeAutoriza);
                if (jefe == null) {
                    throw new IllegalArgumentException("El jefe no existe");
                }
                EstatusPrestamo nuevoEstatus = autorizado ? EstatusPrestamo.AUTORIZADO : EstatusPrestamo.RECHAZADO;
                prestamo.setEstatus(nuevoEstatus);
                prestamo.setJefeAutoriza(new JefeDominio(idJefeAutoriza, null));
                prestamoDAO.actualizarPrestamo(prestamo);
                registrarHistorialEstatus(conn, prestamo, EstatusPrestamo.CREADO, nuevoEstatus);
                conn.commit();
                return mapToDTO(prestamo);
            } catch (SQLException | IllegalArgumentException e) {
                conn.rollback();
                throw new SQLException("Error al autorizar el préstamo: " + e.getMessage(), e);
            }
        }
    }

    @Override
    public PrestamoDTO obtenerPrestamoPorId(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor a cero");
        }
        PrestamoDominio dominio = prestamoDAO.obtenerPrestamoPorId(id);
        if (dominio == null) {
            throw new IllegalArgumentException("No se encontró un préstamo con ID " + id);
        }
        return mapToDTO(dominio);
    }

    @Override
    public List<PrestamoDTO> obtenerPrestamosPorEmpleado(int idEmpleado) throws SQLException {
        if (idEmpleado <= 0) {
            throw new IllegalArgumentException("El ID del empleado debe ser mayor a cero");
        }
        return prestamoDAO.obtenerPrestamosPorEmpleado(idEmpleado).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private void validarSolicitudPrestamo(PrestamoDTO prestamo) {
        if (prestamo == null) {
            throw new IllegalArgumentException("El préstamo no puede ser nulo");
        }
        if (prestamo.getMonto() <= 0) {
            throw new IllegalArgumentException("El monto del préstamo debe ser mayor a cero");
        }
        if (prestamo.getEmpleadoId() <= 0) {
            throw new IllegalArgumentException("El ID del empleado es inválido");
        }
        if (prestamo.getDepartamentoId() <= 0) {
            throw new IllegalArgumentException("El ID del departamento es inválido");
        }
        if (prestamo.getTipoPrestamoId() <= 0) {
            throw new IllegalArgumentException("El ID del tipo de préstamo es inválido");
        }
    }

    private void registrarHistorialEstatus(Connection conn, PrestamoDominio prestamo, 
                                          EstatusPrestamo estatusAnterior, EstatusPrestamo estatusNuevo) throws SQLException {
        HistorialEstatusPrestamoDominio historial = new HistorialEstatusPrestamoDominio(
            0, // ID se genera en la BD
            new PrestamoDominio(prestamo.getId(), null, null, null, 0, null, null, null),
            estatusAnterior,
            estatusNuevo,
            LocalDateTime.now()
        );
        historialDAO.crearHistorialEstatus(historial);
    }

    private PrestamoDTO mapToDTO(PrestamoDominio dominio) {
        return new PrestamoDTO(
            dominio.getId(),
            dominio.getEmpleado().getId(),
            dominio.getDepartamento().getId(),
            dominio.getTipoPrestamo().getId(),
            dominio.getMonto(),
            dominio.getFechaHora(),
            dominio.getEstatus(),
            dominio.getJefeAutoriza() != null ? dominio.getJefeAutoriza().getId() : 0
        );
    }
}
