/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package PRUEBAS;

import DTO.EmpleadoDTO;
import Dominio.AbonoDominio;
import Dominio.CuentaDepartamentoDominio;
import Dominio.CuentaEmpleadoDominio;
import Dominio.DepartamentoDominio;
import Dominio.EmpleadoDominio;
import Dominio.EstadoCuenta;
import Dominio.EstadoEmpleado;
import Dominio.EstatusPrestamo;
import Dominio.HistorialEstatusPrestamoDominio;
import Dominio.JefeDominio;
import Dominio.PrestamoDominio;
import Dominio.TipoEmpleado;
import Dominio.TipoPrestamoDominio;
import Persistencia.AbonoDAO;
import Persistencia.ConexionBD;
import Persistencia.CuentaDepartamentoDAO;
import Persistencia.CuentaEmpleadoDAO;
import Persistencia.DepartamentoDAO;
import Persistencia.EmpleadoDAO;
import Persistencia.HistorialEstatusPrestamoDAO;
import Persistencia.IAbonoDAO;
import Persistencia.IConexionBD;
import Persistencia.ICuentaDepartamentoDAO;
import Persistencia.ICuentaEmpleadoDAO;
import Persistencia.IDepartamentoDAO;
import Persistencia.IEmpleadoDAO;
import Persistencia.IHistorialEstatusPrestamoDAO;
import Persistencia.IPrestamoDAO;
import Persistencia.ITipoPrestamoDAO;
import Persistencia.PersistenciaException;
import Persistencia.PrestamoDAO;
import Persistencia.TipoPrestamoDAO;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;
import javax.crypto.AEADBadTagException;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class BDA_verano {

    
    public static void main(String[] args) {
        try {
            // ✅ Inicializar la conexión a la base de datos
            IConexionBD conexionBD = new ConexionBD(); // Verifica que esté bien configurado
            ITipoPrestamoDAO tipoPrestamoDAO = new TipoPrestamoDAO(conexionBD);

            // ✅ Crear un nuevo tipo de préstamo
            TipoPrestamoDominio nuevoTipo = new TipoPrestamoDominio(
                0, // Se asignará automáticamente el ID
                "Hipotecario",
                360
            );

            TipoPrestamoDominio tipoCreado = tipoPrestamoDAO.crearTipoPrestamo(nuevoTipo);
            System.out.println("✅ Tipo de préstamo creado exitosamente: " + tipoCreado);

            // ✅ Obtener un tipo de préstamo por ID
            int idTipo = tipoCreado.getId();
            TipoPrestamoDominio tipoPorId = tipoPrestamoDAO.obtenerTipoPrestamoPorId(idTipo);
            if (tipoPorId != null) {
                System.out.println("📌 Tipo de préstamo obtenido por ID: " + tipoPorId);
            } else {
                System.out.println("❌ No se encontró el tipo de préstamo con ID " + idTipo);
            }

            // ✅ Actualizar un tipo de préstamo
            tipoPorId.setNombre("Hipotecario Premium");
            tipoPorId.setMaxParcialidades(400);
            TipoPrestamoDominio tipoActualizado = tipoPrestamoDAO.actualizarTipoPrestamo(tipoPorId);
            System.out.println("🔄 Tipo de préstamo actualizado exitosamente: " + tipoActualizado);

            // ✅ Obtener todos los tipos de préstamo
            List<TipoPrestamoDominio> tiposPrestamo = tipoPrestamoDAO.obtenerTodosLosTiposPrestamo();
            System.out.println("📌 Todos los tipos de préstamo disponibles:");
            for (TipoPrestamoDominio tipo : tiposPrestamo) {
                System.out.println(tipo);
            }

        } catch (PersistenciaException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}

