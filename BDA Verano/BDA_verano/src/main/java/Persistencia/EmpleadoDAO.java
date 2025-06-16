/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import DTO.EmpleadoDTO;
import DTO.FiltroTablaEmpleadoDTO;
import Dominio.DepartamentoDominio;
import Dominio.EmpleadoDominio;
import Dominio.EstadoEmpleado;
import Dominio.TipoEmpleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class EmpleadoDAO implements IEmpleadoDAO {

    private IConexionBD conexion;

    public EmpleadoDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    public EmpleadoDominio buscarID(int id) throws PersistenciaException {

        try {
            Connection connection = this.conexion.crearConexion();
            String query = """
                       SELECT id_empleado, nombre, ap_paterno, ap_materno, usuario, contraseña, id_departamento, tipo 
                       FROM empleados
                       WHERE id_empleado=?;
                       """;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                resultSet.close();
                preparedStatement.close();
                connection.close();
                throw new PersistenciaException("No se encontró el empleado con id " + id);
            }

            int id2 = resultSet.getInt("id_empleado");
            String nombre = resultSet.getString("nombre");
            String apellidoMaterno = resultSet.getString("ap_materno");
            String apellidoPaterno = resultSet.getString("ap_paterno");
            String usuario = resultSet.getString("usuario");
            String contraseña = resultSet.getString("contraseña");
            int id_depa = resultSet.getInt("id_departamento");

            resultSet.close();
            preparedStatement.close();

            // Obtener el nombre del departamento con la misma conexión
            String query2 = """
                       SELECT nombre FROM departamentos WHERE id_departamento=?;
                       """;
            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            preparedStatement2.setInt(1, id_depa);
            ResultSet resul = preparedStatement2.executeQuery();

            String nombreDepa = "no aidepa";
            if (resul.next()) {
                nombreDepa = resul.getString("nombre");
            }

            if (nombreDepa.equals("no aidepa")) {
                throw new PersistenciaException("No se encontró departamento en el empleado");
            }

            resul.close();
            preparedStatement2.close();
            connection.close();

            DepartamentoDominio departamentoDominio = new DepartamentoDominio(id_depa, nombreDepa);

            EmpleadoDominio empleado = new EmpleadoDominio(
                    id2,
                    nombre,
                    apellidoPaterno,
                    apellidoMaterno,
                    EstadoEmpleado.ACTIVO,
                    usuario,
                    contraseña,
                    departamentoDominio,
                    TipoEmpleado.JEFE);

            return empleado;

        } catch (SQLException ex) {
            throw new PersistenciaException("Ocurrió un error al leer el empleado: " + ex.getMessage());
        }

    }

    @Override
    public List<EmpleadoDTO> buscarTabla(FiltroTablaEmpleadoDTO filtros) throws PersistenciaException {

        try {
            Connection connection = this.conexion.crearConexion();
            String query = """
                       SELECT
                       	id_empleado,
                       	nombre,
                       	ap_paterno,
                       	ap_materno,
                       	(CASE WHEN estado = 'Activo' THEN 'SI' ELSE 'NO' END) AS activo
                       
                       FROM Empleados
                       WHERE 
                       			  nombre LIKE ?
                       			  OR ap_paterno LIKE ?
                       			  OR COALESCE(ap_materno, '') LIKE ?
                       			  OR (CASE WHEN estado = 'Activo' THEN 'SI' ELSE 'NO' END) LIKE ?
                       ORDER BY nombre,
                       		ap_paterno,
                       		ap_materno
                       LIMIT ?
                       OFFSET ?;
                       """;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            String filtrotabla = "%" + filtros.getFiltro() + "%";
            preparedStatement.setString(1, filtrotabla);
            preparedStatement.setString(2, filtrotabla);
            preparedStatement.setString(3, filtrotabla);
            preparedStatement.setString(4, filtrotabla);
            preparedStatement.setInt(5, filtros.getLimit());
            preparedStatement.setInt(6, filtros.getOffset());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                connection.close();
                resultSet.close();
                preparedStatement.close();
                throw new PersistenciaException("No hay resultados con el filtro");
            }

            List<EmpleadoDTO> empleados = new LinkedList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombres");
                String apellidoPaterno = resultSet.getString("apellidoPaterno");
                String apellidoMaterno = resultSet.getString("apellidoMaterno");
                String activo = resultSet.getString("activo");

                if (activo == "activo") {
                    empleados.add(new EmpleadoDTO(id, nombre, apellidoPaterno, apellidoMaterno, EstadoEmpleado.ACTIVO, query, id, TipoEmpleado.JEFE));
                } else {
                    empleados.add(new EmpleadoDTO(id, nombre, apellidoPaterno, apellidoMaterno, EstadoEmpleado.INACTIVO, query, id, TipoEmpleado.JEFE));
                }
            }

            if (empleados.isEmpty()) {
                throw new PersistenciaException("No fueron encontrados los empleados");
            }

            return empleados;

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }

    }

    @Override
    public EmpleadoDominio modificarEmpleado(EmpleadoDTO empleado) throws PersistenciaException {
        try {
            Connection connection = this.conexion.crearConexion();
            String query = """
                       UPDATE empleados
                       SET nombre = ?,
                          ap_paterno = ?,
                          ap_materno = ? 
                       WHERE id_empleado = ?;
                       """;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, empleado.getNombre());
            preparedStatement.setString(2, empleado.getAp_paterno());
            preparedStatement.setString(3, empleado.getAp_materno());
            preparedStatement.setInt(4, empleado.getId());
            preparedStatement.executeQuery();

            return buscarID(empleado.getId());

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }

    }

    @Override
    public EmpleadoDominio crearEmpleado(EmpleadoDominio empleado, int idJefe) throws PersistenciaException {
        try {
            if (buscarID(idJefe) == null) {
                throw new PersistenciaException("No se encontró el empleado superior");
            }

            Connection connection = this.conexion.crearConexion();
            String query = """
                       SELECT id_empleado FROM Jefes;
                       """;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<EmpleadoDTO> Jefes = new LinkedList<>();

            boolean isEncontrado = false;
            while (resultSet.next()) {
                if (resultSet.getInt(1) == idJefe) {
                    isEncontrado = true;
                    break;
                }
            }

            if (!isEncontrado) {
                throw new PersistenciaException("tu id no tiene los poderes");
            }
         
            String query2 = """
                       INSERT INTO empleados(
                           nombre,
                           ap_paterno,
                           ap_materno,
                           estado,
                           usuario,
                           contraseña,
                           id_departamento,
                           tipo
                       ) VALUES(
                       	   ?,
                           ?,
                           ?,
                           ?,
                           ?,
                           ?,
                           ?,
                           ?
                       );
                       """;
            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            preparedStatement.setString(1, empleado.getNombre());
            preparedStatement.setString(2, empleado.getAp_paterno());
            preparedStatement.setString(3, empleado.getAp_materno());

            if (empleado.getEstado().equals(EstadoEmpleado.ACTIVO)) {
                preparedStatement.setString(4, "ACTIVO");
            } else {
                preparedStatement.setString(4, "INACTIVO");
            }

            preparedStatement.setString(5, empleado.getUsuario());
            preparedStatement.setString(6, empleado.getContrasena());
            preparedStatement.setInt(7, empleado.getDepartamento().getId());

            preparedStatement2.executeQuery();
            
            String query3 = """
                       SELECT last_insert_id();
                       """;
            PreparedStatement preparedStatement3 = connection.prepareStatement(query3);
            ResultSet resultSet3 = preparedStatement.executeQuery();
            
            return buscarID(resultSet3.getInt(1));


        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }

    }

}
