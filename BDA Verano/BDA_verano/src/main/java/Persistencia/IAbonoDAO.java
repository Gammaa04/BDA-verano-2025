package Persistencia;

import Dominio.AbonoDominio;
import java.sql.SQLException;
import java.util.List;

public interface IAbonoDAO {
    AbonoDominio crearAbono(AbonoDominio abono) throws SQLException;
    AbonoDominio obtenerAbonoPorId(int id) throws SQLException;
    List<AbonoDominio> obtenerAbonosPorPrestamo(int idPrestamo) throws SQLException;
}
