package Persistencia;

import Dominio.AbonoDominio;
import java.sql.SQLException;
import java.util.List;

public interface IAbonoDAO {
    AbonoDominio crearAbono(AbonoDominio abono) throws PersistenciaException;
    AbonoDominio obtenerAbonoPorId(int id) throws PersistenciaException;
    List<AbonoDominio> obtenerAbonosPorPrestamo(int idPrestamo) throws PersistenciaException;
}
