package dao;

import entities.Departamento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DepartamentoDAO {
    private final SessionFactory sessionFactory;

    public DepartamentoDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveDepartamento(Departamento departamento){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(departamento);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Departamento getDepartamentoById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Departamento.class, id);
        }finally {
            session.close();
        }
    }

    public List<Departamento> getAllDepartamentos() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM Departamento", Departamento.class).list();
        } finally {
            session.close();
        }
    }

    public void updateDepartamento(Departamento departamento) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(departamento);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
    }

    public void deleteDepartamento(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Departamento departamento = session.get(Departamento.class, id);
            if (departamento != null) {
                session.delete(departamento);
                transaction.commit();
            }
        }catch (Exception e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
    }
}
