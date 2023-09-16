package services;

import dao.DepartamentoDAO;
import entities.Departamento;

import java.util.List;

public class DepartamentoService {
    private final DepartamentoDAO departamentoDAO;

    public DepartamentoService(DepartamentoDAO departamentoDAO) {
        this.departamentoDAO = departamentoDAO;
    }

    public void crearDepartamento(Departamento departamento){
        departamentoDAO.saveDepartamento(departamento);
    }

    public List<Departamento> obtenetTodosLosDepartamentos() {
        return departamentoDAO.getAllDepartamentos();
    }

    public void editarDepartamento(Departamento departamento) {
        departamentoDAO.updateDepartamento(departamento);
    }

    public void eliminarDepartamento(Long id) {
        departamentoDAO.deleteDepartamento(id);
    }
}
