package Persistencia;

import Dominio.PrestamoDominio;
import java.sql.SQLException;
import java.util.List;

public interface IPrestamoDAO {
    PrestamoDominio crearPrestamo(PrestamoDominio prestamo) throws PersistenciaException;
    PrestamoDominio actualizarPrestamo(PrestamoDominio prestamo) throws PersistenciaException;
    PrestamoDominio obtenerPrestamoPorId(int id) throws PersistenciaException;
    List<PrestamoDominio> obtenerPrestamosPorEmpleado(int idEmpleado) throws PersistenciaException;
    List<PrestamoDominio> obtenerTodosLosPrestamos() throws PersistenciaException;
}
