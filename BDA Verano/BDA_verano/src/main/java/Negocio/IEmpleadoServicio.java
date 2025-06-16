package Negocio;

import Dominio.EmpleadoDominio;
import java.util.List;

public interface IEmpleadoServicio {
    EmpleadoDominio crearEmpleado(EmpleadoDominio empleado);
    EmpleadoDominio actualizarEmpleado(EmpleadoDominio empleado);
    EmpleadoDominio obtenerEmpleadoPorId(int id);
    List<EmpleadoDominio> obtenerTodosLosEmpleados();
}
