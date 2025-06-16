/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Dominio.EmpleadoDominio;
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

        try {
            Connection connection = this.conexion.crearConexion();
            String query = """
                           SELECT nombre,ap_paterno,ap_materno,
                            estado,usuario,
                            (SELECT nombre 
                            FROM departamentos d 
                            WHERE d.id_departamento=e.id_departamento )
                            as departamento, tipo 
                            FROM empleados e;
                           WHERE id_empleado=?
                           """;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            EmpleadoDominio empleado = null;
            while (resultSet.next()) {
                empleado = this.convertirEmpleadoDominio(resultSet);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

            if (empleado == null) {
                throw new PersistenciaException("No se encontró el alumno con id " + id);
            }

            return empleado;

        } catch (SQLException ex) {
            throw new PersistenciaException("Ocurrion un error en leer un alumno " + ex.getMessage());
        }

    }

    private EmpleadoDominio convertirEmpleadoDominio(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");;
        String nombre = resultSet.getString("nombre");;
        String apellidoPaterno = resultSet.getString("ap_paterno");;
        String apellidoMaterno = resultSet.getString("ap_materno");;
        String usuario = resultSet.getString("usuario");;
        String contraseña = resultSet.getString("contraseña");
        return new EmpleadoDominio(id, nombre, apellidoPaterno, apellidoMaterno, usuario, contraseña, true);
    }

}
