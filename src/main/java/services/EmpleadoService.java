package services;

import dao.EmpleadoDAO;
import entities.Empleado;

public class EmpleadoService {
    private final EmpleadoDAO empleadoDAO;

    public EmpleadoService(EmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }

    public void crearEmpleado(Empleado empleado){
        empleadoDAO.saveEmpleado(empleado);
    }
}
