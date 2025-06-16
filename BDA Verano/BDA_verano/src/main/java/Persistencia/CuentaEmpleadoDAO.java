package Persistencia;

import Dominio.CuentaEmpleadoDominio;
import Dominio.EmpleadoDominio;
import Dominio.EstadoCuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuentaEmpleadoDAO implements ICuentaEmpleadoDAO {
    private final IConexionBD conexionBD;

    public CuentaEmpleadoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public CuentaEmpleadoDominio crearCuentaEmpleado(CuentaEmpleadoDominio cuenta) throws SQLException {
        String query = """
                     INSERT INTO Cuentas_Empleado (id_empleado, CLABE, banco, estado)
                     VALUES (?, ?, ?, ?)
                     """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, cuenta.getEmpleado().getId());
            stmt.setString(2, cuenta.getClabe());
            stmt.setString(3, cuenta.getBanco());
            stmt.setString(4, cuenta.getEstado().name());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    cuenta.setId(rs.getInt(1));
                }
            }
            return cuenta;
        }
    }

    @Override
    public CuentaEmpleadoDominio actualizarCuentaEmpleado(CuentaEmpleadoDominio cuenta) throws SQLException {
        String query = """
                     UPDATE Cuentas_Empleado
                     SET id_empleado = ?,
                     CLABE = ?,
                     banco = ?,
                     estado = ? WHERE id_cuenta = ?
                     """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, cuenta.getEmpleado().getId());
            stmt.setString(2, cuenta.getClabe());
            stmt.setString(3, cuenta.getBanco());
            stmt.setString(4, cuenta.getEstado().name());
            stmt.setInt(5, cuenta.getId());
            int rows = stmt.executeUpdate();
            if (rows == 0) {
                throw new SQLException("No se encontró la cuenta con ID " + cuenta.getId());
            }
            return cuenta;
        }
    }

    @Override
    public CuentaEmpleadoDominio obtenerCuentaEmpleadoPorId(int id) throws SQLException {
        String query = """
                     SELECT id_cuenta,
                     id_empleado,
                     CLABE,
                     banco,
                     estado FROM Cuentas_Empleado WHERE id_cuenta = ?
                     """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new CuentaEmpleadoDominio(
                        rs.getInt("id_cuenta"),
                        new EmpleadoDominio(rs.getInt("id_empleado"), null, null, null, null, null, null,null,null),
                        rs.getString("CLABE"),
                        rs.getString("banco"),
                        EstadoCuenta.valueOf(rs.getString("estado"))
                    );
                }
                return null;
            }
        }
    }

    @Override
    public List<CuentaEmpleadoDominio> obtenerCuentasPorEmpleado(int idEmpleado) throws SQLException {
        List<CuentaEmpleadoDominio> cuentas = new ArrayList<>();
        String query = """
                     SELECT id_cuenta,
                     id_empleado,
                     CLABE,
                     banco,
                     estado FROM Cuentas_Empleado WHERE id_empleado = ?
        """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idEmpleado);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    cuentas.add(new CuentaEmpleadoDominio(
                        rs.getInt("id_cuenta"),
                        new EmpleadoDominio(rs.getInt("id_empleado"), null, null, null, null, null, null,null,null),
                        rs.getString("CLABE"),
                        rs.getString("banco"),
                        EstadoCuenta.valueOf(rs.getString("estado"))
                    ));
                }
            }
        }
        return cuentas;
    }
}
