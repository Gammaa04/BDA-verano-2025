package Persistencia;

import DTO.EmpleadoDTO;
import Dominio.CuentaEmpleadoDominio;
import Dominio.EmpleadoDominio;
import Dominio.EstadoCuenta;
import Dominio.TipoEmpleado;
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
    public CuentaEmpleadoDominio crearCuentaEmpleado(CuentaEmpleadoDominio cuenta) throws PersistenciaException {
        String query = """
            INSERT INTO Cuentas_Empleado (id_empleado, CLABE, banco, estado)
            VALUES (?, ?, ?, ?)
        """;
        try (Connection conn = conexionBD.crearConexion(); PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            conn.setAutoCommit(false); // 🔴 Inicia la transacción

            stmt.setInt(1, cuenta.getEmpleado().getId());
            stmt.setString(2, cuenta.getClabe());
            stmt.setString(3, cuenta.getBanco());

            stmt.setString(4, "Activa");

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas == 0) {
                conn.rollback(); // 🔄 Revertir si no se insertó
                throw new PersistenciaException("No se pudo crear la cuenta del empleado.");
            }

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    cuenta.setId(rs.getInt(1));
                } else {
                    conn.rollback();
                    throw new PersistenciaException("No se pudo obtener el ID de la cuenta creada.");
                }
            }

            conn.commit(); // ✅ Confirma la transacción
            return cuenta;

        } catch (SQLException e) {
            throw new PersistenciaException("Error al crear cuenta: " + e.getMessage());
        }
    }

    @Override
    public CuentaEmpleadoDominio actualizarCuentaEmpleado(CuentaEmpleadoDominio cuenta) throws PersistenciaException {
        String query = """
            UPDATE Cuentas_Empleado
            SET CLABE = ?, banco = ?, estado = ? WHERE id_cuenta = ?
        """;
        try (Connection conn = conexionBD.crearConexion(); PreparedStatement stmt = conn.prepareStatement(query)) {

            conn.setAutoCommit(false); // 🔴 Inicia la transacción
            stmt.setString(1, cuenta.getClabe());
            stmt.setString(2, cuenta.getBanco());
            stmt.setString(3, cuenta.getEstado().name());
            stmt.setInt(4, cuenta.getId());

            int rows = stmt.executeUpdate();
            if (rows == 0) {
                conn.rollback();
                throw new PersistenciaException("No se encontró la cuenta con ID " + cuenta.getId());
            }
            conn.commit(); // ✅ Confirma la transacción
            return cuenta;

        } catch (SQLException e) {
            throw new PersistenciaException("Error al actualizar cuenta: " + e.getMessage());
        }
    }

    @Override
    public CuentaEmpleadoDominio obtenerCuentaEmpleadoPorId(int id) throws PersistenciaException {
        String query = """
            SELECT id_cuenta, id_empleado, CLABE, banco, estado
            FROM Cuentas_Empleado WHERE id_cuenta = ?
        """;
        try (Connection conn = conexionBD.crearConexion(); PreparedStatement stmt = conn.prepareStatement(query)) {

            conn.setAutoCommit(false); // 🔴 Inicia la transacción
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    EmpleadoDTO empleadoDTO = new EmpleadoDTO();
                    empleadoDTO.setId(rs.getInt("id_empleado"));

                    CuentaEmpleadoDominio cuentaEmpleadoDominio;

                    if (rs.getString("estado").equalsIgnoreCase("Activa")) {
                        cuentaEmpleadoDominio = new CuentaEmpleadoDominio(
                                rs.getInt("id_cuenta"),
                                empleadoDTO,
                                rs.getString("CLABE"),
                                rs.getString("banco"),
                                EstadoCuenta.ACTIVA
                        );

                    } else {
                        cuentaEmpleadoDominio = new CuentaEmpleadoDominio(
                                rs.getInt("id_cuenta"),
                                empleadoDTO,
                                rs.getString("CLABE"),
                                rs.getString("banco"),
                                EstadoCuenta.INACTIVA
                        );
                    }
                    conn.commit(); // ✅ Confirma la transacción
                    return cuentaEmpleadoDominio;

                } else {
                    conn.rollback();
                    throw new PersistenciaException("No se encontró la cuenta con ID " + id);
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener cuenta por ID: " + e.getMessage());
        }
    }

    @Override
    public List<CuentaEmpleadoDominio> obtenerCuentasPorEmpleado(int idEmpleado) throws PersistenciaException {
        List<CuentaEmpleadoDominio> cuentas = new ArrayList<>();
        String query = """
            SELECT id_cuenta, id_empleado, CLABE, banco, estado
            FROM Cuentas_Empleado WHERE id_empleado = ?
        """;
        try (Connection conn = conexionBD.crearConexion(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idEmpleado);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    EmpleadoDTO empleadoDTO = new EmpleadoDTO();
                    empleadoDTO.setId(rs.getInt("id_empleado"));

                    CuentaEmpleadoDominio cuentaEmpleadoDominio;

                    if (rs.getString("estado").equalsIgnoreCase("Activa")) {
                        cuentaEmpleadoDominio = new CuentaEmpleadoDominio(
                                rs.getInt("id_cuenta"),
                                empleadoDTO,
                                rs.getString("CLABE"),
                                rs.getString("banco"),
                                EstadoCuenta.ACTIVA
                        );

                    } else {
                        cuentaEmpleadoDominio = new CuentaEmpleadoDominio(
                                rs.getInt("id_cuenta"),
                                empleadoDTO,
                                rs.getString("CLABE"),
                                rs.getString("banco"),
                                EstadoCuenta.INACTIVA
                        );
                    }

                    cuentas.add(cuentaEmpleadoDominio);

                }
            }
            return cuentas;

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener cuentas por empleado: " + e.getMessage());
        }
    }
}
