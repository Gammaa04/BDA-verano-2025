package Persistencia;

import Dominio.AbonoDominio;
import Dominio.PrestamoDominio;
import Dominio.JefeDominio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AbonoDAO implements IAbonoDAO {
    private final IConexionBD conexionBD;

    public AbonoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public AbonoDominio crearAbono(AbonoDominio abono) throws SQLException {
        String query = """
                     INSERT INTO Abonos (id_prestamo, monto, fecha_hora, id_jefe_autoriza)
                      VALUES (?, ?, ?, ?)
                        """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, abono.getPrestamo().getId());
            stmt.setDouble(2, abono.getMonto());
            stmt.setObject(3, abono.getFechaHora());
            stmt.setInt(4, abono.getJefeAutoriza().getId());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    abono.setId(rs.getInt(1));
                }
            }
            return abono;
        }
    }

    @Override
    public AbonoDominio obtenerAbonoPorId(int id) throws SQLException {
        String query = """
                     SELECT id_abono,
                     id_prestamo,
                     monto,
                     fecha_hora,
                     id_jefe_autoriza FROM Abonos WHERE id_abono = ?
        """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new AbonoDominio(
                        rs.getInt("id_abono"),
                        new PrestamoDominio(rs.getInt("id_prestamo"), null, null, null, 0, null, null, null),
                        rs.getDouble("monto"),
                        rs.getObject("fecha_hora", LocalDateTime.class),
                        new JefeDominio(rs.getInt("id_jefe_autoriza"), null)
                    );
                }
                return null;
            }
        }
    }

    @Override
    public List<AbonoDominio> obtenerAbonosPorPrestamo(int idPrestamo) throws SQLException {
        List<AbonoDominio> abonos = new ArrayList<>();
        String query = """
                     SELECT id_abono,
                     id_prestamo,
                     monto,
                     fecha_hora, 
                     id_jefe_autoriza FROM Abonos WHERE id_prestamo = ?
                     """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idPrestamo);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    abonos.add(new AbonoDominio(
                        rs.getInt("id_abono"),
                        new PrestamoDominio(rs.getInt("id_prestamo"), null, null, null, 0, null, null, null),
                        rs.getDouble("monto"),
                        rs.getObject("fecha_hora", LocalDateTime.class),
                        new JefeDominio(rs.getInt("id_jefe_autoriza"), null)
                    ));
                }
            }
        }
        return abonos;
    }
}
