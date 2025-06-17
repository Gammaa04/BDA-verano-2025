package Persistencia;

import Dominio.HistorialEstatusPrestamoDominio;
import Dominio.PrestamoDominio;
import Dominio.EstatusPrestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistorialEstatusPrestamo implements IHistorialEstatusPrestamoDAO {
    private final IConexionBD conexionBD;

    public HistorialEstatusPrestamo(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public HistorialEstatusPrestamoDominio crearHistorialEstatus(HistorialEstatusPrestamoDominio historial) throws PersistenciaException {
        String query = """
                     INSERT INTO Historial_Estatus_Prestamos (id_prestamo, estatus_anterior, estatus_nuevo, fecha_hora)
                     VALUES (?, ?, ?, ?)
                     """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, historial.getPrestamo().getId());
            stmt.setString(2, historial.getEstatusAnterior().name());
            stmt.setString(3, historial.getEstatusNuevo().name());
            stmt.setObject(4, historial.getFechaHora());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    historial.setId(rs.getInt(1));
                }
            }
            return historial;
        }catch(SQLException e){
            throw new PersistenciaException("");
        }
    }

    @Override
    public List<HistorialEstatusPrestamoDominio> obtenerHistorialPorPrestamo(int idPrestamo) throws PersistenciaException {
        List<HistorialEstatusPrestamoDominio> historial = new ArrayList<>();
        String query = """
                     SELECT id_historial,
                     id_prestamo,
                     estatus_anterior,
                     estatus_nuevo,
                     fecha_hora FROM Historial_Estatus_Prestamos WHERE id_prestamo = ?
        """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idPrestamo);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    historial.add(new HistorialEstatusPrestamoDominio(
                        rs.getInt("id_historial"),
                        new PrestamoDominio(rs.getInt("id_prestamo"), null, null, null, 0, null, null, null),
                        EstatusPrestamo.valueOf(rs.getString("estatus_anterior")),
                        EstatusPrestamo.valueOf(rs.getString("estatus_nuevo")),
                        rs.getObject("fecha_hora", LocalDateTime.class)
                    ));
                }
            }return historial;
        }catch(SQLException e){
            throw new PersistenciaException("");
        }
        
    }
}
