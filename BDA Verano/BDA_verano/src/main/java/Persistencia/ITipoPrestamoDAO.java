package Persistencia;

import Dominio.TipoPrestamoDominio;
import java.sql.SQLException;
import java.util.List;

public interface ITipoPrestamoDAO {
    TipoPrestamoDominio crearTipoPrestamo(TipoPrestamoDominio tipoPrestamo) throws PersistenciaException;
    TipoPrestamoDominio actualizarTipoPrestamo(TipoPrestamoDominio tipoPrestamo) throws PersistenciaException;
    TipoPrestamoDominio obtenerTipoPrestamoPorId(int id) throws PersistenciaException;
    List<TipoPrestamoDominio> obtenerTodosLosTiposPrestamo() throws PersistenciaException;
}
