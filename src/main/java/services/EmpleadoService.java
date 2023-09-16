package services;

import dao.EmpleadoDAO;
import entities.Empleado;

import java.util.List;

public class EmpleadoService {
    private final EmpleadoDAO empleadoDAO;

    public EmpleadoService(EmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }

    public void crearEmpleado(Empleado empleado){
        empleadoDAO.saveEmpleado(empleado);
    }

    public List<Empleado> obtenerTodosLosEmpleados(){
        return empleadoDAO.getAllEmpleados();
    }

    public void editarEmpleado(Empleado empleado){
        empleadoDAO.updateEmpleado(empleado);
    }

    public void eliminarEmpleado(Long id){
        empleadoDAO.deleteEmpleado(id);
    }
}
