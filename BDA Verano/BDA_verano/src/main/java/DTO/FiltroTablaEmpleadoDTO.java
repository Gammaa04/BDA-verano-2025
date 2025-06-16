package DTO;

/**
 * Data Transfer Object (DTO) que encapsula los parámetros para **filtrar y paginar**
 * los resultados de una tabla de empleados. Esta clase es ideal para enviar
 * criterios de búsqueda y opciones de paginación (límite y desplazamiento)
 * desde la capa de presentación o una solicitud de cliente hacia la capa de negocio
 * o de datos. Permite una recuperación eficiente de subconjuntos de datos
 * de empleados, aplicando filtros según un texto dado.
 *
 * @author Angel Gabriel Beltran Duarte
 */
public class FiltroTablaEmpleadoDTO {
    /**
     * El **número máximo de registros** a devolver en el resultado de la consulta.
     * Esto se utiliza para la paginación.
     */
    private int limit;

    /**
     * El **número de registros a omitir** desde el inicio del conjunto de resultados.
     * Esto se utiliza junto con `limit` para implementar la paginación (ej. para obtener la segunda página, se omite el `limit` de la primera).
     */
    private int offset;

    /**
     * El **criterio de filtro** (cadena de texto) a aplicar a los datos de los empleados.
     * Este filtro podría usarse para buscar por nombre, apellido, usuario, etc., dependiendo de la lógica de negocio.
     */
    private String filtro;

    /**
     * Constructor parametrizado de la clase FiltroTablaEmpleadoDTO.
     * Inicializa una nueva instancia de FiltroTablaEmpleadoDTO con los parámetros
     * de paginación y filtro especificados.
     *
     * @param limit El **límite** de registros a devolver.
     * @param offset El **desplazamiento** de registros a omitir.
     * @param filtro La **cadena de texto** a utilizar como filtro.
     */
    public FiltroTablaEmpleadoDTO(int limit, int offset, String filtro) {
        this.limit = limit;
        this.offset = offset;
        this.filtro = filtro;
    }

    /**
     * Obtiene el **límite** de registros a devolver.
     *
     * @return El número máximo de registros.
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Establece el **límite** de registros a devolver.
     *
     * @param limit El nuevo número máximo de registros.
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * Obtiene el **desplazamiento** de registros a omitir.
     *
     * @return El número de registros a omitir.
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Establece el **desplazamiento** de registros a omitir.
     *
     * @param offset El nuevo número de registros a omitir.
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * Obtiene el **criterio de filtro** aplicado.
     *
     * @return La cadena de texto del filtro.
     */
    public String getFiltro() {
        return filtro;
    }

    /**
     * Establece el **criterio de filtro** a aplicar.
     *
     * @param filtro La nueva cadena de texto para el filtro.
     */
    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    /**
     * Retorna una representación en cadena (String) del objeto FiltroTablaEmpleadoDTO.
     * Incluye los valores de sus atributos para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto FiltroTablaEmpleadoDTO.
     */
    @Override
    public String toString() {
        return "FiltroTablaEmpleadoDTO{" +
               "limit=" + limit +
               ", offset=" + offset +
               ", filtro='" + filtro + '\'' +
               '}';
    }
}
