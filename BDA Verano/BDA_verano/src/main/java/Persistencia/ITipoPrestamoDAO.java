package Persistencia;

import Dominio.TipoPrestamoDominio;
import java.sql.SQLException;
import java.util.List;

public interface ITipoPrestamoDAO {
    TipoPrestamoDominio crearTipoPrestamo(TipoPrestamoDominio tipoPrestamo) throws SQLException;
    TipoPrestamoDominio actualizarTipoPrestamo(TipoPrestamoDominio tipoPrestamo) throws SQLException;
    TipoPrestamoDominio obtenerTipoPrestamoPorId(int id) throws SQLException;
    List<TipoPrestamoDominio> obtenerTodosLosTiposPrestamo() throws SQLException;
}
