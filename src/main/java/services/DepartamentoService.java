package services;

import dao.DepartamentoDAO;
import entities.Departamento;

public class DepartamentoService {
    private final DepartamentoDAO departamentoDAO;

    public DepartamentoService(DepartamentoDAO departamentoDAO) {
        this.departamentoDAO = departamentoDAO;
    }

    public void crearDepartamento(Departamento departamento){
        departamentoDAO.saveDepartamento(departamento);
    }
}
