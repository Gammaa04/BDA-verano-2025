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
    public CuentaDepartamentoDominio obtenerCuentaDepartamentoPorId(int id) throws SQLException {
        String query = """
                       SELECT id_cuenta,
                        id_departamento,
                        CLABE,
                        banco,
                        saldo, 
                        FROM Cuentas_Departamento
                        WHERE id_cuenta = ?
                                """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new CuentaDepartamentoDominio(
                        rs.getInt("id_cuenta"),
                        new DepartamentoDominio(rs.getInt("id_departamento"), null),
                        rs.getString("CLABE"),
                        rs.getString("banco"),
                        rs.getDouble("saldo")
                    );
                }
                return null;
            }
        }
    }

    @Override
    public List<CuentaDepartamentoDominio> obtenerCuentasPorDepartamento(int idDepartamento) throws SQLException {
        List<CuentaDepartamentoDominio> cuentas = new ArrayList<>();
        String query = """
                     SELECT id_cuenta,
                     id_departamento, 
                     CLABE,
                     banco,
                     saldo
                     FROM Cuentas_Departamento
                     WHERE id_departamento = ?
                     """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
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
            }
        }
        return cuentas;
    }
}
