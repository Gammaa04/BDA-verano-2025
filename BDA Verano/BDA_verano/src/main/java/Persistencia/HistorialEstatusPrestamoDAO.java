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

public class HistorialEstatusPrestamoDAO implements IHistorialEstatusPrestamoDAO {

    private final IConexionBD conexionBD;

    public HistorialEstatusPrestamoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public HistorialEstatusPrestamoDominio crearHistorialEstatus(HistorialEstatusPrestamoDominio historial) throws PersistenciaException {
        String query = """
            INSERT INTO Historial_Estatus_Prestamos (id_prestamo, estatus_anterior, estatus_nuevo, fecha_hora)
            VALUES (?, ?, ?, ?)
        """;
        try (Connection conn = conexionBD.crearConexion(); PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            conn.setAutoCommit(false); // 🔴 Inicia la transacción

            stmt.setInt(1, historial.getPrestamo().getId());
            stmt.setString(2, historial.getEstatusAnterior().name());
            stmt.setString(3, historial.getEstatusNuevo().name());
            stmt.setObject(4, historial.getFechaHora());

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                conn.rollback();
                throw new PersistenciaException("No se pudo crear el historial de estatus.");
            }

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    historial.setId(rs.getInt(1));
                } else {
                    conn.rollback();
                    throw new PersistenciaException("No se pudo obtener el ID del historial creado.");
                }
            }

            conn.commit(); // ✅ Confirma la transacción
            return historial;

        } catch (SQLException e) {
            throw new PersistenciaException("Error al crear historial de estatus: " + e.getMessage());
        }
    }

    @Override
   public List<HistorialEstatusPrestamoDominio> obtenerHistorialPorPrestamo(int idPrestamo) throws PersistenciaException {
    List<HistorialEstatusPrestamoDominio> historial = new ArrayList<>();
    String query = """
        SELECT id_historial, id_prestamo, estatus_anterior, estatus_nuevo, fecha_hora 
        FROM Historial_Estatus_Prestamos WHERE id_prestamo = ?
    """;

    try (Connection conn = conexionBD.crearConexion(); PreparedStatement stmt = conn.prepareStatement(query)) {
        conn.setAutoCommit(false); // 🔴 Inicia la transacción
        stmt.setInt(1, idPrestamo);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // ✅ Manejo de ENUM con IFs anidados
                EstatusPrestamo estatusAnterior = null;
                EstatusPrestamo estatusNuevo = null;

                String strEstatusAnterior = rs.getString("estatus_anterior");
                String strEstatusNuevo = rs.getString("estatus_nuevo");

                if (strEstatusAnterior.equals("Creado")) {
                    estatusAnterior = EstatusPrestamo.CREADO;
                } else if (strEstatusAnterior.equals("Rechazado")) {
                    estatusAnterior = EstatusPrestamo.RECHAZADO;
                } else if (strEstatusAnterior.equals("Autorizado")) {
                    estatusAnterior = EstatusPrestamo.AUTORIZADO;
                } else if (strEstatusAnterior.equals("Abonado parcialmente")) {
                    estatusAnterior = EstatusPrestamo.ABONADO_PARCIALMENTE;
                } else if (strEstatusAnterior.equals("Pagado")) {
                    estatusAnterior = EstatusPrestamo.PAGADO;
                } else if (strEstatusAnterior.equals("Completado")) {
                    estatusAnterior = EstatusPrestamo.COMPLETADO;
                }

                if (strEstatusNuevo.equals("Creado")) {
                    estatusNuevo = EstatusPrestamo.CREADO;
                } else if (strEstatusNuevo.equals("Rechazado")) {
                    estatusNuevo = EstatusPrestamo.RECHAZADO;
                } else if (strEstatusNuevo.equals("Autorizado")) {
                    estatusNuevo = EstatusPrestamo.AUTORIZADO;
                } else if (strEstatusNuevo.equals("Abonado parcialmente")) {
                    estatusNuevo = EstatusPrestamo.ABONADO_PARCIALMENTE;
                } else if (strEstatusNuevo.equals("Pagado")) {
                    estatusNuevo = EstatusPrestamo.PAGADO;
                } else if (strEstatusNuevo.equals("Completado")) {
                    estatusNuevo = EstatusPrestamo.COMPLETADO;
                }

                historial.add(new HistorialEstatusPrestamoDominio(
                    rs.getInt("id_historial"),
                    new PrestamoDominio(rs.getInt("id_prestamo"), null, null, null, 0, null, null, null),
                    estatusAnterior,
                    estatusNuevo,
                    rs.getObject("fecha_hora", LocalDateTime.class)
                ));
            }

            conn.commit(); // ✅ Confirma la transacción antes de devolver resultados
            return historial;
        }

    } catch (SQLException e) {
        throw new PersistenciaException("Error al obtener historial por préstamo: " + e.getMessage());
    }
}

}
