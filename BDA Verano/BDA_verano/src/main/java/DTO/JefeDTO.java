package DTO;

/**
 * Data Transfer Object (DTO) que representa a un **Jefe**.
 * Esta clase se utiliza para transferir información sobre un jefe
 * entre las diferentes capas de la aplicación. Su principal función es
 * establecer la relación entre un identificador de jefe y el identificador
 * del empleado que ocupa ese rol, manteniendo el DTO ligero y desacoplado
 * de la entidad de dominio completa del empleado.
 *
 * @author Angel Gabriel Beltran Duarte
 */
public class JefeDTO {
    /**
     * El **identificador único** del jefe. Este ID podría ser el mismo que el
     * ID del empleado si el rol de jefe es simplemente una extensión de la entidad Empleado.
     */
    private int id;

    /**
     * El **identificador del empleado** que ostenta el cargo de jefe.
     * Esto refuerza la regla de negocio de que "todos los jefes deben ser empleados".
     */
    private int empleadoId;

    /**
     * Constructor por defecto de la clase JefeDTO.
     * Permite crear una instancia de JefeDTO sin inicializar sus atributos,
     * los cuales pueden ser establecidos posteriormente mediante los métodos setters.
     */
    public JefeDTO() {
    }

    /**
     * Constructor parametrizado de la clase JefeDTO.
     * Inicializa una nueva instancia de JefeDTO con los identificadores especificados.
     *
     * @param id El **identificador único** del jefe.
     * @param empleadoId El **ID del empleado** asociado a este jefe.
     */
    public JefeDTO(int id, int empleadoId) {
        this.id = id;
        this.empleadoId = empleadoId;
    }

    /**
     * Obtiene el **identificador único** del jefe.
     *
     * @return El **ID del jefe**.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el **identificador único** del jefe.
     *
     * @param id El nuevo **ID del jefe**.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el **identificador del empleado** que ostenta el cargo de jefe.
     *
     * @return El **ID del empleado** asociado.
     */
    public int getEmpleadoId() {
        return empleadoId;
    }

    /**
     * Establece el **identificador del empleado** que ostenta el cargo de jefe.
     *
     * @param empleadoId El nuevo **ID del empleado** asociado.
     */
    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    /**
     * Retorna una representación en cadena (String) del objeto JefeDTO.
     * Incluye los valores de sus atributos para facilitar la depuración y el registro.
     *
     * @return Una cadena que representa el estado del objeto JefeDTO.
     */
    @Override
    public String toString() {
        return "JefeDTO{" +
               "id=" + id +
               ", empleadoId=" + empleadoId +
               '}';
    }
}
