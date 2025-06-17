package Persistencia;

import Dominio.TipoPrestamoDominio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoPrestamoDAO implements ITipoPrestamoDAO {
    private final IConexionBD conexionBD;

    public TipoPrestamoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public TipoPrestamoDominio crearTipoPrestamo(TipoPrestamoDominio tipoPrestamo) throws PersistenciaException {
        String query = """
            INSERT INTO Tipos_Prestamos (nombre, max_parcialidades) 
            VALUES (?, ?)
        """;

        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            conn.setAutoCommit(false); // 🔴 Inicia la transacción

            stmt.setString(1, tipoPrestamo.getNombre());
            stmt.setInt(2, tipoPrestamo.getMaxParcialidades());

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                conn.rollback();
                throw new PersistenciaException("No se pudo crear el tipo de préstamo.");
            }

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    tipoPrestamo.setId(rs.getInt(1));
                } else {
                    conn.rollback();
                    throw new PersistenciaException("No se pudo obtener el ID del tipo de préstamo creado.");
                }
            }

            conn.commit(); // ✅ Confirma la transacción
            return tipoPrestamo;

        } catch (SQLException e) {
            throw new PersistenciaException("Error al crear tipo de préstamo: " + e.getMessage());
        }
    }

    @Override
    public TipoPrestamoDominio actualizarTipoPrestamo(TipoPrestamoDominio tipoPrestamo) throws PersistenciaException {
        String query = """
            UPDATE Tipos_Prestamos SET nombre = ?, max_parcialidades = ? WHERE id_tipo_prestamo = ?
        """;

        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            conn.setAutoCommit(false); // 🔴 Inicia la transacción

            stmt.setString(1, tipoPrestamo.getNombre());
            stmt.setInt(2, tipoPrestamo.getMaxParcialidades());
            stmt.setInt(3, tipoPrestamo.getId());

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                conn.rollback();
                throw new PersistenciaException("No se encontró el tipo de préstamo con ID " + tipoPrestamo.getId());
            }

            conn.commit(); // ✅ Confirma la transacción
            return tipoPrestamo;

        } catch (SQLException e) {
            throw new PersistenciaException("Error al actualizar tipo de préstamo: " + e.getMessage());
        }
    }

    @Override
    public TipoPrestamoDominio obtenerTipoPrestamoPorId(int id) throws PersistenciaException {
        String query = """
            SELECT id_tipo_prestamo, nombre, max_parcialidades 
            FROM Tipos_Prestamos WHERE id_tipo_prestamo = ?
        """;

        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new TipoPrestamoDominio(
                        rs.getInt("id_tipo_prestamo"),
                        rs.getString("nombre"),
                        rs.getInt("max_parcialidades")
                    );
                }
                return null;
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener tipo de préstamo por ID: " + e.getMessage());
        }
    }

    @Override
    public List<TipoPrestamoDominio> obtenerTodosLosTiposPrestamo() throws PersistenciaException {
        List<TipoPrestamoDominio> tiposPrestamo = new ArrayList<>();
        String query = """
            SELECT id_tipo_prestamo, nombre, max_parcialidades 
            FROM Tipos_Prestamos
        """;

        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                tiposPrestamo.add(new TipoPrestamoDominio(
                    rs.getInt("id_tipo_prestamo"),
                    rs.getString("nombre"),
                    rs.getInt("max_parcialidades")
                ));
            }
            return tiposPrestamo;

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener todos los tipos de préstamo: " + e.getMessage());
        }
    }
}

