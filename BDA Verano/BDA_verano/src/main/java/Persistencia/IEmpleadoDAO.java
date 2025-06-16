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
 * Interfaz que define el contrato para las operaciones de acceso a datos (DAO)
 * relacionadas con la entidad **Empleado**.
 * 
 * @author Jesus Gammael Soto Escalante 248336
 */
public interface IEmpleadoDAO {

    /**
     * Busca y retorna un objeto {@link EmpleadoDominio} por su identificador único.
     * 
     *
     * @param id El **identificador único** del empleado a buscar.
     * @return Un objeto {@link EmpleadoDominio} que corresponde al ID proporcionado,
     * o {@code null} si no se encuentra ningún empleado con ese ID.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    EmpleadoDominio buscarID(int id) throws PersistenciaException;

    /**
     * Modifica los datos de un empleado existente en la base de datos.
     *
     *
     * @param empleado El objeto {@link EmpleadoDTO} con la información actualizada del empleado.
     * Se espera que el ID dentro del DTO sea válido y corresponda a un empleado existente.
     * @return El objeto {@link EmpleadoDominio} actualizado después de la operación de modificación.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos,
     * o si el empleado no se encuentra para ser modificado.
     */
    EmpleadoDominio modificarEmpleado(EmpleadoDTO empleado) throws PersistenciaException;

    /**
     * Crea un nuevo empleado en la base de datos y establece su relación con un jefe.
     *
     *
     * @param empleado El objeto {@link EmpleadoDominio} con los datos del nuevo empleado a crear.
     * @param idJefe El **identificador único del jefe** al que se asignará este nuevo empleado.
     * Puede ser 0 o un valor específico si no hay un jefe directo inicial o se asigna más tarde.
     * @return El objeto {@link EmpleadoDominio} creado, incluyendo su ID generado por la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos,
     * por ejemplo, si el nombre de usuario ya existe o hay un problema con el ID del jefe.
     */
    EmpleadoDominio crearEmpleado(EmpleadoDominio empleado, int idJefe) throws PersistenciaException;

    /**
     * Busca y retorna una lista paginada y filtrada de empleados.
     * Este método es ideal para la visualización de datos en tablas, ya que permite
     * aplicar un límite de resultados, un desplazamiento y un criterio de filtro textual.
     *
     * @param filtros El objeto {@link FiltroTablaEmpleadoDTO} que contiene los parámetros
     * de paginación (límite y desplazamiento) y el criterio de filtro.
     * @return Una {@link List} de objetos {@link EmpleadoDTO} que cumplen con los criterios de búsqueda y paginación.
     * @throws PersistenciaException Si ocurre un error durante la operación de acceso a datos.
     */
    List<EmpleadoDTO> buscarTabla(FiltroTablaEmpleadoDTO filtros) throws PersistenciaException;

}
