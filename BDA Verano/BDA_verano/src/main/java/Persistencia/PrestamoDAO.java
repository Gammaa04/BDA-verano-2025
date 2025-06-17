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
    public PrestamoDominio crearPrestamo(PrestamoDominio prestamo) throws PersistenciaException {
        String query = """
            INSERT INTO Prestamos (id_empleado, id_departamento, id_tipo_prestamo, monto, fecha_hora, estatus, id_jefe_autoriza)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            conn.setAutoCommit(false); // 🔴 Inicia la transacción

            stmt.setInt(1, prestamo.getEmpleado().getId());
            stmt.setInt(2, prestamo.getDepartamento().getId());
            stmt.setInt(3, prestamo.getTipoPrestamo().getId());
            stmt.setDouble(4, prestamo.getMonto());
            stmt.setObject(5, prestamo.getFechaHora());
            stmt.setString(6, prestamo.getEstatus().name());
            stmt.setInt(7, prestamo.getJefeAutoriza().getId());

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                conn.rollback();
                throw new PersistenciaException("No se pudo crear el préstamo.");
            }

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    prestamo.setId(rs.getInt(1));
                } else {
                    conn.rollback();
                    throw new PersistenciaException("No se pudo obtener el ID del préstamo creado.");
                }
            }

            conn.commit(); // ✅ Confirma la transacción
            return prestamo;

        } catch (SQLException e) {
            throw new PersistenciaException("Error al crear préstamo: " + e.getMessage());
        }
    }

    @Override
    public PrestamoDominio obtenerPrestamoPorId(int id) throws PersistenciaException {
        String query = """
            SELECT id_prestamo, id_empleado, id_departamento, id_tipo_prestamo, monto, fecha_hora, estatus, id_jefe_autoriza 
            FROM Prestamos WHERE id_prestamo = ?
        """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PrestamoDominio(
                        rs.getInt("id_prestamo"),
                        new EmpleadoDominio(rs.getInt("id_empleado"), null, null, null, null, null, null, null, null),
                        new DepartamentoDominio(rs.getInt("id_departamento"), null),
                        new TipoPrestamoDominio(rs.getInt("id_tipo_prestamo"), null, 0),
                        rs.getDouble("monto"),
                        rs.getObject("fecha_hora", LocalDateTime.class),
                        obtenerEstatusPrestamo(rs.getString("estatus")),
                        new JefeDominio(rs.getInt("id_jefe_autoriza"), null)
                    );
                }
                return null;
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener préstamo por ID: " + e.getMessage());
        }
    }

    @Override
    public List<PrestamoDominio> obtenerTodosLosPrestamos() throws PersistenciaException {
        List<PrestamoDominio> prestamos = new ArrayList<>();
        String query = """
            SELECT id_prestamo, id_empleado, id_departamento, id_tipo_prestamo, monto, fecha_hora, estatus, id_jefe_autoriza 
            FROM Prestamos
        """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                prestamos.add(new PrestamoDominio(
                    rs.getInt("id_prestamo"),
                    new EmpleadoDominio(rs.getInt("id_empleado"), null, null, null, null, null, null, null, null),
                    new DepartamentoDominio(rs.getInt("id_departamento"), null),
                    new TipoPrestamoDominio(rs.getInt("id_tipo_prestamo"), null, 0),
                    rs.getDouble("monto"),
                    rs.getObject("fecha_hora", LocalDateTime.class),
                    obtenerEstatusPrestamo(rs.getString("estatus")),
                    new JefeDominio(rs.getInt("id_jefe_autoriza"), null)
                ));
            }
            return prestamos;

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener todos los préstamos: " + e.getMessage());
        }
    }

    private EstatusPrestamo obtenerEstatusPrestamo(String estatusString) {
        switch (estatusString) {
            case "Creado":
                return EstatusPrestamo.CREADO;
            case "Rechazado":
                return EstatusPrestamo.RECHAZADO;
            case "Autorizado":
                return EstatusPrestamo.AUTORIZADO;
            case "Abonado parcialmente":
                return EstatusPrestamo.ABONADO_PARCIALMENTE;
            case "Pagado":
                return EstatusPrestamo.PAGADO;
            case "Completado":
                return EstatusPrestamo.COMPLETADO;
            default:
                return null;
        }
    }

    @Override
public PrestamoDominio actualizarPrestamo(PrestamoDominio prestamo) throws PersistenciaException {
    String query = """
        UPDATE Prestamos SET id_empleado = ?, id_departamento = ?, id_tipo_prestamo = ?, monto = ?, fecha_hora = ?, estatus = ?, id_jefe_autoriza = ?
        WHERE id_prestamo = ?
    """;
    
    try (Connection conn = conexionBD.crearConexion();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        conn.setAutoCommit(false); // 🔴 Inicia la transacción

        stmt.setInt(1, prestamo.getEmpleado().getId());
        stmt.setInt(2, prestamo.getDepartamento().getId());
        stmt.setInt(3, prestamo.getTipoPrestamo().getId());
        stmt.setDouble(4, prestamo.getMonto());
        stmt.setObject(5, prestamo.getFechaHora());
        stmt.setString(6, prestamo.getEstatus().name());
        stmt.setInt(7, prestamo.getJefeAutoriza().getId());
        stmt.setInt(8, prestamo.getId());

        int filasAfectadas = stmt.executeUpdate();
        if (filasAfectadas == 0) {
            conn.rollback();
            throw new PersistenciaException("No se encontró el préstamo con ID " + prestamo.getId());
        }

        conn.commit(); // ✅ Confirma la transacción
        return prestamo;

    } catch (SQLException e) {
        throw new PersistenciaException("Error al actualizar préstamo: " + e.getMessage());
    }
}


    @Override
public List<PrestamoDominio> obtenerPrestamosPorEmpleado(int idEmpleado) throws PersistenciaException {
    List<PrestamoDominio> prestamos = new ArrayList<>();
    String query = """
        SELECT id_prestamo, id_empleado, id_departamento, id_tipo_prestamo, monto, fecha_hora, estatus, id_jefe_autoriza
        FROM Prestamos WHERE id_empleado = ?
    """;

    try (Connection conn = conexionBD.crearConexion();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        conn.setAutoCommit(false); // 🔴 Inicia la transacción
        stmt.setInt(1, idEmpleado);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                prestamos.add(new PrestamoDominio(
                    rs.getInt("id_prestamo"),
                    new EmpleadoDominio(rs.getInt("id_empleado"), null, null, null, null, null, null, null, null),
                    new DepartamentoDominio(rs.getInt("id_departamento"), null),
                    new TipoPrestamoDominio(rs.getInt("id_tipo_prestamo"), null, 0),
                    rs.getDouble("monto"),
                    rs.getObject("fecha_hora", LocalDateTime.class),
                    obtenerEstatusPrestamo(rs.getString("estatus")),
                    new JefeDominio(rs.getInt("id_jefe_autoriza"), null)
                ));
            }
        }

        conn.commit(); // ✅ Confirma la transacción
        return prestamos;

    } catch (SQLException e) {
        throw new PersistenciaException("Error al obtener préstamos por empleado: " + e.getMessage());
    }
}

}
