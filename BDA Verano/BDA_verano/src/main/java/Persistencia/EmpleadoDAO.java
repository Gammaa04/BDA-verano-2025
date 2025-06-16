/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Dominio.DepartamentoDominio;
import Dominio.EmpleadoDominio;
import Dominio.EstadoEmpleado;
import Dominio.TipoEmpleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class EmpleadoDAO {

    private IConexionBD conexion;

    public EmpleadoDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    public EmpleadoDominio buscarID(int id) throws PersistenciaException {

        try (Connection connection = this.conexion.crearConexion()) {
        String query = """
                       SELECT id_empleado, nombre, ap_paterno, ap_materno, usuario, contraseña, id_departamento, tipo 
                       FROM empleados
                       WHERE id_empleado=?;
                       """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next()) {
                    throw new PersistenciaException("No se encontró el empleado con id " + id);
                }

                int id2 = resultSet.getInt("id_empleado");
                String nombre = resultSet.getString("nombre");
                String apellidoPaterno = resultSet.getString("ap_paterno");
                String apellidoMaterno = resultSet.getString("ap_materno");
                String usuario = resultSet.getString("usuario");
                String contraseña = resultSet.getString("contraseña");
                int id_depa = resultSet.getInt("id_departamento");

                // Obtener el nombre del departamento sin crear otra conexión
                String query2 = "SELECT nombre FROM departamentos WHERE id_departamento=?";
                try (PreparedStatement preparedStatement2 = connection.prepareStatement(query2)) {
                    preparedStatement2.setInt(1, id_depa);
                    
                    try (ResultSet resul = preparedStatement2.executeQuery()) {
                        String nombreDepa = resul.next() ? resul.getString("nombre") : "Departamento desconocido";
                        DepartamentoDominio departamentoDominio = new DepartamentoDominio(id_depa, nombreDepa);

                        return new EmpleadoDominio(
                                id2,
                                nombre,
                                apellidoPaterno,
                                apellidoMaterno,
                                EstadoEmpleado.ACTIVO,
                                usuario, 
                                contraseña,
                                departamentoDominio,
                                TipoEmpleado.JEFE);
                    }
                }
            }
        }
    } catch (SQLException ex) {
        throw new PersistenciaException("Ocurrió un error al leer el empleado: " + ex.getMessage());
    }

    }

//    private EmpleadoDominio convertirEmpleadoDominio(ResultSet resultSet) throws SQLException {
//
//        Connection connection = this.conexion.crearConexion();
//        String query = """
//                           SELECT nombre FROM departamentos WHERE id_departamento=?;
//                           """;
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        preparedStatement.setInt(1, id_depa);
//
//        ResultSet resul = preparedStatement.executeQuery();
//
//        String nombreDepa = resul.getNString(1);
//        DepartamentoDominio departamentoDominio = new DepartamentoDominio(id_depa, nombreDepa);
//
//        return new EmpleadoDominio(id, nombre, apellidoPaterno, apellidoMaterno, EstadoEmpleado.ACTIVO, usuario, contraseña, departamentoDominio, TipoEmpleado.JEFE);
//    }

}
