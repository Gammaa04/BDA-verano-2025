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
    public TipoPrestamoDominio crearTipoPrestamo(TipoPrestamoDominio tipoPrestamo) throws SQLException {
        String query = """
                     INSERT INTO Tipos_Prestamos (nombre, max_parcialidades) 
                     VALUES (?, ?)
                     """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, tipoPrestamo.getNombre());
            stmt.setInt(2, tipoPrestamo.getMaxParcialidades());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    tipoPrestamo.setId(rs.getInt(1));
                }
            }
            return tipoPrestamo;
        }
    }

    @Override
    public TipoPrestamoDominio actualizarTipoPrestamo(TipoPrestamoDominio tipoPrestamo) throws SQLException {
        String query = """
                       UPDATE Tipos_Prestamos SET nombre = ?,
                       max_parcialidades = ? WHERE id_tipo_prestamo = ?
                       """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tipoPrestamo.getNombre());
            stmt.setInt(2, tipoPrestamo.getMaxParcialidades());
            stmt.setInt(3, tipoPrestamo.getId());
            int rows = stmt.executeUpdate();
            if (rows == 0) {
                throw new SQLException("No se encontró el tipo de préstamo con ID " + tipoPrestamo.getId());
            }
            return tipoPrestamo;
        }
    }

    @Override
    public TipoPrestamoDominio obtenerTipoPrestamoPorId(int id) throws SQLException {
        String query = """
                     SELECT id_tipo_prestamo,
                     nombre,
                     max_parcialidades FROM Tipos_Prestamos WHERE id_tipo_prestamo = ?
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
        }
    }

    @Override
    public List<TipoPrestamoDominio> obtenerTodosLosTiposPrestamo() throws SQLException {
        List<TipoPrestamoDominio> tiposPrestamo = new ArrayList<>();
        String query = """
                     SELECT id_tipo_prestamo,
                     nombre,
                     max_parcialidades FROM Tipos_Prestamos
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
        }
        return tiposPrestamo;
    }
}
