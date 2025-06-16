/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que implementa la interfaz {@link IConexionBD} y se encarga de establecer
 * la conexión con la base de datos MySQL. Contiene los parámetros de conexión
 * necesarios como la dirección del servidor, el nombre de la base de datos,
 * el usuario y la contraseña.
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class ConexionBD implements IConexionBD {
    /**
     * La dirección IP o nombre del servidor de la base de datos MySQL.
     */
    private final String SERVER = "127.0.0.1";

    /**
     * El nombre de la base de datos a la que se desea conectar.
     */
    private final String BASE_DATOS = "finanzasglobales";

    /**
     * La cadena completa de conexión JDBC para MySQL, construida a partir del servidor y la base de datos.
     */
    private final String CADENA_CONEXION = "jdbc:mysql://" + SERVER + "/" + BASE_DATOS;

    /**
     * El nombre de usuario para autenticarse en la base de datos.
     */
    private final String USUARIO = "root";

    /**
     * La contraseña para el usuario de la base de datos.
     * 
     */
    private final String CONTRASEÑA = "Ensalada";

    /**
     * Establece y retorna una nueva conexión a la base de datos Finanzas Globales.
     * Utiliza los parámetros de conexión definidos en esta clase.
     *
     * @return Un objeto {@link Connection} que representa la conexión establecida con la base de datos.
     * @throws SQLException Si ocurre un error al intentar establecer la conexión con la base de datos.
     */
    @Override
    public Connection crearConexion() throws SQLException {
        // Establece la conexión a la base de datos utilizando el DriverManager de JDBC.
        Connection conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, CONTRASEÑA);
        return conexion;
    }
}
