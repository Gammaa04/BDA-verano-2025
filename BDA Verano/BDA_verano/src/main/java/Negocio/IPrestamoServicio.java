package Negocio;

import DTO.PrestamoDTO;
import java.sql.SQLException;
import java.util.List;

public interface IPrestamoServicio {
    PrestamoDTO solicitarPrestamo(PrestamoDTO prestamo) throws SQLException;
    PrestamoDTO autorizarPrestamo(int id, int idJefeAutoriza, boolean autorizado) throws SQLException;
    PrestamoDTO obtenerPrestamoPorId(int id) throws SQLException;
    List<PrestamoDTO> obtenerPrestamosPorEmpleado(int idEmpleado) throws SQLException;
}
