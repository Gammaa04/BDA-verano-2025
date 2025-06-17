/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package PRUEBAS;

import DTO.EmpleadoDTO;
import Dominio.CuentaEmpleadoDominio;
import Dominio.DepartamentoDominio;
import Dominio.EmpleadoDominio;
import Dominio.EstadoCuenta;
import Dominio.EstadoEmpleado;
import Dominio.TipoEmpleado;
import Persistencia.ConexionBD;
import Persistencia.CuentaEmpleadoDAO;
import Persistencia.EmpleadoDAO;
import Persistencia.IConexionBD;
import Persistencia.ICuentaEmpleadoDAO;
import Persistencia.IEmpleadoDAO;
import Persistencia.PersistenciaException;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class BDA_verano {

    public static void main(String[] args) {
        try {
            // Inicializar la conexión a la base de datos
            IConexionBD conexionBD = new ConexionBD(); // Asegúrate de que esto está bien configurado
            ICuentaEmpleadoDAO cuentaDAO = new CuentaEmpleadoDAO(conexionBD);

            // Crear un empleado de prueba
        EmpleadoDTO empleado = new EmpleadoDTO(
                    21, // Se asignará automáticamente el ID
                    "Jorge",
                    "Nitales",
                    "Gozo",
                    EstadoEmpleado.ACTIVO,
                    "crotolamo",
                    1, // ID y nombre del departamento
                    TipoEmpleado.SUBORDINADO
            );
            // Crear una cuenta para el empleado
            CuentaEmpleadoDominio nuevaCuenta = new CuentaEmpleadoDominio(0, empleado, "42123124", "Banco XYZ", EstadoCuenta.ACTIVA);
            CuentaEmpleadoDominio cuentaCreada = cuentaDAO.crearCuentaEmpleado(nuevaCuenta);
            System.out.println("Cuenta creada exitosamente: " + cuentaCreada);

            // Actualizar la cuenta con nuevos datos
            cuentaCreada.setBanco("Banco ABC");
            cuentaCreada.setEstado(EstadoCuenta.INACTIVA);
            CuentaEmpleadoDominio cuentaActualizada = cuentaDAO.actualizarCuentaEmpleado(cuentaCreada);
            System.out.println("Cuenta actualizada exitosamente: " + cuentaActualizada);

            // Obtener cuenta por ID
            CuentaEmpleadoDominio cuentaPorId = cuentaDAO.obtenerCuentaEmpleadoPorId(cuentaCreada.getId());
            System.out.println("Cuenta obtenida por ID: " + cuentaPorId);

            // Obtener todas las cuentas de un empleado
            List<CuentaEmpleadoDominio> cuentasPorEmpleado = cuentaDAO.obtenerCuentasPorEmpleado(empleado.getId());
            System.out.println("Cuentas del empleado " + empleado.getNombre() + ":");
            for (CuentaEmpleadoDominio cuenta : cuentasPorEmpleado) {
                System.out.println(cuenta);
            }

        } catch (PersistenciaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



