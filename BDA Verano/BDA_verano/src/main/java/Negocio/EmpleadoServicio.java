package Negocio;

import Dominio.DepartamentoDominio;
import Dominio.EmpleadoDominio;
import Dominio.EstadoEmpleado;
import Dominio.TipoEmpleado;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpleadoServicio implements IEmpleadoServicio {

   
    private static final List<EmpleadoDominio> empleadosBD = new ArrayList<>();
    private static int idCounter = 1;

    @Override
    public EmpleadoDominio crearEmpleado(EmpleadoDominio empleado) {
        // Validaciones
        validarEmpleado(empleado);
        validarUsuarioUnico(empleado.getUsuario(), null);

       
        empleado.setId(idCounter++);
        // Guardar en la "base de datos"
        empleadosBD.add(empleado);
        return empleado;
    }

    @Override
    public EmpleadoDominio actualizarEmpleado(EmpleadoDominio empleado) {
        // Validaciones
        validarEmpleado(empleado);
        validarUsuarioUnico(empleado.getUsuario(), empleado.getId());

        // Buscar el empleado existente
        Optional<EmpleadoDominio> existente = empleadosBD.stream()
                .filter(e -> e.getId() == empleado.getId())
                .findFirst();

        if (existente.isEmpty()) {
            throw new IllegalArgumentException("El empleado con ID " + empleado.getId() + " no existe");
        }

        // Actualizar los datos
        EmpleadoDominio empleadoExistente = existente.get();
        empleadoExistente.setNombreCompleto(empleado.getNombreCompleto());
        empleadoExistente.setEstado(empleado.getEstado());
        empleadoExistente.setUsuario(empleado.getUsuario());
        empleadoExistente.setContrasena(empleado.getContrasena());
        empleadoExistente.setDepartamento(empleado.getDepartamento());
        empleadoExistente.setTipo(empleado.getTipo());

        return empleadoExistente;
    }

    @Override
    public EmpleadoDominio obtenerEmpleadoPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor a cero");
        }

        Optional<EmpleadoDominio> empleado = empleadosBD.stream()
                .filter(e -> e.getId() == id)
                .findFirst();

        return empleado.orElseThrow(() -> new IllegalArgumentException("No se encontró un empleado con ID " + id));
    }

    @Override
    public List<EmpleadoDominio> obtenerTodosLosEmpleados() {
        return new ArrayList<>(empleadosBD);
    }

    private void validarEmpleado(EmpleadoDominio empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }
        if (empleado.getNombreCompleto() == null || empleado.getNombreCompleto().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre completo no puede estar vacío");
        }
        if (empleado.getUsuario() == null || empleado.getUsuario().trim().isEmpty()) {
            throw new IllegalArgumentException("El usuario no puede estar vacío");
        }
        if (empleado.getContrasena() == null || empleado.getContrasena().trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía");
        }
        if (empleado.getDepartamento() == null) {
            throw new IllegalArgumentException("El departamento no puede ser nulo");
        }
        if (empleado.getTipo() == null) {
            throw new IllegalArgumentException("El tipo de empleado no puede ser nulo");
        }
        if (empleado.getEstado() == null) {
            throw new IllegalArgumentException("El estado del empleado no puede ser nulo");
        }
    }

    private void validarUsuarioUnico(String usuario, Integer id) {
        boolean usuarioExiste = empleadosBD.stream()
                .anyMatch(e -> e.getUsuario().equals(usuario) && (id == null || e.getId() != id));
        if (usuarioExiste) {
            throw new IllegalArgumentException("El usuario " + usuario + " ya está registrado");
        }
    }
}
