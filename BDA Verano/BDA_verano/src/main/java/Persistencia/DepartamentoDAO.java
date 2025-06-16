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
    public DepartamentoDominio actualizarDepartamento(DepartamentoDominio departamento) throws SQLException {
        String query = """
                     UPDATE Departamentos 
                     SET nombre = ? 
                     WHERE id_departamento = ?
                     """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, departamento.getNombre());
            stmt.setInt(2, departamento.getId());
            int rows = stmt.executeUpdate();
            if (rows == 0) {
                throw new SQLException("No se encontró el departamento con ID " + departamento.getId());
            }
            return departamento;
        }
    }

    
    @Override
    public DepartamentoDominio obtenerDepartamentoPorId(int id) throws SQLException {
        String query = """
                       SELECT id_departamento,
                       nombre FROM Departamentos
                       WHERE id_departamento = ?
                       """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new DepartamentoDominio(rs.getInt("id_departamento"), rs.getString("nombre"));
                }
                return null;
            }
        }
    }

    
    @Override
    public List<DepartamentoDominio> obtenerTodosLosDepartamentos() throws SQLException {
        List<DepartamentoDominio> departamentos = new ArrayList<>();
        String query = """
                       SELECT id_departamento,
                       nombre FROM Departamentos
                       """;
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                departamentos.add(new DepartamentoDominio(rs.getInt("id_departamento"), rs.getString("nombre")));
            }
        }
        return departamentos;
    }
}
