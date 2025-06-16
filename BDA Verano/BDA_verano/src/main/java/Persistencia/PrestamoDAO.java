package Persistencia;

import Dominio.PrestamoDominio;
import Dominio.EmpleadoDominio;
import Dominio.DepartamentoDominio;
import Dominio.TipoPrestamoDominio;
import Dominio.JefeDominio;
import Dominio.EstatusPrestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO implements IPrestamoDAO {
    private final IConexionBD conexionBD;

    public PrestamoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public PrestamoDominio crearPrestamo(PrestamoDominio prestamo) throws SQLException {
        String query = """
                     INSERT INTO Prestamos (id_empleado, id_departamento, id_tipo_prestamo, monto, fecha_hora, estatus, id_jefe_autoriza)
                     VALUES (?, ?, ?, ?, ?, ?, ?)
                        """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, prestamo.getEmpleado().getId());
            stmt.setInt(2, prestamo.getDepartamento().getId());
            stmt.setInt(3, prestamo.getTipoPrestamo().getId());
            stmt.setDouble(4, prestamo.getMonto());
            stmt.setObject(5, prestamo.getFechaHora());
            stmt.setString(6, prestamo.getEstatus().name());
            stmt.setInt(7, prestamo.getJefeAutoriza().getId());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    prestamo.setId(rs.getInt(1));
                }
            }
            return prestamo;
        }
    }

    @Override
    public PrestamoDominio actualizarPrestamo(PrestamoDominio prestamo) throws SQLException {
        String query = """
                       UPDATE Prestamos SET id_empleado = ?,
                       id_departamento = ?,
                       id_tipo_prestamo = ?,
                       monto = ?,
                       fecha_hora = ?,
                       estatus = ?,
                       id_jefe_autoriza = ? WHERE id_prestamo = ?
                       """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, prestamo.getEmpleado().getId());
            stmt.setInt(2, prestamo.getDepartamento().getId());
            stmt.setInt(3, prestamo.getTipoPrestamo().getId());
            stmt.setDouble(4, prestamo.getMonto());
            stmt.setObject(5, prestamo.getFechaHora());
            stmt.setString(6, prestamo.getEstatus().name());
            stmt.setInt(7, prestamo.getJefeAutoriza().getId());
            stmt.setInt(8, prestamo.getId());
            int rows = stmt.executeUpdate();
            if (rows == 0) {
                throw new SQLException("No se encontró el préstamo con ID " + prestamo.getId());
            }
            return prestamo;
        }
    }

    @Override
    public PrestamoDominio obtenerPrestamoPorId(int id) throws SQLException {
        String query = """
                     SELECT id_prestamo,
                     id_empleado,
                     id_departamento,
                     id_tipo_prestamo,
                     monto,
                     fecha_hora,
                     estatus,
                     id_jefe_autoriza FROM Prestamos WHERE id_prestamo = ?
                    """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PrestamoDominio(
                        rs.getInt("id_prestamo"),
                        new EmpleadoDominio(rs.getInt("id_empleado"), null, null, null, null, null, null,null,null),
                        new DepartamentoDominio(rs.getInt("id_departamento"), null),
                        new TipoPrestamoDominio(rs.getInt("id_tipo_prestamo"), null, 0),
                        rs.getDouble("monto"),
                        rs.getObject("fecha_hora", LocalDateTime.class),
                        EstatusPrestamo.valueOf(rs.getString("estatus")),
                        new JefeDominio(rs.getInt("id_jefe_autoriza"), null)
                    );
                }
                return null;
            }
        }
    }

    @Override
    public List<PrestamoDominio> obtenerPrestamosPorEmpleado(int idEmpleado) throws SQLException {
        List<PrestamoDominio> prestamos = new ArrayList<>();
        String query = """
                     SELECT id_prestamo,
                     id_empleado,
                     id_departamento,
                     id_tipo_prestamo,
                     monto, 
                     fecha_hora,
                     estatus,
                     id_jefe_autoriza FROM Prestamos WHERE id_empleado = ?
                     """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idEmpleado);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    prestamos.add(new PrestamoDominio(
                        rs.getInt("id_prestamo"),
                        new EmpleadoDominio(rs.getInt("id_empleado"), null, null, null, null, null, null,null,null),
                        new DepartamentoDominio(rs.getInt("id_departamento"), null),
                        new TipoPrestamoDominio(rs.getInt("id_tipo_prestamo"), null, 0),
                        rs.getDouble("monto"),
                        rs.getObject("fecha_hora", LocalDateTime.class),
                        EstatusPrestamo.valueOf(rs.getString("estatus")),
                        new JefeDominio(rs.getInt("id_jefe_autoriza"), null)
                    ));
                }
            }
        }
        return prestamos;
    }

    @Override
    public List<PrestamoDominio> obtenerTodosLosPrestamos() throws SQLException {
        List<PrestamoDominio> prestamos = new ArrayList<>();
        String query = """
                     SELECT id_prestamo,
                     id_empleado,
                     id_departamento,
                     id_tipo_prestamo,
                     monto,
                     fecha_hora,
                     estatus,
                     id_jefe_autoriza FROM Prestamos""";
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    prestamos.add(new PrestamoDominio(
                        rs.getInt("id_prestamo"),
                        new EmpleadoDominio(rs.getInt("id_empleado"), null, null, null, null, null, null,null,null),
                        new DepartamentoDominio(rs.getInt("id_departamento"), null),
                        new TipoPrestamoDominio(rs.getInt("id_tipo_prestamo"), null, 0),
                        rs.getDouble("monto"),
                        rs.getObject("fecha_hora", LocalDateTime.class),
                        EstatusPrestamo.valueOf(rs.getString("estatus")),
                        new JefeDominio(rs.getInt("id_jefe_autoriza"), null)
                    ));
                }
            }
        }
        return prestamos;
    }
}
