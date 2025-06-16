package Persistencia;

import Dominio.PrestamoDominio;
import java.sql.SQLException;
import java.util.List;

public interface IPrestamoDAO {
    PrestamoDominio crearPrestamo(PrestamoDominio prestamo) throws SQLException;
    PrestamoDominio actualizarPrestamo(PrestamoDominio prestamo) throws SQLException;
    PrestamoDominio obtenerPrestamoPorId(int id) throws SQLException;
    List<PrestamoDominio> obtenerPrestamosPorEmpleado(int idEmpleado) throws SQLException;
    List<PrestamoDominio> obtenerTodosLosPrestamos() throws SQLException;
}
