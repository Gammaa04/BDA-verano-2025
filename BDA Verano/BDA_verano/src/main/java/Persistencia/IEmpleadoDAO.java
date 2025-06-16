/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import DTO.EmpleadoDTO;
import DTO.FiltroTablaEmpleadoDTO;
import Dominio.EmpleadoDominio;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public interface IEmpleadoDAO {

    EmpleadoDominio buscarID(int id) throws PersistenciaException;

    EmpleadoDominio modificarEmpleado(EmpleadoDTO empleado) throws PersistenciaException;

    EmpleadoDominio crearEmpleado(EmpleadoDominio empleado, int idJefe) throws PersistenciaException;

    List<EmpleadoDTO> buscarTabla(FiltroTablaEmpleadoDTO filtros) throws PersistenciaException;

}
