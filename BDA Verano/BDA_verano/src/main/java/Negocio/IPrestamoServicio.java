package Negocio;

import DTO.PrestamoDTO;
import Persistencia.PersistenciaException;
import java.sql.SQLException;
import java.util.List;

public interface IPrestamoServicio {
    PrestamoDTO solicitarPrestamo(PrestamoDTO prestamo) throws PersistenciaException;
    PrestamoDTO autorizarPrestamo(int id, int idJefeAutoriza, boolean autorizado) throws PersistenciaException;
    PrestamoDTO obtenerPrestamoPorId(int id) throws SQLException;
    List<PrestamoDTO> obtenerPrestamosPorEmpleado(int idEmpleado) throws PersistenciaException;
}
