/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interfaz que define el contrato para las clases encargadas de **establecer una conexión
 * con una base de datos**. 
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public interface IConexionBD {

    /**
     * Crea y devuelve un objeto de conexión a la base de datos.
     * La implementación de este método debe manejar los detalles específicos
     * de cómo se establece la conexión (por ejemplo, credenciales, URL de la base de datos).
     *
     * @return Un objeto {@link Connection} que representa una conexión activa a la base de datos.
     * @throws SQLException Si ocurre un error durante el proceso de conexión a la base de datos.
     
     */
    Connection crearConexion() throws SQLException;

}
