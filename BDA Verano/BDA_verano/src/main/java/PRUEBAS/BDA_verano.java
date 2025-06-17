/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package PRUEBAS;

import DTO.EmpleadoDTO;
import Dominio.DepartamentoDominio;
import Dominio.EmpleadoDominio;
import Dominio.EstadoEmpleado;
import Dominio.TipoEmpleado;
import Persistencia.ConexionBD;
import Persistencia.EmpleadoDAO;
import Persistencia.IConexionBD;
import Persistencia.IEmpleadoDAO;
import Persistencia.PersistenciaException;
import java.sql.Connection;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class BDA_verano {

    public static void main(String[] args) {
        
        try {
            // Instancia la conexión a la base de datos
            IConexionBD conexion = new ConexionBD(); // Asegúrate de que esto está bien configurado
            IEmpleadoDAO empleadoDAO = new EmpleadoDAO(conexion);
            
            EmpleadoDominio empleadoDominio= empleadoDAO.buscarID(1);
            System.out.println("Empleado Encontrado "+empleadoDominio);
            System.out.println("ID empleado: "+ empleadoDominio.getId());
            System.out.println("nombre: "+empleadoDominio.getNombre());
            System.out.println("ap_paterno: "+empleadoDominio.getAp_paterno());
            System.out.println("ap_materno: "+empleadoDominio.getAp_materno());
            System.out.println("estado: "+empleadoDominio.getEstado());
            System.out.println("usuario: "+empleadoDominio.getUsuario());
            System.out.println("Contraseña: "+empleadoDominio.getContrasena());
            System.out.println("id_departamento: "+empleadoDominio.getDepartamento().getId());
            System.out.println("tipo: "+empleadoDominio.getTipo());
            
            System.out.println("------------------------------------------------");
            EmpleadoDominio nuevoEmpleado = new EmpleadoDominio(
                0, // Se asignará automáticamente el ID
                "Jorge",
                "Nitales",
                "Gozo",
                EstadoEmpleado.ACTIVO,
                "testi",
                "crotolamo",
                new DepartamentoDominio(1, "Recursos Humanos"), // ID y nombre del departamento
                TipoEmpleado.SUBORDINADO
            );
            
            EmpleadoDominio ed= empleadoDAO.crearEmpleado(nuevoEmpleado, 2);
            
            
            System.out.println("Empleado Creado "+ed);
            System.out.println("ID empleado: "+ ed.getId());
            System.out.println("nombre: "+ed.getNombre());
            System.out.println("ap_paterno: "+ed.getAp_paterno());
            System.out.println("ap_materno: "+ed.getAp_materno());
            System.out.println("estado: "+ed.getEstado());
            System.out.println("usuario: "+ed.getUsuario());
            System.out.println("Contraseña: "+ed.getContrasena());
            System.out.println("id_departamento: "+ed.getDepartamento().getId());
            System.out.println("tipo: "+ed.getTipo());
            
            
            
            
            
        } catch (Exception e) {
            
            System.err.println("FALLO EN MAIN : "+e.getMessage());
            
        }
        
        
        
        
        
        
        
        
        
        

    }
}
