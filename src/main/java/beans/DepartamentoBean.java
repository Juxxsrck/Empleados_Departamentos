package beans;

import entities.Departamento;
import services.DepartamentoService;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@RequestScoped
public class DepartamentoBean {

    @Inject
    private DepartamentoService departamentoService;

    private Departamento nuevoDepartamento;
    private List<Departamento> listaDepartamentos;

    @PostConstruct
    public void init() {
        nuevoDepartamento = new Departamento();
        cargarListaDepartamentos();
    }

    public void cargarListaDepartamentos(){
        listaDepartamentos = departamentoService.obtenetTodosLosDepartamentos();
    }

    public String crearDepartamento(){
        departamentoService.crearDepartamento(nuevoDepartamento);
        nuevoDepartamento = new Departamento();
        cargarListaDepartamentos();
        return "departamentos.xhtml";
    }

    public void editarDepartamento(Departamento departamento){
        departamentoService.editarDepartamento(departamento);
    }

    public void eliminarDepartamento(Departamento departamento){
        departamentoService.eliminarDepartamento(departamento.getId());
        cargarListaDepartamentos();
    }

    public Departamento getNuevoDepartamento(){
        return nuevoDepartamento;
    }

    public void setNuevoDepartamento(Departamento nuevoDepartamento){
        this.nuevoDepartamento = nuevoDepartamento;
    }

    public List<Departamento> getListaDepartamentos(){
        return listaDepartamentos;
    }
}
