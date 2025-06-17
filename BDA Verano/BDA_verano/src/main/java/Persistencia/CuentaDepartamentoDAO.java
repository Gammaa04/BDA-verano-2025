package Persistencia;

import Dominio.CuentaDepartamentoDominio;
import Dominio.DepartamentoDominio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuentaDepartamentoDAO implements ICuentaDepartamentoDAO {
    private final IConexionBD conexionBD;

    public CuentaDepartamentoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public CuentaDepartamentoDominio obtenerCuentaDepartamentoPorId(int id) throws PersistenciaException {
        String query = """
            SELECT id_cuenta, id_departamento, CLABE, banco, saldo
            FROM Cuentas_Departamento
            WHERE id_cuenta = ?
        """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            conn.setAutoCommit(false); // 🔴 Inicia la transacción
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    CuentaDepartamentoDominio cuenta = new CuentaDepartamentoDominio(
                        rs.getInt("id_cuenta"),
                        new DepartamentoDominio(rs.getInt("id_departamento"), null),
                        rs.getString("CLABE"),
                        rs.getString("banco"),
                        rs.getDouble("saldo")
                    );

                    conn.commit(); // ✅ Confirma la transacción antes de devolver resultados
                    return cuenta;
                } else {
                    conn.rollback();
                    throw new PersistenciaException("No se encontró la cuenta de departamento con ID " + id);
                }
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener cuenta de departamento por ID: " + e.getMessage());
        }
    }

    @Override
    public List<CuentaDepartamentoDominio> obtenerCuentasPorDepartamento(int idDepartamento) throws PersistenciaException {
        List<CuentaDepartamentoDominio> cuentas = new ArrayList<>();
        String query = """
            SELECT id_cuenta, id_departamento, CLABE, banco, saldo
            FROM Cuentas_Departamento
            WHERE id_departamento = ?
        """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            conn.setAutoCommit(false); // 🔴 Inicia la transacción
            stmt.setInt(1, idDepartamento);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    cuentas.add(new CuentaDepartamentoDominio(
                        rs.getInt("id_cuenta"),
                        new DepartamentoDominio(rs.getInt("id_departamento"), null),
                        rs.getString("CLABE"),
                        rs.getString("banco"),
                        rs.getDouble("saldo")
                    ));
                }

                conn.commit(); // ✅ Confirma la transacción antes de devolver resultados
                return cuentas;
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener cuentas por departamento: " + e.getMessage());
        }
    }
}

