package Persistencia;

import Dominio.DepartamentoDominio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO implements IDepartamentoDAO {
    private final IConexionBD conexionBD;

    public DepartamentoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public DepartamentoDominio actualizarDepartamento(DepartamentoDominio departamento) throws PersistenciaException {
        String query = """
            UPDATE Departamentos 
            SET nombre = ? 
            WHERE id_departamento = ?
        """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            conn.setAutoCommit(false); // 🔴 Inicia la transacción

            stmt.setString(1, departamento.getNombre());
            stmt.setInt(2, departamento.getId());

            int rows = stmt.executeUpdate();
            if (rows == 0) {
                conn.rollback();
                throw new PersistenciaException("No se encontró el departamento con ID " + departamento.getId());
            }

            conn.commit(); // ✅ Confirma la transacción
            return departamento;

        } catch (SQLException e) {
            throw new PersistenciaException("Error al actualizar departamento: " + e.getMessage());
        }
    }

    @Override
    public DepartamentoDominio obtenerDepartamentoPorId(int id) throws PersistenciaException {
        String query = """
            SELECT id_departamento, nombre 
            FROM Departamentos
            WHERE id_departamento = ?
        """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            conn.setAutoCommit(false); // 🔴 Inicia la transacción
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    DepartamentoDominio departamento = new DepartamentoDominio(
                        rs.getInt("id_departamento"),
                        rs.getString("nombre")
                    );

                    conn.commit(); // ✅ Confirma la transacción
                    return departamento;
                } else {
                    conn.rollback();
                    throw new PersistenciaException("No se encontró el departamento con ID " + id);
                }
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener departamento por ID: " + e.getMessage());
        }
    }

    @Override
    public List<DepartamentoDominio> obtenerTodosLosDepartamentos() throws PersistenciaException {
        List<DepartamentoDominio> departamentos = new ArrayList<>();
        String query = """
            SELECT id_departamento, nombre 
            FROM Departamentos
        """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            conn.setAutoCommit(false); // 🔴 Inicia la transacción

            while (rs.next()) {
                departamentos.add(new DepartamentoDominio(
                    rs.getInt("id_departamento"),
                    rs.getString("nombre")
                ));
            }

            conn.commit(); // ✅ Confirma la transacción
            return departamentos;

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener todos los departamentos: " + e.getMessage());
        }
    }
}

