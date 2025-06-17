package Persistencia;

import Dominio.HistorialEstatusPrestamoDominio;
import java.sql.SQLException;
import java.util.List;

public interface IHistorialEstatusPrestamoDAO {
    HistorialEstatusPrestamoDominio crearHistorialEstatus(HistorialEstatusPrestamoDominio historial) throws PersistenciaException;
    List<HistorialEstatusPrestamoDominio> obtenerHistorialPorPrestamo(int idPrestamo) throws PersistenciaException;
}
