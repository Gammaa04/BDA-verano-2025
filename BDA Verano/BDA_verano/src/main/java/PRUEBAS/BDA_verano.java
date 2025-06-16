/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package PRUEBAS;

import Dominio.EmpleadoDominio;
import Persistencia.ConexionBD;
import Persistencia.EmpleadoDAO;
import Persistencia.IConexionBD;
import Persistencia.PersistenciaException;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class BDA_verano {

    public static void main(String[] args) {
        try {
            // Crear instancia de la clase DAO
            IConexionBD conexion = new ConexionBD();
            EmpleadoDAO empleadoDAO = new EmpleadoDAO(conexion);

            // ID de empleado de prueba (ajusta según los datos en tu BD)
            int idEmpleadoPrueba = 7;

            // Buscar empleado por ID
            EmpleadoDominio empleado = empleadoDAO.buscarID(idEmpleadoPrueba);

            // Mostrar resultado
            System.out.println("Empleado encontrado:");
            System.out.println("ID: " + empleado.getId());
            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("Apellido Paterno: " + empleado.getAp_paterno());
            System.out.println("Apellido Materno: " + empleado.getAp_materno());
            System.out.println("Usuario: " + empleado.getUsuario());
            System.out.println("Departamento: " + empleado.getDepartamento().getNombre());
            System.out.println("Tipo: " + empleado.getTipo());

        } catch (PersistenciaException e) {
            // Capturar y mostrar errores
            System.err.println("Error al buscar empleado: " + e.getMessage());
        }

    }
}
