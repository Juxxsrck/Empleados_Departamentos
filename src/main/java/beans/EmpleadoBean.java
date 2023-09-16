package beans;

import entities.Empleado;
import entities.Empleado;
import services.EmpleadoService;
import services.EmpleadoService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

public class EmpleadoBean {

    @Inject
    private EmpleadoService empleadoService;

    private Empleado nuevoEmpleado;
    private List<Empleado> listaEmpleados;

    @PostConstruct
    public void init() {
        nuevoEmpleado = new Empleado();
        cargarListaEmpleados();
    }

    public void cargarListaEmpleados(){
        listaEmpleados = empleadoService.obtenerTodosLosEmpleados();
    }

    public void crearEmpleado(){
        empleadoService.crearEmpleado(nuevoEmpleado);
        nuevoEmpleado = new Empleado();
        cargarListaEmpleados();
    }

    public void editarEmpleado(Empleado empleado){
        empleadoService.editarEmpleado(empleado);
    }

    public void eliminarEmpleado(Empleado empleado){
        empleadoService.eliminarEmpleado(empleado.getId());
        cargarListaEmpleados();
    }

    public Empleado getNuevoEmpleado(){
        return nuevoEmpleado;
    }

    public void setNuevoEmpleado(Empleado nuevoEmpleado){
        this.nuevoEmpleado = nuevoEmpleado;
    }

    public List<Empleado> getListaEmpleados(){
        return listaEmpleados;
    }
}
